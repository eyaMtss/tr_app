package com.tunidesign.dbuserprovider.model;

import lombok.extern.jbosslog.JBossLog;
import org.apache.commons.lang3.StringUtils;
import org.keycloak.component.ComponentModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.RoleModel;
import org.keycloak.storage.StorageId;
import org.keycloak.storage.adapter.AbstractUserAdapterFederatedStorage;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

@JBossLog
public class UserAdapter extends AbstractUserAdapterFederatedStorage {

    private final String keycloakId;
    private       String username;
    //@Enumerated(EnumType.STRING)
    private String role;

    public UserAdapter(KeycloakSession session, RealmModel realm, ComponentModel model, Map<String, String> data, boolean allowDatabaseToOverwriteKeycloak) {
        super(session, realm, model);
        this.keycloakId = StorageId.keycloakId(model, data.get("id"));
        this.username = data.get("username");
        this.role = data.get("role");
        try {
          Map<String, List<String>> attributes = this.getAttributes();
          for (Entry<String, String> e : data.entrySet()) {
              Set<String>  newValues = new HashSet<>();
              if (!allowDatabaseToOverwriteKeycloak) {
                List<String> attribute = attributes.get(e.getKey());
                if (attribute != null) {
                    newValues.addAll(attribute);
                }
              }
              newValues.add(StringUtils.trimToNull(e.getValue()));
              this.setAttribute(e.getKey(), newValues.stream().filter(Objects::nonNull).collect(Collectors.toList()));
          }
        } catch(Exception e) {
          log.errorv(e, "UserAdapter constructor, username={0}", this.username);
        }
    }


    @Override
    public String getId() {
        return keycloakId;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    protected Set<RoleModel> getRoleMappingsInternal(){
        if (getRole() != null) {
            Set<RoleModel> set = new HashSet();
            set.add(new UserRoleModel(getRole(), realm));
            log.info("role: " + getRole());
            return set;
        }
        return Collections.emptySet();
    }
    public Set<RoleModel> getRoleMappings() {
        Set<RoleModel> set = new HashSet(this.getFederatedRoleMappings());
        set.addAll(this.getRoleMappingsInternal());
        return set;
    }

}
