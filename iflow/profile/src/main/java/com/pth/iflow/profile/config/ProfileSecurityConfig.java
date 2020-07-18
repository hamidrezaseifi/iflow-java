package com.pth.iflow.profile.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class ProfileSecurityConfig extends WebSecurityConfigurerAdapter {

  public ProfileSecurityConfig() {

    // TODO Auto-generated constructor stub
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
        .authenticated();
    // @formatter:on
  }

}
