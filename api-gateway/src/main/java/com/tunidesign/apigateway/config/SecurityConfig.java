package com.tunidesign.apigateway.config;

import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.web.server.WebFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.time.Duration;
import java.util.Collections;

@Configuration
@EnableWebFluxSecurity
//@Order(SecurityProperties.BASIC_AUTH_ORDER - 10)
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
                .csrf().disable()
                .authorizeExchange()
                    .pathMatchers("/actuator/**","/logout.html", "/login",
                            "/societeRemorquage/getAll", "/assurance/getAll", "/agence/getAllByInsurance/**",
                            "/users/add",
                            "/users/getAll/clients", "/users/completeRegistration/**",
                            "/garage/addAll/**",
                            "/contrat/verifyContrat", "/vehicule/add", "/users/getByUsername/**",
                            "/users/updateCompletedRegistration/**",
                            "/camion/**")
                        .permitAll()
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
                .clientSecret("jAIRyJdEjgxcEwIiOt7fsaCib03QxSZQ")
                .authorizationGrantType(AuthorizationGrantType.JWT_BEARER) //AUTHORIZATION_CODE
                .redirectUri("{baseUrl}/login/oauth2/code/{registrationId}")
                .scope("openid", "profile", "email", "roles", "web-origins")  //
                .issuerUri("http://localhost:8080/realms/tunidesign-auth")
                .authorizationUri("http://localhost:8080/realms/tunidesign-auth/protocol/openid-connect/auth")
                .tokenUri("http://localhost:8080/realms/tunidesign-auth/protocol/openid-connect/token")
                .userInfoUri("http://localhost:8080/realms/tunidesign-auth/protocol/openid-connect/userinfo")
                .jwkSetUri("http://localhost:8080/realms/tunidesign-auth/protocol/openid-connect/certs")
                .userNameAttributeName("preferred_username")
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .build();
    }

    @Bean
    public FilterRegistrationBean keycloakCorsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedHeader("Authorization");
        source.registerCorsConfiguration("/auth/*", config);

        CorsConfigurationSource corsSource = (CorsConfigurationSource)source;
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(corsSource));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}