package com.pth.iflow.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pth.iflow.common.edo.models.WorkflowActionEdo;
import com.pth.iflow.common.edo.models.WorkflowFileEdo;
import com.pth.iflow.common.edo.models.WorkflowFileVersionEdo;
import com.pth.iflow.common.edo.models.workflow.WorkflowEdo;
import com.pth.iflow.common.edo.models.workflow.singletask.SingleTaskWorkflowEdo;
import com.pth.iflow.common.enums.EIdentity;
import com.pth.iflow.common.enums.EWorkflowType;
import com.pth.iflow.core.helper.BuildInfoProperties;

@RestController(value = "/")
public class MainController {

  @Autowired
  BuildInfoProperties buildInfoProperties;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = "/about", produces = MediaType.APPLICATION_XML_VALUE)
  public BuildInfoProperties about() {
    return buildInfoProperties;
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = "/test", produces = MediaType.APPLICATION_XML_VALUE)
  public SingleTaskWorkflowEdo test() {
    final SingleTaskWorkflowEdo edo = new SingleTaskWorkflowEdo();

    final WorkflowEdo workflow = new WorkflowEdo();
    workflow.setComments("comments");
    workflow.setControllerIdentity("admin@iflow.de");
    workflow.setCreatedByIdentity("admin@iflow.de");
    workflow.setCurrentStepIdentity("singletasktypestep");
    workflow.setStatus(1);
    workflow.setVersion(1);
    workflow.setWorkflowTypeIdentity(EWorkflowType.SINGLE_TASK_WORKFLOW_TYPE.getIdentity());
    workflow.setIdentity(EIdentity.NOT_SET.getIdentity());

    final WorkflowFileVersionEdo fver = new WorkflowFileVersionEdo();
    fver.setComments("comments");
    fver.setCreatedByIdentity("admin@iflow.de");
    fver.setFilePath("filePath");
    fver.setFileVersion(1);
    fver.setStatus(1);
    fver.setVersion(1);

    final WorkflowFileEdo f = new WorkflowFileEdo();
    f.setActiveFilePath("filePath");
    f.setActiveFileVersion(1);
    f.setComments("comments");
    f.setCreatedByIdentity("admin@iflow.de");
    f.setExtention("extention");
    f.setIdentity("identity");
    f.setStatus(1);
    f.setTitle("title");
    f.setVersion(1);
    f.getFileVersions().add(fver);

    workflow.getFiles().add(f);

    final WorkflowActionEdo ac = new WorkflowActionEdo();
    ac.setAssignToIdentity("");
    ac.setComments("comments");
    ac.setCurrentStepIdentity("singletasktypestep");
    ac.setIdentity("identity");
    ac.setStatus(1);
    ac.setVersion(1);

    workflow.getActions().add(ac);

    edo.setWorkflow(workflow);
    return edo;
  }
}
