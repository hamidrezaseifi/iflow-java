package com.pth.iflow.workflow.test;

import java.util.Arrays;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@TestConfiguration
public class SpringSecurityWebTestUserConfig {

  @Bean
  @Primary
  public UserDetailsService userDetailsService() {

    // final BearerTokenAuthenticationToken token = new BearerTokenAuthenticationToken();
    // final Authentication authentication = new UsernamePasswordAuthenticationToken("user@company.com", "password");

    final User basicUser = new User("user@company.com", "password", Arrays
        .asList(
            new SimpleGrantedAuthority("ROLE_USER"),
            new SimpleGrantedAuthority("ROLE_ADMIN")));

    return new InMemoryUserDetailsManager(Arrays
        .asList(
            basicUser));
  }

}
