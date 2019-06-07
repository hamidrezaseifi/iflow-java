package com.pth.ifow.profile.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pth.ifow.profile.model.UserAuthenticationRequest;
import com.pth.ifow.profile.service.IAuthenticationService;

@Service
public class AuthenticationService implements IAuthenticationService {

  private static final Logger logger = LoggerFactory.getLogger(UsersService.class);

  private final Map<String, String> tempEmailPasswordList = new HashMap<>();

  public AuthenticationService() {
  }

  @PostConstruct
  public void init() {
    tempEmailPasswordList.put("admin@iflow.de", "admin");
    tempEmailPasswordList.put("user@iflow.de", "user");
    tempEmailPasswordList.put("eli", "eli");
    tempEmailPasswordList.put("test", "test");
  }

  @Override
  public UserAuthenticationRequest authenticate(final UserAuthenticationRequest user) {


    logger.debug("Authenticating user {}" , user.getEmail());

    if (tempEmailPasswordList.keySet().contains(user.getEmail())) {
      if (tempEmailPasswordList.get(user.getEmail()).equals(user.getPassword())) {
        return user;
      }
    }
    return null;
  }

}
