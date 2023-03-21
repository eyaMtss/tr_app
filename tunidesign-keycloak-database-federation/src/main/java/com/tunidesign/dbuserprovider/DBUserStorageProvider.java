package com.tunidesign.dbuserprovider;

import com.tunidesign.dbuserprovider.util.PasswordGenerator;
import lombok.extern.jbosslog.JBossLog;
import org.keycloak.component.ComponentModel;
import org.keycloak.credential.CredentialInput;
import org.keycloak.credential.CredentialInputUpdater;
import org.keycloak.credential.CredentialInputValidator;
import org.keycloak.credential.CredentialModel;
import org.keycloak.models.cache.CachedUserModel;
import org.keycloak.models.*;
import org.keycloak.models.credential.PasswordCredentialModel;
import org.keycloak.representations.idm.AuthenticatorConfigRepresentation;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserFederationProviderFactoryRepresentation;
import org.keycloak.representations.idm.UserFederationProviderRepresentation;
import org.keycloak.storage.StorageId;
import org.keycloak.storage.UserStorageProvider;
import org.keycloak.storage.federated.UserFederatedUserCredentialStore;
import org.keycloak.storage.user.UserLookupProvider;
import org.keycloak.storage.user.UserQueryProvider;
import org.keycloak.storage.user.UserRegistrationProvider;
import com.tunidesign.dbuserprovider.model.QueryConfigurations;
import com.tunidesign.dbuserprovider.model.UserAdapter;
import com.tunidesign.dbuserprovider.persistence.DataSourceProvider;
import com.tunidesign.dbuserprovider.persistence.UserRepository;
import com.tunidesign.dbuserprovider.util.PagingUtil;

