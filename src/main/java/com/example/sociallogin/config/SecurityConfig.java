package com.example.sociallogin.config;

import com.example.sociallogin.filter.OAuth2LoggingFilter;
import jakarta.servlet.DispatcherType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.csrf.CsrfFilter;

import java.util.logging.Filter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .requestMatchers("/**").fullyAuthenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .oauth2ResourceServer()
                .jwt()
                .and()
                .and()
                .addFilterBefore(oAuth2LoggingFilter, SecurityContextPersistenceFilter.class) // Corrected placement
                .cors().and().csrf().disable();
        return http.build();
    }

    @Autowired
    private OAuth2LoggingFilter oAuth2LoggingFilter;

    @Bean
    public FilterRegistrationBean<OAuth2LoggingFilter> loggingFilterRegistration() {
        FilterRegistrationBean<OAuth2LoggingFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(oAuth2LoggingFilter);
        registration.addUrlPatterns("/*");  // Adjust the URL pattern as necessary
        registration.setDispatcherTypes(DispatcherType.REQUEST);  // Only for direct client requests
        return registration;
    }

}
