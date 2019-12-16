package com.pth.iflow.gui.controller.page;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping(value = "/")
public class MainController {

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/", "/about", "/workflow/*", "/workflow/**" })
  public String index() {

    return "ang/index";
  }

}
