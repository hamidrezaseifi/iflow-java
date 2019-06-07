package com.pth.ifow.profile.controller;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pth.iflow.common.edo.models.UserAuthenticationRequestEdo;
import com.pth.iflow.common.edo.models.UserAuthenticationResponseEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.ifow.profile.exceptions.ProfileCustomizedException;
import com.pth.ifow.profile.model.Company;
import com.pth.ifow.profile.model.User;
import com.pth.ifow.profile.model.UserAuthenticationRequest;
import com.pth.ifow.profile.model.UserAuthenticationSession;
import com.pth.ifow.profile.service.IAuthenticationService;
import com.pth.ifow.profile.service.ICompanyService;
import com.pth.ifow.profile.service.ISessionManager;
import com.pth.ifow.profile.service.IUsersService;

@RestController
@RequestMapping
public class AuthenticationController {

  private final IAuthenticationService authService;
  private final IUsersService usersService;
  private final ICompanyService companyService;
  private final ISessionManager sessionManager;

  public AuthenticationController(@Autowired final IAuthenticationService authService,
      @Autowired final IUsersService usersService, @Autowired final ISessionManager sessionManager,
      @Autowired final ICompanyService companyService) {
    this.authService = authService;
    this.usersService = usersService;
    this.sessionManager = sessionManager;
    this.companyService = companyService;
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @PostMapping(value = "/auth/authenticate", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
  @ResponseBody
  public ResponseEntity<UserAuthenticationResponseEdo> authenticate(
      @RequestBody final UserAuthenticationRequestEdo userEdo)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException {

    return new ResponseEntity<>(authenticateUser(userEdo), HttpStatus.ACCEPTED);
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @PostMapping(value = "/auth/authenticatejson", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public ResponseEntity<UserAuthenticationResponseEdo> authenticateJson(
      @RequestBody final UserAuthenticationRequestEdo userEdo)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException {

    return new ResponseEntity<>(authenticateUser(userEdo), HttpStatus.ACCEPTED);
  }

  private UserAuthenticationResponseEdo authenticateUser(final UserAuthenticationRequestEdo userEdo)
      throws URISyntaxException, MalformedURLException {
    final UserAuthenticationRequest authUser = authService.authenticate(UserAuthenticationRequest.fromEdo(userEdo));
    if (authUser == null) {
      throw new ProfileCustomizedException("Invalid Username or Password", "", EModule.PROFILE.getModuleName(),
          EIFlowErrorType.INVALID_USERNAMEPASSWORD);
    }

    final User foundUser = usersService.getUserByEmail(authUser);

    if (foundUser == null) {
      throw new ProfileCustomizedException("User Not Found", "", EModule.PROFILE.getModuleName(),
          EIFlowErrorType.USER_NOTFOUND);
    }

    final Company foundCompany = companyService.getById(foundUser.getCompanyIid());

    if (foundCompany == null) {
      throw new ProfileCustomizedException("Company Not Found", "", EModule.PROFILE.getModuleName(),
          EIFlowErrorType.COMPANY_NOTFOUND);
    }

    UserAuthenticationSession session = sessionManager.findValidateByEmail(foundUser.getEmail(), true);
    if (session == null) {
      session = sessionManager.addSession(foundUser);
    }

    sessionManager.updateUser(foundUser, session.getSessionid());

    final UserAuthenticationResponseEdo authRespEdo = session.toEdo();
    authRespEdo.setCompany(foundCompany.toEdo());

    return authRespEdo;
  }
}
