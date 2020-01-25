package com.pth.iflow.profile.service.handler.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
import com.pth.iflow.profile.service.access.impl.UsersAccessService;
import com.pth.iflow.profile.service.handler.IAuthenticationService;

@Service
public class AuthenticationFromTextFileService implements IAuthenticationService {

  private static final Logger logger = LoggerFactory.getLogger(UsersAccessService.class);

  @Value("${iflow.profile.password-file}")
  private String passwordFilePath;

  private final Map<String, Map<String, String>> tempEmailPasswordList = new HashMap<>();

  @Autowired
  private IPasswordUtils passwordUtils;

  public AuthenticationFromTextFileService() {

  }

  @PostConstruct
  public void init() {

    this.readUserPasswordList();

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

    logger.debug("Authenticating user {}", user.getUserIdentity());

    if (this.tempEmailPasswordList.keySet().contains(user.getCompanyIdentity())) {

      final Map<String, String> userPasswordList = this.tempEmailPasswordList.get(user.getCompanyIdentity());
      if (userPasswordList.keySet().contains(user.getUserIdentity())) {
        final boolean res = this.passwordUtils.verifyUserPassword(user.getPassword(), userPasswordList.get(user.getUserIdentity()));

        if (res) {
          return user;
        }
      }
    }
    return null;
  }

  @Override
  public UserAuthenticationRequest setAuthentication(final UserAuthenticationRequest user) {

    logger.debug("Set authentication user {}", user.getUserIdentity());

    user.setPassword(this.passwordUtils.generateSecurePassword(user.getPassword()));

    this.verifyCompanyKey(user.getCompanyIdentity());
    this.tempEmailPasswordList.get(user.getCompanyIdentity()).put(user.getUserIdentity(), user.getPassword());

    this.writeUserPasswordList();

    return user;
  }

  @Override
  public void deleteAuthentication(final UserAuthenticationRequest user) {

    logger.debug("Delete user authentication {}", user.getUserIdentity());

    this.verifyCompanyKey(user.getCompanyIdentity());

    this.tempEmailPasswordList.get(user.getCompanyIdentity()).remove(user.getUserIdentity());

    this.writeUserPasswordList();

  }

  private void verifyCompanyKey(final String companyIdentity) {

    if (this.tempEmailPasswordList.containsKey(companyIdentity) == false) {
      this.tempEmailPasswordList.put(companyIdentity, new HashMap<String, String>());
    }
  }

  private void readUserPasswordList() {

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
        if (parts.length > 2) {

          final String companyIdentity = parts[0].trim();
          final String userIdentity = parts[1].trim();
          final String password = parts[2].trim();

          this.verifyCompanyKey(companyIdentity);

          this.tempEmailPasswordList.get(companyIdentity).put(userIdentity, password);

        }
        line = br.readLine();
      }

      br.close();

    }
    catch (final FileNotFoundException e) {
      logger.error("Error in reading user-password list from file '{}'", this.passwordFilePath, e);
    }
    catch (final IOException e) {
      logger.error("Error in reading user-password list from file '{}'", this.passwordFilePath, e);
    }
  }

  private void writeUserPasswordList() {

    final File passwordfile = new File(this.passwordFilePath);
    if (passwordfile.exists() == false) {
      try {
        passwordfile.createNewFile();
      }
      catch (final IOException e) {

      }
    }

    BufferedWriter br;
    try {
      br = new BufferedWriter(new FileWriter(passwordfile));

      for (final String companyIdentity : this.tempEmailPasswordList.keySet()) {
        final Map<String, String> userPasswordList = this.tempEmailPasswordList.get(companyIdentity);

        for (final String userIdentity : userPasswordList.keySet()) {
          final String line = companyIdentity + ":" + userIdentity + ":" + userPasswordList.get(userIdentity) + "\n";
          br.write(line);
        }

      }
      br.close();

    }
    catch (final IOException e) {
      logger.error("Error in writing user-password list in file '{}'", this.passwordFilePath, e);
    }

  }

}
