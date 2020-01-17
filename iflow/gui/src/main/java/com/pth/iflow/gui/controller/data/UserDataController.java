package com.pth.iflow.gui.controller.data;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pth.iflow.gui.models.User;

@Controller
@RequestMapping(value = "/users/data")
public class UserDataController extends GuiDataControllerBase {

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/list" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public List<User> listUsers() {

    return map;
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = { "/save" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public User saveUser(@RequestBody final User requestUser) {

  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = { "/delete" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public User saveUser(@RequestBody final User requestUser) {

  }

}
