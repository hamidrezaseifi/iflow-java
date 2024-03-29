package com.pth.iflow.workflow.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.workflow.config.WorkflowConfiguration;
import com.pth.iflow.workflow.exceptions.WorkflowCustomizedException;

@RestController
@RequestMapping
public class MainController {

  @GetMapping(path = WorkflowConfiguration.NO_ACCESS_URL)
  public void showNoAccess() throws Exception {

    throw new WorkflowCustomizedException("No Access", "Invalid Token", EModule.WORKFLOW.getModuleName(),
        EIFlowErrorType.INVALID_TOKEN);

  }

  @GetMapping(path = WorkflowConfiguration.INVALID_TOKEN_URL)
  public void showInvalidToken() throws Exception {

    throw new WorkflowCustomizedException("Invalid Token", "Invalid Token", EModule.WORKFLOW.getModuleName(),
        EIFlowErrorType.INVALID_TOKEN);

  }

}
