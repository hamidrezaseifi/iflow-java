package com.pth.iflow.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pth.iflow.backend.helper.BuildInfoProperties;
import com.pth.iflow.common.edo.models.WorkflowFileEdo;

@RestController(value = "/")
public class MainController {
  
  @Autowired
  BuildInfoProperties buildInfoProperties;
  
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = "/about", produces = MediaType.APPLICATION_XML_VALUE)
  public BuildInfoProperties about() {
    return this.buildInfoProperties;
  }
  
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = "/test", produces = MediaType.APPLICATION_XML_VALUE)
  public WorkflowFileEdo test() {
    final WorkflowFileEdo edo = new WorkflowFileEdo();
    
    return edo;
  }
}
