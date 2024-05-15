package com.postgresql.Daruma.config.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;

import com.postgresql.Daruma.config.security.devfilter.DevUserFilter;
import com.postgresql.Daruma.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final UsuarioService userService;

    @Autowired
    private FilterChainExceptionHandler filterChainExceptionHandler;

    @Bean
    @Profile("!prod")
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Session must be stateless for REST
        http.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        // All HttpRequests should be authenticated
        http
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().authenticated());
        // Allow authentication via JWT
        http.oauth2ResourceServer(oauth2 -> oauth2
                .jwt(Customizer.withDefaults()));
        // Allow authentication via custom filter with custom dev headers
        http.addFilterBefore(new DevUserFilter(),
                AnonymousAuthenticationFilter.class);
        // Custom handler for exceptions during filters
        // Order of filters is available at
        // https://docs.spring.io/spring-security/reference/servlet/configuration/xml-namespace.html#ns-custom-filters
        http.addFilterBefore(filterChainExceptionHandler, LogoutFilter.class);

        return http.build();
    }

    @Bean
    @Profile("prod")
    public SecurityFilterChain filterChainProd(HttpSecurity http) throws Exception {
        // Session must be stateless for REST
        http.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        // All HttpRequests should be authenticated
        http
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().authenticated());
        // Allow authentication via JWT
        http.oauth2ResourceServer(oauth2 -> oauth2
                .jwt(Customizer.withDefaults()));
        // Custom handler for exceptions during filters
        // Order of filters is available at
        // https://docs.spring.io/spring-security/reference/servlet/configuration/xml-namespace.html#ns-custom-filters
        http.addFilterBefore(filterChainExceptionHandler, LogoutFilter.class);

        return http.build();
    }

    @Bean
    JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();

        Converter<Jwt, Collection<GrantedAuthority>> converterFunction = jwt -> {
            try {
                return userService
                        .getAuthoritiesByFirebaseUserId(jwt.getClaim("user_id"));
            } catch (Exception e) {
                e.printStackTrace();
                // Fallback to empty
                return new ArrayList<GrantedAuthority>();
            }
        };

        converter
                .setJwtGrantedAuthoritiesConverter(converterFunction);

        return converter;
    }

}
