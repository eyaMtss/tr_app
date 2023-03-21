package com.tunidesign.dbuserprovider.persistence;

import com.tunidesign.dbuserprovider.DBUserStorageException;
import com.tunidesign.dbuserprovider.model.QueryConfigurations;
import com.tunidesign.dbuserprovider.util.PagingUtil;
import lombok.extern.jbosslog.JBossLog;
import org.apache.commons.lang3.NotImplementedException;
import org.keycloak.models.UserModel;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.function.Function;


@JBossLog
public class UserRepository {
    
    
    private DataSourceProvider  dataSourceProvider;
    private QueryConfigurations queryConfigurations;
    
    public UserRepository(DataSourceProvider dataSourceProvider, QueryConfigurations queryConfigurations) {
        this.dataSourceProvider  = dataSourceProvider;
        this.queryConfigurations = queryConfigurations;
    }

    private boolean updateQuery(String updateQuery, String username, String password) {
        //String updateQuery = "UPDATE my_table SET column1 = ?, column2 = ? WHERE id = ?";
        Optional<DataSource> dataSourceOpt = dataSourceProvider.getDataSource();
        if (dataSourceOpt.isPresent()) {
            DataSource dataSource = dataSourceOpt.get();
            try (Connection c = dataSource.getConnection()) {
                try (PreparedStatement stmt = c.prepareStatement(updateQuery)) {
                    stmt.setString(1, password);
                    stmt.setString(2, password);
                    stmt.setString(3, username);
                    int rowsUpdated = stmt.executeUpdate();
                    log.infov("Updated " + rowsUpdated + " rows");
                    System.out.println("Updated " + rowsUpdated + " rows");
                    return true;
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }
    private <T> T doQuery(String query, PagingUtil.Pageable pageable, Function<ResultSet, T> resultTransformer, Object... params) {
        Optional<DataSource> dataSourceOpt = dataSourceProvider.getDataSource();
        if (dataSourceOpt.isPresent()) {
            DataSource dataSource = dataSourceOpt.get();
            try (Connection c = dataSource.getConnection()) {
                if (pageable != null) {
                    query = PagingUtil.formatScriptWithPageable(query, pageable, queryConfigurations.getRDBMS());
                }
                log.infov("Query: {0} params: {1} ", query, Arrays.toString(params));
                try (PreparedStatement statement = c.prepareStatement(query)) {
                    if (params != null) {
                        for (int i = 1; i <= params.length; i++) {
                            statement.setObject(i, params[i - 1]);
                        }
                    }
                    try (ResultSet rs = statement.executeQuery()) {
                        return resultTransformer.apply(rs);
                    }
                }
            } catch (SQLException e) {
                log.error(e.getMessage(), e);
            }
            return null;
        }
        return null;
    }
    public void doQuery2(String query, UserModel user) {
        Optional<DataSource> dataSourceOpt = dataSourceProvider.getDataSource();
        if (dataSourceOpt.isPresent()) {
            DataSource dataSource = dataSourceOpt.get();
            try (Connection c = dataSource.getConnection()) {

                try (PreparedStatement statement = c.prepareStatement(query)) {
                    Random rand = new Random();
                    int int_random = rand.nextInt(1000000000);

                    statement.setInt(1, int_random);
                    statement.setString(2, user.getUsername());
                    statement.setString(3, user.getAttribute("firstName").toString());
                    statement.setString(4, user.getAttribute("lastName").toString());
                    statement.setString(5, user.getAttribute("email").toString());
                    statement.setString(6, user.getAttribute("password").toString());
                    statement.setString(7, user.getAttribute("password").toString());
                    statement.executeUpdate();

                }
            } catch (SQLException e) {
                log.error(e.getMessage(), e);
            }
        }
    }
    private List<Map<String, String>> readMap(ResultSet rs) {
        try {
            List<Map<String, String>> data         = new ArrayList<>();
            Set<String>               columnsFound = new HashSet<>();
            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                String columnLabel = rs.getMetaData().getColumnLabel(i);
                columnsFound.add(columnLabel);
            }
            while (rs.next()) {
                Map<String, String> result = new HashMap<>();
                for (String col : columnsFound) {
                    result.put(col, rs.getString(col));
                }
                data.add(result);
            }
            return data;
        } catch (Exception e) {
            throw new DBUserStorageException(e.getMessage(), e);
        }
    }
    
    
    private Integer readInt(ResultSet rs) {
        try {
            return rs.next() ? rs.getInt(1) : null;
        } catch (Exception e) {
            throw new DBUserStorageException(e.getMessage(), e);
        }
    }
    
    private Boolean readBoolean(ResultSet rs) {
        try {
            return rs.next() ? rs.getBoolean(1) : null;
        } catch (Exception e) {
            throw new DBUserStorageException(e.getMessage(), e);
        }
    }
    
    private String readString(ResultSet rs) {
        try {
            return rs.next() ? rs.getString(1) : null;
        } catch (Exception e) {
            throw new DBUserStorageException(e.getMessage(), e);
        }
    }
    
    public List<Map<String, String>> getAllUsers() {
        return doQuery(queryConfigurations.getListAll(), null, this::readMap);
    }
    
    public int getUsersCount(String search) {
        if (search == null || search.isEmpty()) {
            return Optional.ofNullable(doQuery(queryConfigurations.getCount(), null, this::readInt)).orElse(0);
        } else {
            String query = String.format("select count(*) from (%s) count", queryConfigurations.getFindBySearchTerm());
            return Optional.ofNullable(doQuery(query, null, this::readInt, search)).orElse(0);
        }
    }
    
    
    public Map<String, String> findUserById(String id) {
        return Optional.ofNullable(doQuery(queryConfigurations.getFindById(), null, this::readMap, id))
                       .orElse(Collections.emptyList())
                       .stream().findFirst().orElse(null);
    }
    
    public Optional<Map<String, String>> findUserByUsername(String username) {
        return Optional.ofNullable(doQuery(queryConfigurations.getFindByUsername(), null, this::readMap, username))
                       .orElse(Collections.emptyList())
                       .stream().findFirst();
    }
    
    public List<Map<String, String>> findUsers(String search, PagingUtil.Pageable pageable) {
        if (search == null || search.isEmpty()) {
            return doQuery(queryConfigurations.getListAll(), pageable, this::readMap);
        }
        return doQuery(queryConfigurations.getFindBySearchTerm(), pageable, this::readMap, search);
    }
    
    public boolean validateCredentials(String username, String password) {
        String hash = Optional.ofNullable(doQuery(queryConfigurations.getFindPasswordHash(), null, this::readString, username)).orElse("");
        return password.equals(hash);
        /*if (queryConfigurations.isBlowfish()) {
            return !hash.isEmpty() && BCrypt.checkpw(password, hash);
        } else {

           String hashFunction = queryConfigurations.getHashFunction();

            if(hashFunction.equals("PBKDF2-SHA256")){
                String[] components = hash.split("\\$");
                return new PBKDF2SHA256HashingUtil(password, components[1], Integer.valueOf(components[0])).validatePassword(components[2]);
            }

            MessageDigest digest   = DigestUtils.getDigest(hashFunction);
            byte[]        pwdBytes = StringUtils.getBytesUtf8(password);
            return Objects.equals(Hex.encodeHexString(digest.digest(pwdBytes)), hash);
        }*/
    }
    
    public boolean updateCredentials(UserModel user, String password) {
        String username = user.getUsername();
        // update query
        String updateQuery = "UPDATE users SET password = ?, confirm_password = ? WHERE username = ?";
        // Send the new password to the user via email, SMS, etc.
        //sendNewPasswordToUser(password, user); // Implement your own method to send the new password to the user
        return updateQuery(updateQuery, username, password);
        //throw new NotImplementedException("Password update not supported");
    }

    /*public void sendNewPasswordToUser(){
        try {
            EmailSenderProvider emailSenderProvider = session.getProvider(EmailSenderProvider.class, "default");
            String subject = "Password reset request for " + realm.getName();
            String body = "Dear " + user.getFirstName() + ",\n\n"
                    + "You have requested to reset your password for your account with " + realm.getName() + ".\n\n"
                    + "Your new password is: " + user.getGeneratedPassword() + "\n\n"
                    + "Please use the following link to log in and change your password: " + redirectUri + "\n\n"
                    + "Thank you,\n" + realm.getName();
            emailSenderProvider.send(realm.getSmtpConfig(), user.getEmail(), subject, body);
        } catch (EmailException e) {
            logger.error("Failed to send password reset email to user " + user.getUsername(), e);
        }
    }*/
    public boolean removeUser() {
        return queryConfigurations.getAllowKeycloakDelete();
    }
}