import java.net.Authenticator;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@JBossLog
public class DBUserStorageProvider implements UserStorageProvider,
        UserLookupProvider, UserQueryProvider, CredentialInputUpdater, CredentialInputValidator,
        UserRegistrationProvider {

    private final KeycloakSession session;
    private final ComponentModel  model;
    private final UserRepository  repository;
    private final boolean allowDatabaseToOverwriteKeycloak;

    DBUserStorageProvider(KeycloakSession session, ComponentModel model, DataSourceProvider dataSourceProvider, QueryConfigurations queryConfigurations) {
        this.session    = session;
        this.model      = model;
        this.repository = new UserRepository(dataSourceProvider, queryConfigurations);
        this.allowDatabaseToOverwriteKeycloak = queryConfigurations.getAllowDatabaseToOverwriteKeycloak();
    }


    private List<UserModel> toUserModel(RealmModel realm, List<Map<String, String>> users) {
        return users.stream()
                .map(m -> new UserAdapter(session, realm, model, m, allowDatabaseToOverwriteKeycloak)).collect(Collectors.toList());
    }


    @Override
    public boolean supportsCredentialType(String credentialType) {
        return PasswordCredentialModel.TYPE.equals(credentialType);
    }

    @Override
    public boolean isConfiguredFor(RealmModel realm, UserModel user, String credentialType) {
        return supportsCredentialType(credentialType);
    }

    @Override
    public boolean isValid(RealmModel realm, UserModel user, CredentialInput input) {

        log.infov("isValid user credential: userId={0}", user.getId());

        if (!supportsCredentialType(input.getType()) || !(input instanceof UserCredentialModel)) {
            return false;
        }

        UserCredentialModel cred = (UserCredentialModel) input;

        UserModel dbUser = user;
        // If the cache just got loaded in the last 500 millisec (i.e. probably part of the actual flow), there is no point in reloading the user.)
        if (allowDatabaseToOverwriteKeycloak && user instanceof CachedUserModel && (System.currentTimeMillis() - ((CachedUserModel) user).getCacheTimestamp()) > 500) {
            dbUser = this.getUserById(user.getId(), realm);

            if (dbUser == null) {
                ((CachedUserModel) user).invalidate();
                return false;
            }

            // For now, we'll just invalidate the cache if username or email has changed. Eventually we could check all (or a parametered list of) attributes fetched from the DB.
            if (!java.util.Objects.equals(user.getUsername(), dbUser.getUsername()) || !java.util.Objects.equals(user.getEmail(), dbUser.getEmail())) {
                ((CachedUserModel) user).invalidate();
            }
        }
        return repository.validateCredentials(dbUser.getUsername(), cred.getChallengeResponse());
    }

    @Override
    public boolean updateCredential(RealmModel realm, UserModel user, CredentialInput input) {

        log.infov("updating credential: realm={0} user={1}", realm.getId(), user.getUsername());

        if (!supportsCredentialType(input.getType()) || !(input instanceof UserCredentialModel)) {
            return false;
        }

        UserCredentialModel cred = (UserCredentialModel) input;

        //return repository.updateCredentials(user, newPassword);
        return repository.updateCredentials(user, cred.getChallengeResponse());
    }

    /*@Override
    public boolean updateCredentialDirectly(RealmModel realm, UserModel user, CredentialInput input) {
        if (input.getType().equals(CredentialRepresentation.PASSWORD)) {
            PasswordGenerator passwordGenerator = new PasswordGenerator();

            // Generate a new password and update the user's credentials
            String newPassword = passwordGenerator.generatePassword();

            repository.updateCredentials(user, newPassword);

            // Send the new password to the user via email
            String emailAddress = user.getEmail();
            sendEmail(emailAddress, "New Password", "Your new password is: " + newPassword);

            return true;
        }

        return false;
    }*/

    @Override
    public void disableCredentialType(RealmModel realm, UserModel user, String credentialType) {
    }

    @Override
    public Set<String> getDisableableCredentialTypes(RealmModel realm, UserModel user) {
        return Collections.emptySet();
    }

    @Override
    public void preRemove(RealmModel realm) {

        log.infov("pre-remove realm");
    }

    @Override
    public void preRemove(RealmModel realm, GroupModel group) {

        log.infov("pre-remove group");
    }

    @Override
    public void preRemove(RealmModel realm, RoleModel role) {

        log.infov("pre-remove role");
    }

    @Override
    public void close() {
        log.debugv("closing");
    }

    @Override
    public UserModel getUserById(String id, RealmModel realm) {

        log.infov("lookup user by id: realm={0} userId={1}", realm.getId(), id);

        String externalId = StorageId.externalId(id);
        Map<String, String> user = repository.findUserById(externalId);

        if (user == null) {
            log.debugv("findUserById returned null, skipping creation of UserAdapter, expect login error");
            return null;
        } else {
            return new UserAdapter(session, realm, model, user, allowDatabaseToOverwriteKeycloak);
        }
    }

    @Override
    public UserModel getUserByUsername(String username, RealmModel realm) {

        log.infov("lookup user by username: realm={0} username={1}", realm.getId(), username);

        return repository.findUserByUsername(username).map(u -> new UserAdapter(session, realm, model, u, allowDatabaseToOverwriteKeycloak)).orElse(null);
    }

    @Override
    public UserModel getUserByEmail(String email, RealmModel realm) {

        log.infov("lookup user by username: realm={0} email={1}", realm.getId(), email);

        return getUserByUsername(email, realm);
    }

    @Override
    public int getUsersCount(RealmModel realm) {
        return repository.getUsersCount(null);
    }

    @Override
    public int getUsersCount(RealmModel realm, Set<String> groupIds) {
        return repository.getUsersCount(null);
    }

    @Override
    public int getUsersCount(RealmModel realm, String search) {
        return repository.getUsersCount(search);
    }

    @Override
    public int getUsersCount(RealmModel realm, String search, Set<String> groupIds) {
        return repository.getUsersCount(search);
    }

    @Override
    public int getUsersCount(RealmModel realm, Map<String, String> params) {
        return repository.getUsersCount(null);
    }

    @Override
    public int getUsersCount(RealmModel realm, Map<String, String> params, Set<String> groupIds) {
        return repository.getUsersCount(null);
    }

    @Override
    public int getUsersCount(RealmModel realm, boolean includeServiceAccount) {
        return repository.getUsersCount(null);
    }

    @Override
    public List<UserModel> getUsers(RealmModel realm) {
        log.infov("list users: realm={0}", realm.getId());
        return internalSearchForUser(null, realm, null);
    }

    @Override
    public List<UserModel> getUsers(RealmModel realm, int firstResult, int maxResults) {

        log.infov("list users: realm={0} firstResult={1} maxResults={2}", realm.getId(), firstResult, maxResults);
        return internalSearchForUser(null, realm, new PagingUtil.Pageable(firstResult, maxResults));
    }

    @Override
    public List<UserModel> searchForUser(String search, RealmModel realm) {
        log.infov("search for users: realm={0} search={1}", realm.getId(), search);
        return internalSearchForUser(search, realm, null);
    }

    @Override
    public List<UserModel> searchForUser(String search, RealmModel realm, int firstResult, int maxResults) {
        log.infov("search for users: realm={0} search={1} firstResult={2} maxResults={3}", realm.getId(), search, firstResult, maxResults);
        return internalSearchForUser(search, realm, new PagingUtil.Pageable(firstResult, maxResults));
    }

    @Override
    public List<UserModel> searchForUser(Map<String, String> params, RealmModel realm) {
        log.infov("search for users with params: realm={0} params={1}", realm.getId(), params);
        return internalSearchForUser(params.values().stream().findFirst().orElse(null), realm, null);
    }

    private List<UserModel> internalSearchForUser(String search, RealmModel realm, PagingUtil.Pageable pageable) {
        return toUserModel(realm, repository.findUsers(search, pageable));
    }

    @Override
    public List<UserModel> searchForUser(Map<String, String> params, RealmModel realm, int firstResult, int maxResults) {
        log.infov("search for users with params: realm={0} params={1} firstResult={2} maxResults={3}", realm.getId(), params, firstResult, maxResults);
        return internalSearchForUser(params.values().stream().findFirst().orElse(null), realm, new PagingUtil.Pageable(firstResult, maxResults));
    }

    @Override
    public List<UserModel> getGroupMembers(RealmModel realm, GroupModel group, int firstResult, int maxResults) {
        log.infov("search for group members with params: realm={0} groupId={1} firstResult={2} maxResults={3}", realm.getId(), group.getId(), firstResult, maxResults);
        return Collections.emptyList();
    }

    @Override
    public Stream<UserModel> getRoleMembersStream(RealmModel realm, RoleModel role, Integer firstResult, Integer maxResults) {
        return UserQueryProvider.super.getRoleMembersStream(realm, role, firstResult, maxResults);
    }

    @Override
    public List<UserModel> getGroupMembers(RealmModel realm, GroupModel group) {
        log.infov("search for group members: realm={0} groupId={1} firstResult={2} maxResults={3}", realm.getId(), group.getId());
        return Collections.emptyList();
    }

    @Override
    public List<UserModel> searchForUserByUserAttribute(String attrName, String attrValue, RealmModel realm) {
        log.infov("search for group members: realm={0} attrName={1} attrValue={2}", realm.getId(), attrName, attrValue);
        return Collections.emptyList();
    }
    @Override
    public UserModel addUser(RealmModel realm, String username) {
        UserModel user = session.userLocalStorage().addUser(realm, username);
        user.setEnabled(true);


        log.info("this is the user: " + user);
//        String gender = user.getFirstAttribute("gender");
//        String birthdate = user.getFirstAttribute("birthdate");
//        String country = user.getFirstAttribute("country");
//        String governorate = user.getFirstAttribute("governorate");
//        String city = user.getFirstAttribute("city");
//        Integer zipCode = Integer.valueOf(user.getFirstAttribute("zipCode"));
//        Integer homeCode = Integer.valueOf(user.getFirstAttribute("homeCode"));
//        Integer phoneNumber = Integer.valueOf(user.getFirstAttribute("phoneNumber"));
//        String matriculeFiscale = user.getFirstAttribute("matriculeFiscale");
//        String status = user.getFirstAttribute("status");
//        Integer companyId = Integer.valueOf(user.getFirstAttribute("companyId"));
//        Integer insuranceCompanyId = Integer.valueOf(user.getFirstAttribute("insuranceCompanyId"));
//        Integer agencyId = Integer.valueOf(user.getFirstAttribute("agencyId"));
        log.info("add user: " + user);
        //List values = Arrays.asList(id, username, firstname, lastname, email, password, confirmPassword);
        String query = "INSERT INTO users (id, username, firstname, lastname, email, password, confirm_password) " +
                "VALUES (? ,?, ?, ?, ?, ?, ?)";

//        List values = Arrays.asList(id, username, firstname, lastname, email, role, password, confirmPassword,
//                gender, birthdate, country, governorate, city, zipCode, homeCode, phoneNumber, matriculeFiscale,
//                status, companyId, insuranceCompanyId, agencyId);
//        String query = "INSERT INTO users (id, username, firstname, lastname, email, role, password, confirmPassword," +
//                "gender, birthdate, country, governorate, city, zipCode, homeCode, phoneNumber, matriculeFiscale," +
//                "status, companyId, insuranceCompanyId, agencyId) " +
//                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        repository.doQuery2(query, user);

        return user;
    }


    @Override
    public boolean removeUser(RealmModel realm, UserModel user) {
        boolean userRemoved = repository.removeUser();

        if (userRemoved) {
            log.infov("deleted keycloak user: realm={0} userId={1} username={2}", realm.getId(), user.getId(), user.getUsername());
        }

        return userRemoved;
    }
}