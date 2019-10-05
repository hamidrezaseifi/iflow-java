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
import com.pth.iflow.core.model.WorkflowMessage;
import com.pth.iflow.core.model.mapper.CoreModelEdoMapper;
import com.pth.iflow.core.service.IWorkflowMessageService;

@RestController
@RequestMapping
public class WorkflowMessageController {

  final IWorkflowMessageService workflowMessageService;

  public WorkflowMessageController(@Autowired final IWorkflowMessageService workflowMessageService) {
    this.workflowMessageService = workflowMessageService;

  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.WORKFLOWMESSAGE_READ_BY_USER)
  public ResponseEntity<WorkflowMessageListEdo> readWorkflowMessage(@PathVariable(required = true) final Long userid,
      @PathVariable(required = false) final Integer status, final HttpServletRequest request) throws Exception {

    final List<WorkflowMessage> messageList = this.workflowMessageService.getNotClosedNotExpiredListByUserId(userid);

    return ControllerHelper.createResponseEntity(request,
        new WorkflowMessageListEdo(CoreModelEdoMapper.toWorkflowMessageEdoList(messageList)), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.WORKFLOWMESSAGE_READ_BY_WORKFLOW)
  public ResponseEntity<WorkflowMessageListEdo> readWorkflowMessageByWorkflow(@PathVariable(required = true) final Long workflowid,
      final HttpServletRequest request) throws Exception {

    final List<WorkflowMessage> messageList = this.workflowMessageService.getNotClosedNotExpiredListByWorkflowId(workflowid);

    return ControllerHelper.createResponseEntity(request,
        new WorkflowMessageListEdo(CoreModelEdoMapper.toWorkflowMessageEdoList(messageList)), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @IflowPostRequestMapping(path = IflowRestPaths.CoreModule.WORKFLOWMESSAGE_SAVE)
  public ResponseEntity<WorkflowMessageEdo> saveWorkflowMessage(@RequestBody(required = true) final WorkflowMessageEdo message,
      final HttpServletRequest request) throws Exception {

    final WorkflowMessage result = this.workflowMessageService.save(CoreModelEdoMapper.fromEdo(message));

    return ControllerHelper.createResponseEntity(request, CoreModelEdoMapper.toEdo(result), HttpStatus.CREATED);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.WORKFLOWMESSAGE_CHANGE_WORKFLOWMESSAGE_STAUS)
  public void updateWorkflowMessage(@PathVariable(required = true) final Long workflowid,
      @PathVariable(required = true) final Long stepid, @PathVariable(required = true) final Long userid,
      @PathVariable(required = true) final Integer status, final HttpServletRequest request) throws Exception {

    this.workflowMessageService.updateWorkflowMessageStatus(workflowid, stepid, userid, EWorkflowMessageStatus.ofValue(status));

  }

}
