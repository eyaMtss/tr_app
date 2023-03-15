package com.tunidesign.apigateway.config;

import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.client.oidc.web.server.logout.OidcClientInitiatedServerLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.InMemoryReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.logout.ServerLogoutSuccessHandler;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    protected void configure(HttpSecurity http) throws Exception {
        http
                .oauth2Login()
                .authorizationEndpoint()
                .baseUri("/login/oauth2/code/keycloak");

    }

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http, ServerLogoutSuccessHandler handler) {
        http

                .authorizeExchange()
                    .pathMatchers("/actuator/**","/logout.html", "/login", "/societeRemorquage/getAll").permitAll()

//                .and()
//                    .authorizeExchange()
//                        .pathMatchers(HttpMethod.GET, "/Users/Clients").hasRole("SUPER_ADMIN")
//                        .pathMatchers(HttpMethod.GET, "/Users/CompanyEmployees/**").hasRole("COMPANY_ADMIN")
                    .anyExchange().authenticated()
                .and()
                    .oauth2Login()
                    .clientRegistrationRepository(clientRegistrationRepository())
                .and()
                    .logout().logoutSuccessHandler(handler);
        return http.build();
    }




    @Bean
    public ServerLogoutSuccessHandler keycloakLogoutSuccessHandler(ReactiveClientRegistrationRepository repository) {
        OidcClientInitiatedServerLogoutSuccessHandler oidcLogoutSuccessHandler = new OidcClientInitiatedServerLogoutSuccessHandler(repository);
        oidcLogoutSuccessHandler.setPostLogoutRedirectUri("{baseUrl}/logout.html");
        return oidcLogoutSuccessHandler;
    }

    @Bean
    public ReactiveClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryReactiveClientRegistrationRepository(keycloakClientRegistration());
    }
    @Bean
    public ClientRegistration keycloakClientRegistration() {
        return ClientRegistration.withRegistrationId("keycloak")
                .clientId("tunidesign-user")
                .clientName("tunidesign-user")
                .clientSecret("KjGdYhrCW5RLqv7JKRg62BUZs5AMh098")
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .redirectUri("{baseUrl}/login/oauth2/code/{registrationId}")
                .scope("openid", "profile", "email", "roles")  //
                .issuerUri("http://localhost:8080/realms/tunidesign-auth")
                .authorizationUri("http://localhost:8080/realms/tunidesign-auth/protocol/openid-connect/auth")
                .tokenUri("http://localhost:8080/realms/tunidesign-auth/protocol/openid-connect/token")
                .userInfoUri("http://localhost:8080/realms/tunidesign-auth/protocol/openid-connect/userinfo")
                .jwkSetUri("http://localhost:8080/realms/tunidesign-auth/protocol/openid-connect/certs")
                .userNameAttributeName("preferred_username")
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .build();
    }







}