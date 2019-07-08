package com.pth.ifow.profile;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import com.pth.iflow.common.edo.models.AuthenticatedProfileRequestEdo;
import com.pth.iflow.common.edo.models.CompanyEdo;
import com.pth.iflow.common.edo.models.ProfileResponseEdo;
import com.pth.iflow.common.edo.models.TokenProfileRequestEdo;
import com.pth.iflow.common.edo.models.UserEdo;
import com.pth.ifow.profile.model.Company;
import com.pth.ifow.profile.model.User;
import com.pth.ifow.profile.model.UserAuthenticationRequest;
import com.pth.ifow.profile.model.UserAuthenticationSession;

public class TestDataProducer {
  
  protected Company getTestCompany() {
    final Company company = new Company();
    company.setCompanyName("companyName");
    company.setId(1L);
    company.setIdentifyid("identifyid");
    company.setStatus(1);
    company.setVersion(1);
    
    return company;
  }
  
  protected User getTestUser() {
    final User model = new User();
    model.setCompanyId(1L);
    model.setId(1L);
    model.setEmail("email");
    model.setFirstName("firstName");
    model.setLastName("lastName");
    model.setStatus(1);
    
    return model;
  }
  
  protected User getTestUser(final Long id, final String fname, final String lname, final String email) {
    final User model = new User();
    model.setCompanyId(1L);
    model.setId(id);
    model.setEmail(email);
    model.setFirstName(fname);
    model.setLastName(lname);
    model.setStatus(1);
    
    return model;
  }
  
  protected UserAuthenticationSession getTestUserAuthenticationSession() {
    final UserAuthenticationSession model = new UserAuthenticationSession(getSessionMaxAgeInSeconds());
    model.setCreated(LocalDateTime.now());
    model.setLastAccess(LocalDateTime.now());
    model.setEmail("email");
    model.setSessionid("sessionid");
    model.setToken("token");
    
    return model;
  }
  
  protected AuthenticatedProfileRequestEdo getTestAuthenticatedProfileRequestEdo() {
    final AuthenticatedProfileRequestEdo model = new AuthenticatedProfileRequestEdo();
    model.setEmail("");
    model.setToken("token");

    return model;
  }
  
  protected TokenProfileRequestEdo getTokenProfileRequestEdo(final String email) {
    final TokenProfileRequestEdo model = new TokenProfileRequestEdo();
    model.setToken(email);

    return model;
  }
  
  protected ProfileResponseEdo getTestProfileResponseEdo(final String sessionid, final UserEdo user, final CompanyEdo company) {
    final ProfileResponseEdo model = new ProfileResponseEdo();
    model.setCompany(company);
    model.setSessionid(sessionid);
    model.setUser(user);

    return model;
  }
  
  protected AuthenticatedProfileRequestEdo getTestAuthenticatedProfileRequestEdo(final String email, final String token) {
    final AuthenticatedProfileRequestEdo model = new AuthenticatedProfileRequestEdo();
    model.setEmail(email);
    model.setToken(token);

    return model;
  }
  
  protected UserAuthenticationRequest getTestUserAuthenticationRequest() {
    final UserAuthenticationRequest model = new UserAuthenticationRequest();
    model.setCompanyIdentity("companyIdentity");
    model.setPassword("password");
    model.setEmail("email");
    
    return model;
  }
  
  protected int getSessionMaxAgeInSeconds() {
    return 1000;
  }
  
  protected List<User> getTestUserList() {
    final List<User> list = Arrays.asList(getTestUser(1L, "fname 1", "lname 1", "email 1"),
        getTestUser(2L, "fname 2", "lname 2", "email 2"), getTestUser(3L, "fname 3", "lname 3", "email 3"));
    
    return list;
  }
  
  protected List<Long> getTestUserIdList() {
    return Arrays.asList(1L, 2L, 3L);
  }
  
}
