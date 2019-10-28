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
import com.pth.iflow.common.edo.models.DepartmentGroupListEdo;
import com.pth.iflow.common.edo.models.DepartmentListEdo;
import com.pth.iflow.common.edo.models.ProfileResponseEdo;
import com.pth.iflow.common.edo.models.UserEdo;
import com.pth.iflow.common.edo.models.UserGroupListEdo;
import com.pth.iflow.common.edo.models.UserListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.core.model.Department;
import com.pth.iflow.core.model.DepartmentGroup;
import com.pth.iflow.core.model.ProfileResponse;
import com.pth.iflow.core.model.User;
import com.pth.iflow.core.model.UserGroup;
import com.pth.iflow.core.model.mapper.CoreModelEdoMapper;
import com.pth.iflow.core.service.IUsersService;

@RestController
@RequestMapping
public class UserController {

  final IUsersService usersService;

  public UserController(@Autowired final IUsersService usersService) {
    this.usersService = usersService;
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @IflowPostRequestMapping(path = IflowRestPaths.CoreModule.USER_SAVE)
  public ResponseEntity<UserEdo> saveUser(@PathVariable final UserEdo userEdo, final HttpServletRequest request) throws Exception {

    final User user = this.usersService.save(CoreModelEdoMapper.fromEdo(userEdo));

    return ControllerHelper.createResponseEntity(request, CoreModelEdoMapper.toEdo(user), HttpStatus.ACCEPTED);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.USER_READ_BY_EMAIL)
  public ResponseEntity<UserEdo> readUserByEmail(@PathVariable(name = "email") final String email, final HttpServletRequest request)
      throws Exception {

    final User user = this.usersService.getUserByEmail(email);

    return ControllerHelper.createResponseEntity(request, CoreModelEdoMapper.toEdo(user), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.USER_USERGROUPS_LIST_BY_EMAIL)
  public ResponseEntity<UserGroupListEdo> readUserGroups(@PathVariable(name = "email") final String email,
      final HttpServletRequest request) throws Exception {

    final List<UserGroup> groups = this.usersService.getUserGroups(email);

    return ControllerHelper.createResponseEntity(request, new UserGroupListEdo(CoreModelEdoMapper.toUserGroupEdoList(groups)),
        HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.USER_DEPARTMENTS_LIST_BY_EMAIL)
  public ResponseEntity<DepartmentListEdo> readUserDepartments(@PathVariable(name = "email") final String email,
      final HttpServletRequest request) throws Exception {

    final List<Department> list = this.usersService.getUserDepartments(email);

    return ControllerHelper.createResponseEntity(request, new DepartmentListEdo(CoreModelEdoMapper.toDepartmentEdoList(list)),
        HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.USER_DEPARTMENTGROUPS_LIST_BY_EMAIL)
  public ResponseEntity<DepartmentGroupListEdo> readUserDepartmentGroups(@PathVariable(name = "email") final String email,
      final HttpServletRequest request) throws Exception {

    final List<DepartmentGroup> list = this.usersService.getUserDepartmentGroups(email);

    return ControllerHelper.createResponseEntity(request,
        new DepartmentGroupListEdo(CoreModelEdoMapper.toDepartmentGroupEdoList(list)), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.USER_DEPUTIES_LIST_BY_EMAIL)
  public ResponseEntity<UserListEdo> readUserDeputies(@PathVariable(name = "email") final String email,
      final HttpServletRequest request) throws Exception {

    final List<User> list = this.usersService.getUserDeputies(email);
    final UserListEdo edo = new UserListEdo();
    edo.setUsers(CoreModelEdoMapper.toUserEdoList(list));
    return ControllerHelper.createResponseEntity(request, edo, HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.USER_USER_LIST_BY_COMPANYIDENTITY)
  public ResponseEntity<UserListEdo> readCompanyUsers(@PathVariable(name = "companyidentity") final String companyidentity,
      final HttpServletRequest request) throws Exception {

    final List<User> list = this.usersService.getCompanyUsers(companyidentity);
    final UserListEdo edo = new UserListEdo();
    edo.setUsers(CoreModelEdoMapper.toUserEdoList(list));
    return ControllerHelper.createResponseEntity(request, edo, HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.USERPROFILE_READ_BY_EMAIL)
  public ResponseEntity<ProfileResponseEdo> readUserProfileByEmail(@PathVariable(name = "email") final String email,
      final HttpServletRequest request) throws Exception {

    final ProfileResponse profile = this.usersService.getProfileResponseByEmail(email);

    return ControllerHelper.createResponseEntity(request, CoreModelEdoMapper.toEdo(profile), HttpStatus.OK);
  }
}
