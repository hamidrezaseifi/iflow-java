package com.pth.iflow.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pth.iflow.common.edo.models.UserEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.core.model.User;
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

    final User user = usersService.getUserById(userid);

    return new ResponseEntity<>(user.toEdo(), HttpStatus.ACCEPTED);
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @GetMapping(path = IflowRestPaths.Core.USER_READ_BY_EMAIL, produces = MediaType.APPLICATION_XML_VALUE)
  public ResponseEntity<UserEdo> readUserByEmail(@PathVariable final String email) throws Exception {

    final User user = usersService.getUserByEmail(email);

    return new ResponseEntity<>(user.toEdo(), HttpStatus.ACCEPTED);
  }
}
