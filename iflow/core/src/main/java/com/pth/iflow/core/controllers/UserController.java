package com.pth.iflow.core.controllers;

import java.util.List;

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
  
  @ResponseStatus(HttpStatus.ACCEPTED)
  @GetMapping(path = IflowRestPaths.Core.USER_READ_BY_ID, produces = MediaType.APPLICATION_XML_VALUE)
  public ResponseEntity<UserEdo> readUser(@PathVariable final Long userid) throws Exception {
    
    final User user = this.usersService.getUserById(userid);
    
    return new ResponseEntity<>(user.toEdo(), HttpStatus.ACCEPTED);
  }
  
  @ResponseStatus(HttpStatus.ACCEPTED)
  @GetMapping(path = IflowRestPaths.Core.USER_READ_BY_EMAIL, produces = MediaType.APPLICATION_XML_VALUE)
  public ResponseEntity<UserEdo> readUserByEmail(@PathVariable final String email) throws Exception {
    
    final User user = this.usersService.getUserByEmail(email);
    
    return new ResponseEntity<>(user.toEdo(), HttpStatus.ACCEPTED);
  }
  
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = IflowRestPaths.Core.USER_USERGROUPS_LIST, produces = MediaType.APPLICATION_XML_VALUE)
  public ResponseEntity<List<UserGroupEdo>> readUserGroups(@PathVariable final Long userid) throws Exception {
    
    final List<UserGroup> groups = this.usersService.getUserGroups(userid);
    
    final List<UserGroupEdo> edoList = User.toEdoList(groups);
    
    return new ResponseEntity<>(edoList, HttpStatus.OK);
  }
  
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = IflowRestPaths.Core.USER_DEPARTMENTS_LIST, produces = MediaType.APPLICATION_XML_VALUE)
  public ResponseEntity<List<DepartmentEdo>> readUserDepartments(@PathVariable final Long userid) throws Exception {
    
    final List<Department> list = this.usersService.getUserDepartments(userid);
    
    final List<DepartmentEdo> edoList = User.toEdoList(list);
    
    return new ResponseEntity<>(edoList, HttpStatus.OK);
  }
  
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = IflowRestPaths.Core.USER_DEPARTMENTGROUPS_LIST, produces = MediaType.APPLICATION_XML_VALUE)
  public ResponseEntity<List<DepartmentGroupEdo>> readUserDepartmentGroups(@PathVariable final Long userid)
      throws Exception {
    
    final List<DepartmentGroup> list = this.usersService.getUserDepartmentGroups(userid);
    
    final List<DepartmentGroupEdo> edoList = User.toEdoList(list);
    
    return new ResponseEntity<>(edoList, HttpStatus.OK);
  }
  
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = IflowRestPaths.Core.USER_DEPUTIES_LIST, produces = MediaType.APPLICATION_XML_VALUE)
  public ResponseEntity<List<UserEdo>> readUserDeputies(@PathVariable final Long userid) throws Exception {
    
    final List<User> list = this.usersService.getUserDeputies(userid);
    
    final List<UserEdo> edoList = User.toEdoList(list);
    
    return new ResponseEntity<>(edoList, HttpStatus.OK);
  }
}
