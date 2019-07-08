package com.pth.ifow.profile.controller;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pth.iflow.common.annotations.IflowPostRequestMapping;
import com.pth.iflow.common.controllers.helper.ControllerHelper;
import com.pth.iflow.common.edo.models.AuthenticatedProfileRequestEdo;
import com.pth.iflow.common.edo.models.ProfileResponseEdo;
import com.pth.iflow.common.edo.models.TokenProfileRequestEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.TokenVerficationHandlerInterceptor;
import com.pth.ifow.profile.exceptions.ProfileCustomizedException;
import com.pth.ifow.profile.model.Company;
import com.pth.ifow.profile.model.User;
import com.pth.ifow.profile.model.UserAuthenticationSession;
import com.pth.ifow.profile.service.ICompanyService;
import com.pth.ifow.profile.service.ISessionManager;
import com.pth.ifow.profile.service.IUsersService;

@RestController
@RequestMapping
public class ProfileController {
  
  private final ISessionManager sessionManager;
  
  private final IUsersService usersService;
  
  private final ICompanyService companyService;
  
  public ProfileController(@Autowired final ISessionManager sessionManager, @Autowired final IUsersService usersService,
      @Autowired final ICompanyService companyServic) {
    
    this.sessionManager = sessionManager;
    this.usersService = usersService;
    this.companyService = companyServic;
  }
  
  @ResponseStatus(HttpStatus.OK)
  @IflowPostRequestMapping(value = IflowRestPaths.ProfileModule.AUTHENTICATION_READPROFILE)
  @ResponseBody
  public ResponseEntity<ProfileResponseEdo> readAuthenticatedInfo(@RequestBody final AuthenticatedProfileRequestEdo requestEdo,
      final HttpServletRequest request,
      @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException {
    
    if (StringUtils.isEmpty(requestEdo.getToken()) || StringUtils.isEmpty(headerTokenId)
        || (requestEdo.getToken().equals(headerTokenId) == false)) {
      throw new ProfileCustomizedException("Invalid Token!", "", EModule.PROFILE.getModuleName(), EIFlowErrorType.INVALID_TOKEN);
    }
    
    final UserAuthenticationSession session = this.sessionManager.findByToken(requestEdo.getToken());
    
    if ((session == null) || (session.getEmail().equals(requestEdo.getEmail()) == false)) {
      throw new ProfileCustomizedException("Invalid session!", "", EModule.PROFILE.getModuleName(), EIFlowErrorType.NO_SESSION_FOUND);
    }
    
    final User user = this.usersService.getUserByEmail(session.getEmail());
    
    if (user == null) {
      throw new ProfileCustomizedException("User not found!", "", EModule.PROFILE.getModuleName(), EIFlowErrorType.USER_NOTFOUND);
    }
    
    final Company company = this.companyService.getById(user.getCompanyId());
    
    if (company == null) {
      throw new ProfileCustomizedException("Company not found!", "", EModule.PROFILE.getModuleName(),
          EIFlowErrorType.COMPANY_NOTFOUND);
    }
    
    final ProfileResponseEdo edo = new ProfileResponseEdo(user.toEdo(), company.toEdo(), session.getSessionid());
    
    return ControllerHelper.createResponseEntity(request, edo, HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowPostRequestMapping(value = IflowRestPaths.ProfileModule.AUTHENTICATION_READPROFILE)
  @ResponseBody
  public ResponseEntity<ProfileResponseEdo> readTokenInfo(@RequestBody final TokenProfileRequestEdo requestEdo,
      final HttpServletRequest request,
      @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException {
    
    if (StringUtils.isEmpty(requestEdo.getToken()) || StringUtils.isEmpty(headerTokenId)
        || (requestEdo.getToken().equals(headerTokenId) == false)) {
      throw new ProfileCustomizedException("Invalid Token!", "", EModule.PROFILE.getModuleName(), EIFlowErrorType.INVALID_TOKEN);
    }
    
    final UserAuthenticationSession session = this.sessionManager.findByToken(requestEdo.getToken());
    
    if ((session == null)) {
      throw new ProfileCustomizedException("Invalid session!", "", EModule.PROFILE.getModuleName(), EIFlowErrorType.NO_SESSION_FOUND);
    }
    
    final User user = this.usersService.getUserByEmail(session.getEmail());
    
    if (user == null) {
      throw new ProfileCustomizedException("User not found!", "", EModule.PROFILE.getModuleName(), EIFlowErrorType.USER_NOTFOUND);
    }
    
    final Company company = this.companyService.getById(user.getCompanyId());
    
    if (company == null) {
      throw new ProfileCustomizedException("Company not found!", "", EModule.PROFILE.getModuleName(),
          EIFlowErrorType.COMPANY_NOTFOUND);
    }
    
    final ProfileResponseEdo edo = new ProfileResponseEdo(user.toEdo(), company.toEdo(), session.getSessionid());
    
    return ControllerHelper.createResponseEntity(request, edo, HttpStatus.OK);
  }
  
}
