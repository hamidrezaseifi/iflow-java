package com.pth.iflow.backend.controller.page;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping(value = "/")
public class MainController {

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = "/")
  public String index() {

    return "site/index";
  }

}
