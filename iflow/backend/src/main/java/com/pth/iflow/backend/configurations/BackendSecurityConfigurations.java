package com.pth.iflow.backend.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class BackendSecurityConfigurations extends WebSecurityConfigurerAdapter implements IBackendConfiguration {
  
  @Value("${iflow.backend.valid-email}")
  String backendValidEMail;
  
  @Override
  protected void configure(final HttpSecurity http) throws Exception {

    http.authorizeRequests().antMatchers("/**").permitAll();

    http.csrf().disable();

  }
  
  @Override
  public String getBackendValidEMail() {
    return this.backendValidEMail;
  }
}
