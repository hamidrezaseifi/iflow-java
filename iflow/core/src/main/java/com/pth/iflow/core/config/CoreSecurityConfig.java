package com.pth.iflow.core.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.pth.iflow.common.moduls.security.JwtProfileAuthenticationManager;
import com.pth.iflow.common.moduls.security.JwtSecurityConfigurer;

public class CoreSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  JwtProfileAuthenticationManager jwtRemoteAuthenticationManager;

  @Override
  @Bean
  public AuthenticationManager authenticationManager() throws Exception {

    final AuthenticationManager authenticationManager = new ProviderManager(Arrays.asList(this.jwtRemoteAuthenticationManager));
    return authenticationManager;
  }

  @Override
  protected void configure(final HttpSecurity http) throws Exception {

    // @formatter:off
    http
        .httpBasic()
        .disable()
        .csrf()
        .disable()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authorizeRequests()
        .antMatchers("/auth/authenticate")
        .permitAll()
        .antMatchers("/auth/authenticate")
        .anonymous()
        .anyRequest()
        .authenticated()
        .and()
        .apply(new JwtSecurityConfigurer());
    // @formatter:on
  }

}
