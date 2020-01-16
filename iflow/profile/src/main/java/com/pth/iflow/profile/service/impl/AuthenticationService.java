package com.pth.iflow.profile.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pth.iflow.profile.helper.IPasswordUtils;
import com.pth.iflow.profile.model.UserAuthenticationRequest;
import com.pth.iflow.profile.service.IAuthenticationService;

@Service
public class AuthenticationService implements IAuthenticationService {

  private static final Logger logger = LoggerFactory.getLogger(UsersService.class);

  @Value("${iflow.profile.password-file}")
  private String passwordFilePath;

  private final Map<String, String> tempEmailPasswordList = new HashMap<>();

  @Autowired
  private IPasswordUtils passwordUtils;

  public AuthenticationService() {

  }

  @PostConstruct
  public void init() {

    final File passwordfile = new File(this.passwordFilePath);
    if (passwordfile.exists() == false) {
      try {
        passwordfile.createNewFile();
      }
      catch (final IOException e) {

      }
    }

    try {
      final BufferedReader br = new BufferedReader(new FileReader(passwordfile));

      String line = br.readLine();
      while (line != null) {
        final String[] parts = line.split(":");
        if (parts.length > 1) {
          this.tempEmailPasswordList.put(parts[0].trim(), parts[1].trim());
        }
        line = br.readLine();
      }

      br.close();

    }
    catch (final FileNotFoundException e) {

    }
    catch (final IOException e) {

    }

    /*
     * this.tempEmailPasswordList.put("admin@iflow.de", "admin"); this.tempEmailPasswordList.put("user@iflow.de", "user");
     * this.tempEmailPasswordList.put("user2@iflow.de", "user"); this.tempEmailPasswordList.put("user3@iflow.de", "user");
     * this.tempEmailPasswordList.put("test", "test");
     *
     * for (final String key : this.tempEmailPasswordList.keySet()) { System.out.println(key + ":" +
     * this.passwordUtils.generateSecurePassword(this.tempEmailPasswordList.get(key))); } System.out.println("-------------------------");
     */
  }

  @Override
  public UserAuthenticationRequest authenticate(final UserAuthenticationRequest user) {

    logger.debug("Authenticating user {}", user.getEmail());

    if (this.tempEmailPasswordList.keySet().contains(user.getEmail())) {
      final boolean res = this.passwordUtils.verifyUserPassword(user.getPassword(), this.tempEmailPasswordList.get(user.getEmail()));

      // if (this.tempEmailPasswordList.get(user.getEmail()).equals(user.getPassword())) {
      if (res) {
        return user;
      }
    }
    return null;
  }

}
