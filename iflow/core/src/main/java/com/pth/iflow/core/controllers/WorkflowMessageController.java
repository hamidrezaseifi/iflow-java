package com.pth.iflow.core.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pth.iflow.common.annotations.IflowGetRequestMapping;
import com.pth.iflow.common.annotations.IflowPostRequestMapping;
import com.pth.iflow.common.controllers.helper.ControllerHelper;
import com.pth.iflow.common.edo.models.WorkflowMessageEdo;
import com.pth.iflow.common.edo.models.WorkflowMessageListEdo;
import com.pth.iflow.common.enums.EWorkflowMessageStatus;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.core.model.entity.workflow.WorkflowMessageEntity;
import com.pth.iflow.core.service.interfaces.IWorkflowMessageService;

@RestController
@RequestMapping
public class WorkflowMessageController {

  final IWorkflowMessageService workflowMessageService;

  public WorkflowMessageController(@Autowired final IWorkflowMessageService workflowMessageService) {
    this.workflowMessageService = workflowMessageService;

  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.WORKFLOWMESSAGE_READ_BY_USEREMAIL)
  public ResponseEntity<WorkflowMessageListEdo> readWorkflowMessage(@PathVariable(name = "email") final String email,
      @PathVariable(required = false) final Integer status, final HttpServletRequest request) throws Exception {

    final List<WorkflowMessageEntity> messageList = this.workflowMessageService.getNotClosedNotExpiredListByUserEmail(email);

    return ControllerHelper.createResponseEntity(request,
        new WorkflowMessageListEdo(this.workflowMessageService.toEdoList(messageList)), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.WORKFLOWMESSAGE_READ_BY_WORKFLOWIDENTITY)
  public ResponseEntity<WorkflowMessageListEdo> readWorkflowMessageByWorkflow(
      @PathVariable(name = "workflowid") final String workflowid, final HttpServletRequest request) throws Exception {

    final List<WorkflowMessageEntity> messageList = this.workflowMessageService.getNotClosedNotExpiredListByWorkflowId(workflowid);

    return ControllerHelper.createResponseEntity(request,
        new WorkflowMessageListEdo(this.workflowMessageService.toEdoList(messageList)), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @IflowPostRequestMapping(path = IflowRestPaths.CoreModule.WORKFLOWMESSAGE_SAVE)
  public ResponseEntity<WorkflowMessageEdo> saveWorkflowMessage(@RequestBody(required = true) final WorkflowMessageEdo message,
      final HttpServletRequest request) throws Exception {

    final WorkflowMessageEntity result = this.workflowMessageService.save(this.workflowMessageService.fromEdo(message));

    return ControllerHelper.createResponseEntity(request, this.workflowMessageService.toEdo(result), HttpStatus.CREATED);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.WORKFLOWMESSAGE_CHANGE_WORKFLOWMESSAGE_STAUS_BY_WORKFLOWIDENTITY)
  public void updateWorkflowMessage(@PathVariable(name = "workflowid") final String workflowid,
      @PathVariable(name = "stepidentity") final String stepidentity, @PathVariable(name = "email") final String email,
      @PathVariable(name = "status") final Integer status, final HttpServletRequest request) throws Exception {

    this.workflowMessageService.updateWorkflowMessageStatus(workflowid, stepidentity, email, EWorkflowMessageStatus.ofValue(status));

  }

}
