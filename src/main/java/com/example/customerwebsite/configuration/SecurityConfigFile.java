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
                        .antMatchers("/","/webjars/**", "/css/**", "/login/**", "/images/**").permitAll()
                        .antMatchers("/register").permitAll()
                        .antMatchers("/customer-view").hasRole("USER_ROLE")
                        .antMatchers("/**").hasRole("ADMIN_ROLE")
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
