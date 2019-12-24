package com.pth.iflow.profile.controller;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pth.iflow.common.annotations.IflowGetRequestMapping;
import com.pth.iflow.common.controllers.helper.ControllerHelper;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.models.edo.CompanyEdo;
import com.pth.iflow.common.models.edo.CompanyProfileEdo;
import com.pth.iflow.common.models.edo.DepartmentListEdo;
import com.pth.iflow.common.models.edo.UserGroupListEdo;
import com.pth.iflow.common.models.edo.UserListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.TokenVerficationHandlerInterceptor;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.Department;
import com.pth.iflow.profile.model.ProfileResponse;
import com.pth.iflow.profile.model.User;
import com.pth.iflow.profile.model.UserGroup;
import com.pth.iflow.profile.model.mapper.ProfileModelEdoMapper;
import com.pth.iflow.profile.service.ITokenUserDataManager;

@RestController
@RequestMapping
public class CompanyController {

  private final ITokenUserDataManager tokenUserDataManager;

  public CompanyController(@Autowired final ITokenUserDataManager tokenUserDataManager) {

    this.tokenUserDataManager = tokenUserDataManager;
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(value = IflowRestPaths.ProfileModule.COMPANYIDENTITY_READ_BY_IDENTITY)
  @ResponseBody
  public ResponseEntity<CompanyEdo> readById(@PathVariable(name = "companyidentity") final String companyidentity,
      final HttpServletRequest request,
      @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException, IFlowMessageConversionFailureException {

    final ProfileResponse profile = this.tokenUserDataManager.getProfileByToken(headerTokenId);

    if (profile.getCompanyProfile().getCompany().hasSameIdentity(companyidentity)) {
      throw new ProfileCustomizedException("Invalid Company!", "", EModule.PROFILE.getModuleName(), EIFlowErrorType.INVALID_COMPANY);
    }

    return ControllerHelper.createResponseEntity(request, ProfileModelEdoMapper.toEdo(profile.getCompanyProfile().getCompany()),
        HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(value = IflowRestPaths.ProfileModule.COMPANYIDENTITY_READ_USER_LIST)
  @ResponseBody
  public ResponseEntity<UserListEdo> readUserList(@PathVariable(name = "companyidentity") final String companyidentity,
      final HttpServletRequest request,
      @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException, IFlowMessageConversionFailureException {

    final List<User> list = this.tokenUserDataManager.getUserListByToken(headerTokenId, companyidentity);

    final UserListEdo edo = new UserListEdo(ProfileModelEdoMapper.toUserEdoList(list));

    return ControllerHelper.createResponseEntity(request, edo, HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(value = IflowRestPaths.ProfileModule.COMPANYIDENTITY_READ_USERGROUP_LIST)
  @ResponseBody
  public ResponseEntity<UserGroupListEdo> readUserGroupList(@PathVariable(name = "companyidentity") final String companyidentity,
      final HttpServletRequest request,
      @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException, IFlowMessageConversionFailureException {

    final List<UserGroup> list = this.tokenUserDataManager.getUserGroupListByToken(headerTokenId, companyidentity);

    final UserGroupListEdo edo = new UserGroupListEdo(ProfileModelEdoMapper.toUserGroupEdoList(list));

    return ControllerHelper.createResponseEntity(request, edo, HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(value = IflowRestPaths.ProfileModule.COMPANYIDENTITY_READ_DEPARTMENT_LIST)
  @ResponseBody
  public ResponseEntity<DepartmentListEdo> readDepartmentList(@PathVariable(name = "companyidentity") final String companyidentity,
      final HttpServletRequest request,
      @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException, IFlowMessageConversionFailureException {

    final List<Department> list = this.tokenUserDataManager.getDepartmentListByToken(headerTokenId, companyidentity);

    final DepartmentListEdo edo = new DepartmentListEdo(ProfileModelEdoMapper.toDepartmentEdoList(list));

    return ControllerHelper.createResponseEntity(request, edo, HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(value = IflowRestPaths.ProfileModule.COMPANYIDENTITY_READ_PROFILE)
  @ResponseBody
  public ResponseEntity<CompanyProfileEdo> readProfile(@PathVariable(name = "companyidentity") final String companyidentity,
      final HttpServletRequest request,
      @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException, IFlowMessageConversionFailureException {

    final ProfileResponse profile = this.tokenUserDataManager.getProfileByToken(headerTokenId);

    return ControllerHelper.createResponseEntity(request, ProfileModelEdoMapper.toEdo(profile.getCompanyProfile()), HttpStatus.OK);
  }

}
