package com.pth.iflow.gui.controller.data;

import java.net.MalformedURLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.models.User;
import com.pth.iflow.gui.services.IUserHandler;

@Controller
@RequestMapping(value = "/users/data")
public class UserDataController extends GuiDataControllerBase {

  @Autowired
  private IUserHandler userHandler;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/list" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public List<User> listUsers() throws MalformedURLException, IFlowMessageConversionFailureException {

    return this.userHandler.getCompanyUserList(this.getLoggedCompany().getIdentity());
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = { "/create" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public User createUser(@RequestBody final User requestUser) throws MalformedURLException, IFlowMessageConversionFailureException {

    requestUser.setCompanyIdentity(this.getLoggedCompany().getIdentity());
    final User user = this.userHandler.saveUser(requestUser);
    return user;
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = { "/update" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public User saveUser(@RequestBody final User requestUser) throws MalformedURLException, IFlowMessageConversionFailureException {

    requestUser.setCompanyIdentity(this.getLoggedCompany().getIdentity());
    final User user = this.userHandler.saveUser(requestUser);
    return user;
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = { "/delete" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public void deleteUser(@RequestBody final User user) throws MalformedURLException, IFlowMessageConversionFailureException {

    this.userHandler.deleteUser(user);
  }

}
