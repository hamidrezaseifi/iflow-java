package com.pth.iflow.backend.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pth.iflow.backend.configurations.IBackendConfiguration;
import com.pth.iflow.backend.helper.BuildInfoProperties;

@Controller
@RequestMapping(value = "/")
public class MainController extends BackendControllerBase {

  @Autowired
  private IBackendConfiguration backendConfigurations;
  
  @Autowired
  BuildInfoProperties buildInfoProperties;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = "/")
  public String index() {
    
    return "site/index";
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = "/about", produces = MediaType.APPLICATION_XML_VALUE)
  @ResponseBody
  public BuildInfoProperties about() {
    
    return this.buildInfoProperties;
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = "/test", produces = MediaType.APPLICATION_XML_VALUE)
  @ResponseBody
  public Map<String, String> test() {
    final Map<String, String> map = new HashMap<>();
    map.put("valid-email", this.backendConfigurations.getBackendValidEMail());

    return map;
  }
}
