package com.pth.iflow.backend.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pth.iflow.backend.configurations.IBackendConfiguration;
import com.pth.iflow.backend.helper.BuildInfoProperties;

@RestController(value = "/")
public class MainController {
  
  @Autowired
  private IBackendConfiguration backendConfigurations;

  @Autowired
  BuildInfoProperties buildInfoProperties;
  
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = "/about", produces = MediaType.APPLICATION_XML_VALUE)
  public BuildInfoProperties about() {

    return this.buildInfoProperties;
  }
  
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = "/test", produces = MediaType.APPLICATION_XML_VALUE)
  public Map<String, String> test() {
    final Map<String, String> map = new HashMap<>();
    map.put("valid-email", this.backendConfigurations.getBackendValidEMail());
    
    return map;
  }
}
