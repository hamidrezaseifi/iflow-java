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
import com.pth.iflow.core.model.ProfileResponse;
import com.pth.iflow.core.model.entity.DepartmentEntity;
import com.pth.iflow.core.model.entity.DepartmentGroupEntity;
import com.pth.iflow.core.model.entity.UserEntity;
import com.pth.iflow.core.model.entity.UserGroupEntity;
import com.pth.iflow.core.service.interfaces.IDepartmentGroupService;
import com.pth.iflow.core.service.interfaces.IDepartmentService;
import com.pth.iflow.core.service.interfaces.IUserGroupService;
import com.pth.iflow.core.service.interfaces.IUsersService;

@RestController
@RequestMapping
public class UserController {

  final IUsersService           usersService;
  final IUserGroupService       userGroupService;
  final IDepartmentService      departmentService;
  final IDepartmentGroupService departmentGroupService;

  public UserController(@Autowired final IUsersService usersService, @Autowired final IUserGroupService userGroupService,
      @Autowired final IDepartmentService departmentService, @Autowired final IDepartmentGroupService departmentGroupService) {
    this.usersService = usersService;
    this.userGroupService = userGroupService;
    this.departmentService = departmentService;
    this.departmentGroupService = departmentGroupService;
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @IflowPostRequestMapping(path = IflowRestPaths.CoreModule.USER_SAVE)
  public ResponseEntity<UserEdo> saveUser(@PathVariable final UserEdo userEdo, final HttpServletRequest request) throws Exception {

    final UserEntity user = this.usersService.save(this.usersService.fromEdo(userEdo));

    return ControllerHelper.createResponseEntity(request, this.usersService.toEdo(user), HttpStatus.ACCEPTED);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.USER_READ_BY_EMAIL)
  public ResponseEntity<UserEdo> readUserByEmail(@PathVariable(name = "email") final String email, final HttpServletRequest request)
      throws Exception {

    final UserEntity user = this.usersService.getUserByIdentity(email);

    return ControllerHelper.createResponseEntity(request, this.usersService.toEdo(user), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.USER_USERGROUPS_LIST_BY_EMAIL)
  public ResponseEntity<UserGroupListEdo> readUserGroups(@PathVariable(name = "email") final String email,
      final HttpServletRequest request) throws Exception {

    final List<UserGroupEntity> groups = this.usersService.getUserGroups(email);

    return ControllerHelper.createResponseEntity(request, new UserGroupListEdo(this.userGroupService.toEdoList(groups)),
        HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.USER_DEPARTMENTS_LIST_BY_EMAIL)
  public ResponseEntity<DepartmentListEdo> readUserDepartments(@PathVariable(name = "email") final String email,
      final HttpServletRequest request) throws Exception {

    final List<DepartmentEntity> list = this.usersService.getUserDepartments(email);

    return ControllerHelper.createResponseEntity(request, new DepartmentListEdo(this.departmentService.toEdoList(list)),
        HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.USER_DEPARTMENTGROUPS_LIST_BY_EMAIL)
  public ResponseEntity<DepartmentGroupListEdo> readUserDepartmentGroups(@PathVariable(name = "email") final String email,
      final HttpServletRequest request) throws Exception {

    final List<DepartmentGroupEntity> list = this.usersService.getUserDepartmentGroups(email);

    return ControllerHelper.createResponseEntity(request, new DepartmentGroupListEdo(this.departmentGroupService.toEdoList(list)),
        HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.USER_DEPUTIES_LIST_BY_EMAIL)
  public ResponseEntity<UserListEdo> readUserDeputies(@PathVariable(name = "email") final String email,
      final HttpServletRequest request) throws Exception {

    final List<UserEntity> list = this.usersService.getUserDeputies(email);
    final UserListEdo edo = new UserListEdo();
    edo.setUsers(this.usersService.toEdoList(list));
    return ControllerHelper.createResponseEntity(request, edo, HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.USER_USER_LIST_BY_COMPANYIDENTITY)
  public ResponseEntity<UserListEdo> readCompanyUsers(@PathVariable(name = "companyidentity") final String companyidentity,
      final HttpServletRequest request) throws Exception {

    final List<UserEntity> list = this.usersService.getCompanyUsers(companyidentity);
    final UserListEdo edo = new UserListEdo();
    edo.setUsers(this.usersService.toEdoList(list));
    return ControllerHelper.createResponseEntity(request, edo, HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.USER_USER_LIST_BY_DEPARTMENTIDENTITY)
  public ResponseEntity<UserListEdo> readDepartmentUsers(@PathVariable(name = "identity") final String identity,
      final HttpServletRequest request) throws Exception {

    final List<UserEntity> list = this.usersService.getAllUserIdentityListByDepartmentIdentity(identity);
    final UserListEdo edo = new UserListEdo();
    edo.setUsers(this.usersService.toEdoList(list));
    return ControllerHelper.createResponseEntity(request, edo, HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.USER_USER_LIST_BY_DEPARTMENTGROUPIDENTITY)
  public ResponseEntity<UserListEdo> readDepartmentGroupUsers(@PathVariable(name = "identity") final String identity,
      final HttpServletRequest request) throws Exception {

    final List<UserEntity> list = this.usersService.getAllUserIdentityListByDepartmentGroupIdentity(identity);
    final UserListEdo edo = new UserListEdo();
    edo.setUsers(this.usersService.toEdoList(list));
    return ControllerHelper.createResponseEntity(request, edo, HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.USERPROFILE_READ_BY_EMAIL)
  public ResponseEntity<ProfileResponseEdo> readUserProfileByEmail(@PathVariable(name = "email") final String email,
      final HttpServletRequest request) throws Exception {

    final ProfileResponse profile = this.usersService.getProfileResponseByEmail(email);

    return ControllerHelper.createResponseEntity(request, this.usersService.toProfileResponseEdo(profile), HttpStatus.OK);
  }
}
