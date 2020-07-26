package com.pth.iflow.profile.controller;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pth.iflow.common.annotations.IflowGetRequestMapping;
import com.pth.iflow.common.annotations.IflowPostRequestMapping;
import com.pth.iflow.common.controllers.helper.ControllerHelper;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.models.edo.DepartmentEdo;
import com.pth.iflow.common.models.edo.UserListEdo;
import com.pth.iflow.common.moduls.security.RestAccessRoles;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.Department;
import com.pth.iflow.profile.model.User;
import com.pth.iflow.profile.model.mapper.ProfileModelEdoMapper;
import com.pth.iflow.profile.service.handler.IDepartmentsHandlerService;
import com.pth.iflow.profile.service.handler.ITokenUserDataManager;

@RestController
@RequestMapping
public class DepartmentController {

  private final ITokenUserDataManager tokenUserDataManager;
  private final IDepartmentsHandlerService departmentsHandlerService;

  public DepartmentController(@Autowired final ITokenUserDataManager tokenUserDataManager,
      @Autowired final IDepartmentsHandlerService departmentsHandlerService) {

    this.tokenUserDataManager = tokenUserDataManager;
    this.departmentsHandlerService = departmentsHandlerService;
  }

  @ResponseStatus(HttpStatus.OK)
  @PreAuthorize(RestAccessRoles.General.HAS_ROLE_USER)
  @IflowGetRequestMapping(value = IflowRestPaths.ProfileModule.DEPARTMENT_READ_BY_IDENTITY)
  @ResponseBody
  public ResponseEntity<DepartmentEdo> readById(@PathVariable(name = "identity") final String identity, final HttpServletRequest request,
      final Authentication authentication)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException, IFlowMessageConversionFailureException {

    final Department model = this.departmentsHandlerService.getDepartmentByIdentity(identity);

    return ControllerHelper.createResponseEntity(request, ProfileModelEdoMapper.toEdo(model), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @PreAuthorize(RestAccessRoles.General.HAS_ROLE_USER)
  @IflowGetRequestMapping(value = IflowRestPaths.ProfileModule.DEPARTMENT_READ_ALLUSERS_LIST)
  @ResponseBody
  public ResponseEntity<UserListEdo> readUserList(@PathVariable(name = "identity") final String identity, final HttpServletRequest request,
      final Authentication authentication)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException, IFlowMessageConversionFailureException {

    final List<User> list = this.tokenUserDataManager.getAllUserListByDepartmentId(authentication, identity);

    final UserListEdo edo = new UserListEdo(ProfileModelEdoMapper.toUserEdoList(list));

    return ControllerHelper.createResponseEntity(request, edo, HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PreAuthorize(RestAccessRoles.Departments.DEPARTMENTS_SAVE)
  @IflowPostRequestMapping(value = IflowRestPaths.ProfileModule.DEPARTMENT_SAVE)
  @ResponseBody
  public ResponseEntity<DepartmentEdo> saveDepartment(@RequestBody final DepartmentEdo departmentEdo,
      final HttpServletRequest request,
      final Authentication authentication)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException, IFlowMessageConversionFailureException {

    final Department model = this.departmentsHandlerService.saveDepartment(ProfileModelEdoMapper.fromEdo(departmentEdo));

    return ControllerHelper.createResponseEntity(request, ProfileModelEdoMapper.toEdo(model), HttpStatus.CREATED);
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @PreAuthorize(RestAccessRoles.Departments.DEPARTMENTS_DELETE)
  @IflowPostRequestMapping(value = IflowRestPaths.ProfileModule.DEPARTMENT_DELETE)
  @ResponseBody
  public void deleteDepartment(@RequestBody final DepartmentEdo departmentEdo,
      final HttpServletRequest request,
      final Authentication authentication)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException, IFlowMessageConversionFailureException {

    this.departmentsHandlerService.deleteDepartment(ProfileModelEdoMapper.fromEdo(departmentEdo));

  }

}
