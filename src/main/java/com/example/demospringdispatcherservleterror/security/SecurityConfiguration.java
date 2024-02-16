package com.example.demospringdispatcherservleterror.security;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    @Order(1)
    public SecurityFilterChain dummyFilterChain(HttpSecurity http) throws Exception {
        http.cors(AbstractHttpConfigurer::disable);
        http.csrf(AbstractHttpConfigurer::disable);
        http.anonymous(Customizer.withDefaults());

        http.authorizeHttpRequests(config -> {
            config.dispatcherTypeMatchers(DispatcherType.ERROR).permitAll();
            config.requestMatchers("/hello").permitAll();
            config.requestMatchers("/actuator","/actuator/**", "/readyz", "/livez").permitAll();
            config.anyRequest().fullyAuthenticated();
        });

        http.exceptionHandling(Customizer.withDefaults());
        http.formLogin(Customizer.withDefaults());
        http.logout(Customizer.withDefaults());

        return http.build();
    }

}
