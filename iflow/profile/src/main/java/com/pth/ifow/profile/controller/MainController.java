package com.pth.ifow.profile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pth.iflow.common.edo.models.UserEdo;
import com.pth.ifow.profile.helper.BuildInfoProperties;
import com.pth.ifow.profile.model.User;

@RestController
@RequestMapping(path = "/")
public class MainController {

  @Autowired
  BuildInfoProperties buildInfoProperties;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = "/about", produces = MediaType.APPLICATION_XML_VALUE)
  public BuildInfoProperties about() {
    return buildInfoProperties;
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/testuser", produces = MediaType.APPLICATION_XML_VALUE)
  @ResponseBody
  public UserEdo testuser() {
    final User user = new User();
    user.setFirstName("firstName");
    user.setLastName("LastName");
    user.setPassword("Password");
    user.setPermission(1);
    user.setStatus(1);
    user.setEmail("UserName");
    user.setId(1L);
    return user.toEdo();
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/testuserjson", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public UserEdo testuserJson() {
    final User user = new User();
    user.setFirstName("firstName");
    user.setLastName("LastName");
    user.setPassword("Password");
    user.setPermission(1);
    user.setStatus(1);
    user.setEmail("UserName");
    user.setId(1L);
    return user.toEdo();
  }
}
