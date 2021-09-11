package com.hygor.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class MySecurityConfiguration extends WebSecurityConfigurerAdapter {
   @Override
   protected void configure(HttpSecurity http) throws Exception {
     http
       .sessionManagement()
       .sessionCreationPolicy(SessionCreationPolicy.NEVER)
       .and()
         .authorizeRequests()
         .antMatchers("/actuator/").hasAuthority("ROLE_ADMIN")
         .antMatchers("/github/v1/**").permitAll()
         .anyRequest().authenticated()
      .and()
        .csrf().disable();
   }
}