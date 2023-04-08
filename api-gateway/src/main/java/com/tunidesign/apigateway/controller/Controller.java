package com.tunidesign.apigateway.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@RestController
public class Controller {
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);
    @GetMapping("/user")
    public String index(Principal principal) {
        logger.info(String.valueOf(principal));
        return principal.getName();
    }

    /*@PostMapping("/login/{username}/{password}")
    public ResponseEntity<org.keycloak.representations.AccessTokenResponse> login(@NotNull @PathVariable String username, @PathVariable String password) {
        Keycloak keycloak = newKeycloakBuilderWithPasswordCredentials(username, password).build();

        org.keycloak.representations.AccessTokenResponse accessTokenResponse = null;
        try {

            accessTokenResponse = keycloak.tokenManager().getAccessToken();
            logger.info("token", accessTokenResponse);
            return ResponseEntity.status(HttpStatus.OK).body(accessTokenResponse);
        } catch (BadRequestException ex) {
            logger.warn("invalid account. User probably hasn't verified email.", ex);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(accessTokenResponse);
        }

    }

    public KeycloakBuilder newKeycloakBuilderWithPasswordCredentials(String username, String password) {
        return KeycloakBuilder.builder() //
                .realm("tunudesign-auth") //
                .serverUrl("http://localhost:8080/auth")//
                .clientId("tunidesign-user")
                .clientSecret("KjGdYhrCW5RLqv7JKRg62BUZs5AMh098")
                .username(username) //
                .password(password);
    }*/
}