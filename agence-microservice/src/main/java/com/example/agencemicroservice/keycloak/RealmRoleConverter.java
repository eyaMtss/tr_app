package com.example.agencemicroservice.keycloak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.*;
import java.util.stream.Collectors;

public class RealmRoleConverter  implements Converter<Jwt, Collection<GrantedAuthority>> {
    static Logger logger = LoggerFactory.getLogger(RealmRoleConverter.class);

    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        final Map<String, List<String>> realmAccess = new HashMap<>();
        realmAccess.put("role", Arrays.asList(jwt.getClaims().get("role").toString()));
        //= (Map<String, List<String>>) jwt.getClaims().get("role");
        System.out.println(realmAccess);
        return realmAccess.get("role")
                .stream()
                .map(roleName -> "ROLE_" + roleName) // prefix required by Spring Security for roles.
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}