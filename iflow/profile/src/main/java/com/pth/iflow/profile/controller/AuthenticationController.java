package com.pth.iflow.profile.controller;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pth.iflow.common.annotations.IflowPostRequestMapping;
import com.pth.iflow.common.controllers.helper.ControllerHelper;
import com.pth.iflow.common.edo.models.UserAuthenticationRequestEdo;
import com.pth.iflow.common.edo.models.UserAuthenticationResponseEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.UserAuthenticationRequest;
import com.pth.iflow.profile.model.UserAuthenticationSession;
import com.pth.iflow.profile.service.IAuthenticationService;
import com.pth.iflow.profile.service.ISessionManager;

@RestController
@RequestMapping
public class AuthenticationController {

  private final IAuthenticationService authService;
  private final ISessionManager sessionManager;

  public AuthenticationController(@Autowired final IAuthenticationService authService,
      @Autowired final ISessionManager sessionManager) {

    this.authService = authService;
    this.sessionManager = sessionManager;
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @IflowPostRequestMapping(value = IflowRestPaths.ProfileModule.AUTHENTICATION_AUTHENTICATE)
  @ResponseBody
  public ResponseEntity<UserAuthenticationResponseEdo> authenticate(@RequestBody final UserAuthenticationRequestEdo userEdo,
      final HttpServletRequest request) throws ProfileCustomizedException, URISyntaxException, MalformedURLException {

    return ControllerHelper.createResponseEntity(request, authenticateUser(userEdo), HttpStatus.ACCEPTED);
  }

  private UserAuthenticationResponseEdo authenticateUser(final UserAuthenticationRequestEdo userEdo)
      throws URISyntaxException, MalformedURLException {
    final UserAuthenticationRequest authUser = authService.authenticate(UserAuthenticationRequest.fromEdo(userEdo));
    if (authUser == null) {
      throw new ProfileCustomizedException("Invalid Username or Password", "", EModule.PROFILE.getModuleName(),
          EIFlowErrorType.INVALID_USERNAMEPASSWORD);
    }

    UserAuthenticationSession session = sessionManager.findValidateByEmail(authUser.getEmail(), true);
    if (session == null) {
      session = sessionManager.addSession(authUser.getEmail());
    }

    sessionManager.updateUser(authUser.getEmail(), session.getSessionid());

    final UserAuthenticationResponseEdo authRespEdo = session.toEdo();

    return authRespEdo;
  }
}
