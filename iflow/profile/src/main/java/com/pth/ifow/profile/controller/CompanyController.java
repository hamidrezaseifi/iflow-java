package com.pth.ifow.profile.controller;

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
import com.pth.iflow.common.edo.models.base.ModelMapperBase;
import com.pth.iflow.common.edo.models.xml.CompanyEdo;
import com.pth.iflow.common.edo.models.xml.DepartmentListEdo;
import com.pth.iflow.common.edo.models.xml.UserGroupListEdo;
import com.pth.iflow.common.edo.models.xml.UserListEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.TokenVerficationHandlerInterceptor;
import com.pth.ifow.profile.exceptions.ProfileCustomizedException;
import com.pth.ifow.profile.model.Department;
import com.pth.ifow.profile.model.ProfileResponse;
import com.pth.ifow.profile.model.User;
import com.pth.ifow.profile.model.UserGroup;
import com.pth.ifow.profile.service.ITokenUserDataManager;

@RestController
@RequestMapping
public class CompanyController {

  private final ITokenUserDataManager tokenUserDataManager;

  public CompanyController(@Autowired final ITokenUserDataManager tokenUserDataManager) {

    this.tokenUserDataManager = tokenUserDataManager;
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(value = IflowRestPaths.ProfileModule.COMPANY_READ_BY_ID)
  @ResponseBody
  public ResponseEntity<CompanyEdo> readById(@PathVariable(name = "companyid") final Long companyid, final HttpServletRequest request,
      @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException {

    final ProfileResponse profile = tokenUserDataManager.getProfileByToken(headerTokenId);

    if (profile.getCompany().getId() != companyid) {
      throw new ProfileCustomizedException("Invalid Company!", "", EModule.PROFILE.getModuleName(), EIFlowErrorType.INVALID_COMPANY);
    }

    return ControllerHelper.createResponseEntity(request, profile.getCompany().toEdo(), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(value = IflowRestPaths.ProfileModule.COMPANY_READ_USER_LIST)
  @ResponseBody
  public ResponseEntity<UserListEdo> readUserList(@PathVariable(name = "companyid") final Long companyid,
      final HttpServletRequest request,
      @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException {

    final List<User> list = tokenUserDataManager.getUserListByToken(headerTokenId, companyid);

    final UserListEdo edo = new UserListEdo(ModelMapperBase.toEdoList(list));

    return ControllerHelper.createResponseEntity(request, edo, HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(value = IflowRestPaths.ProfileModule.COMPANY_READ_USERGROUP_LIST)
  @ResponseBody
  public ResponseEntity<UserGroupListEdo> readUserGroupList(@PathVariable(name = "companyid") final Long companyid,
      final HttpServletRequest request,
      @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException {

    final List<UserGroup> list = tokenUserDataManager.getUserGroupListByToken(headerTokenId, companyid);

    final UserGroupListEdo edo = new UserGroupListEdo(ModelMapperBase.toEdoList(list));

    return ControllerHelper.createResponseEntity(request, edo, HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(value = IflowRestPaths.ProfileModule.COMPANY_READ_DEPARTMENT_LIST)
  @ResponseBody
  public ResponseEntity<DepartmentListEdo> readDepartmentList(@PathVariable(name = "companyid") final Long companyid,
      final HttpServletRequest request,
      @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException {

    final List<Department> list = tokenUserDataManager.getDepartmentListByToken(headerTokenId, companyid);

    final DepartmentListEdo edo = new DepartmentListEdo(ModelMapperBase.toEdoList(list));

    return ControllerHelper.createResponseEntity(request, edo, HttpStatus.OK);
  }

}
