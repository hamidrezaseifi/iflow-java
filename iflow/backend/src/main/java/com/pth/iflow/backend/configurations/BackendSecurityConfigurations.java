package com.pth.iflow.backend.configurations;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import com.pth.iflow.backend.authentication.BackendAuthenticationDetails;
import com.pth.iflow.backend.authentication.BackendAuthenticationFailureHandler;
import com.pth.iflow.backend.authentication.BackendAuthenticationSuccessHandler;
import com.pth.iflow.backend.authentication.provider.BackendCustomAuthenticationProvider;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class BackendSecurityConfigurations extends WebSecurityConfigurerAdapter implements IBackendConfiguration {

  public static final String                  USERNAME_FIELD_NAME         = "username";
  public static final String                  PASSWORD_FIELD_NAME         = "password";
  public static final String                  COMPANYID_FIELD_NAME        = "companyid";
  public static final String                  LOGIN_URL                   = "/auth/login";
  public static final String                  INITUSER_URL                = "/activation/user";
  public static final String                  INITCOMPANY_URL             = "/activation/company";
  public static final String                  ROOT_URL                    = "/";
  public static final String                  COMPANYINDICATOR_COOKIE_KEY = "comp_ind";

  @Value("${iflow.backend.valid-email}")
  String                                      backendValidEMail;

  @Autowired
  private BackendAuthenticationSuccessHandler uiAuthenticationSuccessHandler;

  @Autowired
  private BackendAuthenticationFailureHandler authenticationFailureHandler;

  @Autowired
  private BackendCustomAuthenticationProvider customAuthenticationProvider;

  @Override
  protected void configure(final HttpSecurity http) throws Exception {

    http.authorizeRequests().antMatchers("/images/*").permitAll().antMatchers("/js/*").permitAll().antMatchers("/css/*").permitAll()
        .antMatchers("/angular/*").permitAll().antMatchers("/fonts/*").permitAll().antMatchers(LOGIN_URL).permitAll()
        .antMatchers("/admin/**").hasAnyRole("ADMIN", "COMPANY_ADMIN")
        .antMatchers("/admin/user/**", "/admin/data/**", "/admin/data/user/**").hasAnyRole("ADMIN", "COMPANY_ADMIN").antMatchers("/**")
        .authenticated().and();

    http.exceptionHandling().accessDeniedPage("/noaccess");

    http.csrf().disable();

    http.formLogin().authenticationDetailsSource(this.authenticationDetailsSource()).loginPage(LOGIN_URL).permitAll()
        .defaultSuccessUrl("/").usernameParameter(USERNAME_FIELD_NAME).passwordParameter(PASSWORD_FIELD_NAME)
        .successHandler(this.uiAuthenticationSuccessHandler).failureHandler(this.authenticationFailureHandler).permitAll();

    http.logout().logoutUrl("/logout").logoutSuccessUrl("/");

  }

  @Override
  public String getBackendValidEMail() {
    return this.backendValidEMail;
  }

  private AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> authenticationDetailsSource() {

    return new AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails>() {

      @Override
      public WebAuthenticationDetails buildDetails(final HttpServletRequest request) {
        return new BackendAuthenticationDetails(request);
      }

    };
  }

  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return this.authenticationManager();
  }

  @Override
  @Bean
  public AuthenticationManager authenticationManager() throws Exception {
    final AuthenticationManager authenticationManager = new ProviderManager(Arrays.asList(this.customAuthenticationProvider));
    return authenticationManager;
  }

}