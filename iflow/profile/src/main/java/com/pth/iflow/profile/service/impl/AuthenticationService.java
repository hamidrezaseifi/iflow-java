package com.pth.iflow.profile.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pth.iflow.profile.model.UserAuthenticationRequest;
import com.pth.iflow.profile.service.IAuthenticationService;

@Service
public class AuthenticationService implements IAuthenticationService {

  private static final Logger       logger                = LoggerFactory.getLogger(UsersService.class);

  private final Map<String, String> tempEmailPasswordList = new HashMap<>();

  public AuthenticationService() {
  }

  @PostConstruct
  public void init() {
    this.tempEmailPasswordList.put("admin@iflow.de", "admin");
    this.tempEmailPasswordList.put("user@iflow.de", "user");
    this.tempEmailPasswordList.put("user2@iflow.de", "user");
    this.tempEmailPasswordList.put("user3@iflow.de", "user");
    this.tempEmailPasswordList.put("test", "test");
  }

  @Override
  public UserAuthenticationRequest authenticate(final UserAuthenticationRequest user) {

    logger.debug("Authenticating user {}", user.getEmail());

    if (this.tempEmailPasswordList.keySet().contains(user.getEmail())) {
      if (this.tempEmailPasswordList.get(user.getEmail()).equals(user.getPassword())) {
        return user;
      }
    }
    return null;
  }

}
