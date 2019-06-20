package com.pth.iflow.core.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pth.iflow.common.edo.models.DepartmentEdo;
import com.pth.iflow.common.edo.models.DepartmentGroupEdo;
import com.pth.iflow.common.edo.models.UserEdo;
import com.pth.iflow.common.edo.models.UserGroupEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.core.controllers.helper.ControllerHelper;
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
  @GetMapping(path = IflowRestPaths.CoreModul.USER_READ_BY_ID, produces = {
      MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
  public ResponseEntity<UserEdo> readUser(@PathVariable final Long userid, final HttpServletRequest request) throws Exception {
    
    final User user = this.usersService.getUserById(userid);
    
    return ControllerHelper.createResponseEntity(request, user.toEdo(), HttpStatus.OK);
  }
  
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = IflowRestPaths.CoreModul.USER_READ_BY_EMAIL, produces = {
      MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
  public ResponseEntity<UserEdo> readUserByEmail(@PathVariable final String email, final HttpServletRequest request) throws Exception {
    
    final User user = this.usersService.getUserByEmail(email);
    
    return ControllerHelper.createResponseEntity(request, user.toEdo(), HttpStatus.OK);
  }
  
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = IflowRestPaths.CoreModul.USER_USERGROUPS_LIST, produces = {
      MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
  public ResponseEntity<List<UserGroupEdo>> readUserGroups(@PathVariable final Long userid, final HttpServletRequest request) throws Exception {
    
    final List<UserGroup> groups = this.usersService.getUserGroups(userid);
    
    return ControllerHelper.createResponseEntity(request, UserGroup.toEdoList(groups), HttpStatus.OK);
  }
  
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = IflowRestPaths.CoreModul.USER_DEPARTMENTS_LIST, produces = {
      MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
  public ResponseEntity<List<DepartmentEdo>> readUserDepartments(@PathVariable final Long userid, final HttpServletRequest request) throws Exception {
    
    final List<Department> list = this.usersService.getUserDepartments(userid);
    
    return ControllerHelper.createResponseEntity(request, Department.toEdoList(list), HttpStatus.OK);
  }
  
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = IflowRestPaths.CoreModul.USER_DEPARTMENTGROUPS_LIST, produces = {
      MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
  public ResponseEntity<List<DepartmentGroupEdo>> readUserDepartmentGroups(@PathVariable final Long userid, final HttpServletRequest request)
      throws Exception {
    
    final List<DepartmentGroup> list = this.usersService.getUserDepartmentGroups(userid);
    
    return ControllerHelper.createResponseEntity(request, DepartmentGroup.toEdoList(list), HttpStatus.OK);
  }
  
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = IflowRestPaths.CoreModul.USER_DEPUTIES_LIST, produces = {
      MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
  public ResponseEntity<List<UserEdo>> readUserDeputies(@PathVariable final Long userid, final HttpServletRequest request) throws Exception {
    
    final List<User> list = this.usersService.getUserDeputies(userid);
    
    return ControllerHelper.createResponseEntity(request, User.toEdoList(list), HttpStatus.OK);
  }
}
