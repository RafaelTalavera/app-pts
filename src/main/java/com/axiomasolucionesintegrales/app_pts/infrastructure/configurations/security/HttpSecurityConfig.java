package com.axiomasolucionesintegrales.app_pts.infrastructure.configurations.security;

import com.axiomasolucionesintegrales.app_pts.domain.models.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
@EnableMethodSecurity
public class HttpSecurityConfig {

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private JwtAuthenticationFilter authenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrfConfig -> csrfConfig.disable())
                .sessionManagement(sessionMangConfig -> sessionMangConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
//                .authorizeHttpRequests(builderRequestMatchers())
        ;

        return http.build();
    }

    private static Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry> builderRequestMatchers() {
        return authConfig -> {

            authConfig.requestMatchers(HttpMethod.POST, "/auth/authenticate").permitAll();
            authConfig.requestMatchers(HttpMethod.GET, "/auth/public-access").permitAll();
            authConfig.requestMatchers("/error").permitAll();

            authConfig.requestMatchers(HttpMethod.GET, "/items").hasAuthority(Permission.READ_ALL_ITEMS.name());
            authConfig.requestMatchers(HttpMethod.POST, "/items").hasAuthority(Permission.SAVE_ONE_ITEMS.name());

            authConfig.anyRequest().denyAll();
        };
    }
}