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
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.models.edo.UserAuthenticationRequestEdo;
import com.pth.iflow.common.models.edo.UserAuthenticationResponseEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.ProfileResponse;
import com.pth.iflow.profile.model.UserAuthenticationRequest;
import com.pth.iflow.profile.model.UserAuthenticationSession;
import com.pth.iflow.profile.model.mapper.ProfileModelEdoMapper;
import com.pth.iflow.profile.service.IAuthenticationService;
import com.pth.iflow.profile.service.ISessionManager;
import com.pth.iflow.profile.service.IUsersService;

@RestController
@RequestMapping
public class AuthenticationController {

  private final IAuthenticationService authService;
  private final ISessionManager        sessionManager;
  private final IUsersService          usersService;

  public AuthenticationController(@Autowired final IAuthenticationService authService, @Autowired final ISessionManager sessionManager,
      @Autowired final IUsersService usersService) {

    this.authService = authService;
    this.sessionManager = sessionManager;
    this.usersService = usersService;
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @IflowPostRequestMapping(value = IflowRestPaths.ProfileModule.AUTHENTICATION_AUTHENTICATE)
  @ResponseBody
  public ResponseEntity<UserAuthenticationResponseEdo> authenticate(@RequestBody final UserAuthenticationRequestEdo userEdo,
      final HttpServletRequest request)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException, IFlowMessageConversionFailureException {

    return ControllerHelper.createResponseEntity(request, this.authenticateUser(userEdo), HttpStatus.ACCEPTED);
  }

  private UserAuthenticationResponseEdo authenticateUser(final UserAuthenticationRequestEdo userEdo)
      throws URISyntaxException, ProfileCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {
    final UserAuthenticationRequest authUser = this.authService.authenticate(ProfileModelEdoMapper.fromEdo(userEdo));
    if (authUser == null) {
      throw new ProfileCustomizedException("Invalid Username or Password", "", EModule.PROFILE.getModuleName(),
          EIFlowErrorType.INVALID_USERNAMEPASSWORD);
    }

    UserAuthenticationSession session = this.sessionManager.findValidateByUserIdentity(authUser.getEmail(),
        authUser.getCompanyIdentity(), true);
    if (session == null) {
      final ProfileResponse profile = this.usersService.getUserProfileByEmail(authUser.getEmail());
      if (profile.getCompanyProfile().getCompany().hasSameIdentity(authUser.getCompanyIdentity()) == false) {
        throw new ProfileCustomizedException("Invalid company-identity!", "", EModule.PROFILE.getModuleName(),
            EIFlowErrorType.COMPANY_NOTFOUND);
      }

      session = this.sessionManager.addSession(authUser.getEmail(), authUser.getCompanyIdentity());
    }

    this.sessionManager.updateUser(authUser.getEmail(), session.getSessionid());

    final UserAuthenticationResponseEdo authRespEdo = ProfileModelEdoMapper.toEdo(session);

    return authRespEdo;
  }
}
