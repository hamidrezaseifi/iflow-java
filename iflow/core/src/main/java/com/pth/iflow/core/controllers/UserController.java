package com.pth.iflow.core.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pth.iflow.common.annotations.IflowGetRequestMapping;
import com.pth.iflow.common.annotations.IflowPostRequestMapping;
import com.pth.iflow.common.controllers.helper.ControllerHelper;
import com.pth.iflow.common.edo.models.base.ModelMapperBase;
import com.pth.iflow.common.edo.models.xml.DepartmentEdo;
import com.pth.iflow.common.edo.models.xml.DepartmentGroupEdo;
import com.pth.iflow.common.edo.models.xml.UserEdo;
import com.pth.iflow.common.edo.models.xml.UserGroupEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.core.model.Department;
import com.pth.iflow.core.model.DepartmentGroup;
import com.pth.iflow.core.model.User;
import com.pth.iflow.core.model.UserGroup;
import com.pth.iflow.core.service.IUsersService;

@RestController
@RequestMapping
public class UserController {

  final IUsersService usersService;

  public UserController(@Autowired final IUsersService usersService) {
    this.usersService = usersService;
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModul.USER_READ_BY_ID)
  public ResponseEntity<UserEdo> readUser(@PathVariable final Long userid, final HttpServletRequest request) throws Exception {

    final User user = this.usersService.getUserById(userid);

    return ControllerHelper.createResponseEntity(request, user.toEdo(), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @IflowPostRequestMapping(path = IflowRestPaths.CoreModul.USER_SAVE)
  public ResponseEntity<UserEdo> saveUser(@PathVariable final UserEdo userEdo, final HttpServletRequest request) throws Exception {

    final User user = this.usersService.save(new User().fromEdo(userEdo));

    return ControllerHelper.createResponseEntity(request, user.toEdo(), HttpStatus.ACCEPTED);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModul.USER_READ_BY_EMAIL)
  public ResponseEntity<UserEdo> readUserByEmail(@PathVariable final String email, final HttpServletRequest request) throws Exception {

    final User user = this.usersService.getUserByEmail(email);

    return ControllerHelper.createResponseEntity(request, user.toEdo(), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModul.USER_USERGROUPS_LIST)
  public ResponseEntity<List<UserGroupEdo>> readUserGroups(@PathVariable final Long userid, final HttpServletRequest request)
      throws Exception {

    final List<UserGroup> groups = this.usersService.getUserGroups(userid);

    return ControllerHelper.createResponseEntity(request, ModelMapperBase.toEdoList(groups), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModul.USER_DEPARTMENTS_LIST)
  public ResponseEntity<List<DepartmentEdo>> readUserDepartments(@PathVariable final Long userid, final HttpServletRequest request)
      throws Exception {

    final List<Department> list = this.usersService.getUserDepartments(userid);

    return ControllerHelper.createResponseEntity(request, ModelMapperBase.toEdoList(list), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModul.USER_DEPARTMENTGROUPS_LIST)
  public ResponseEntity<List<DepartmentGroupEdo>> readUserDepartmentGroups(@PathVariable final Long userid,
      final HttpServletRequest request) throws Exception {

    final List<DepartmentGroup> list = this.usersService.getUserDepartmentGroups(userid);

    return ControllerHelper.createResponseEntity(request, ModelMapperBase.toEdoList(list), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModul.USER_DEPUTIES_LIST)
  public ResponseEntity<List<UserEdo>> readUserDeputies(@PathVariable final Long userid, final HttpServletRequest request)
      throws Exception {

    final List<User> list = this.usersService.getUserDeputies(userid);

    return ControllerHelper.createResponseEntity(request, ModelMapperBase.toEdoList(list), HttpStatus.OK);
  }
}
