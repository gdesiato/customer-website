package com.example.customerwebsite.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfigFile {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                //disable CSRF for Postman usage
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(auth -> auth
                        // Allow unauthenticated access to: "/", "/webjars/**", "/css/**", "/login/**", "/images/**", "/register"
                        // and require all other requests to be authenticated.
                        // Allow users with USER_ROLE access to "/customer-view", and require ADMIN_ROLE for all other endpoints.
                        // Add the .formLogin() method to enable the Spring generated login page.
                        .antMatchers("/","/webjars/**", "/css/**", "/login/**", "/images/**").permitAll()
                        .antMatchers("/register", "/error").permitAll()
//                        .antMatchers("/customer-view").hasRole("USER_ROLE")
                        .antMatchers("/cars").hasRole("USER")
                        .antMatchers("/**").hasRole("ADMIN")
                //all other requests should be authenticated
                .anyRequest().authenticated())
                .formLogin();
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
