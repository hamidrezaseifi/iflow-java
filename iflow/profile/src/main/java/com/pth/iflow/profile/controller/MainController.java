package com.pth.iflow.profile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pth.iflow.profile.helper.BuildInfoProperties;

@RestController
@RequestMapping(path = "/")
public class MainController {
  
  @Autowired
  BuildInfoProperties buildInfoProperties;
  
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = "/about", produces = MediaType.APPLICATION_XML_VALUE)
  public BuildInfoProperties about() {
    return this.buildInfoProperties;
  }
  
}
