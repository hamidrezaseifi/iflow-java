package com.pth.iflow.core.controllers;

import java.util.List;
import java.util.Set;

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
import com.pth.iflow.common.edo.models.WorkflowActionEdo;
import com.pth.iflow.common.edo.models.WorkflowActionListEdo;
import com.pth.iflow.common.edo.models.WorkflowEdo;
import com.pth.iflow.common.edo.models.WorkflowFileEdo;
import com.pth.iflow.common.edo.models.WorkflowFileListEdo;
import com.pth.iflow.common.edo.models.WorkflowListEdo;
import com.pth.iflow.common.edo.models.WorkflowSearchFilterEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.core.model.Workflow;
import com.pth.iflow.core.model.WorkflowAction;
import com.pth.iflow.core.model.WorkflowFile;
import com.pth.iflow.core.model.mapper.CoreModelEdoMapper;
import com.pth.iflow.core.service.IWorkflowActionService;
import com.pth.iflow.core.service.IWorkflowFileService;
import com.pth.iflow.core.service.IWorkflowService;

@RestController
@RequestMapping
public class WorkflowController {

  final IWorkflowService       workflowService;
  final IWorkflowActionService workflowActionService;
  final IWorkflowFileService   workflowFileService;

  public WorkflowController(@Autowired final IWorkflowService workflowService,
      @Autowired final IWorkflowActionService workflowActionService, @Autowired final IWorkflowFileService workflowFileService) {
    this.workflowService = workflowService;
    this.workflowActionService = workflowActionService;
    this.workflowFileService = workflowFileService;
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.WORKFLOW_READ_BY_IDENTITY)
  public ResponseEntity<WorkflowEdo> readWorkflow(@PathVariable(name = "identity") final String identity,
      final HttpServletRequest request) throws Exception {

    final Workflow model = this.workflowService.getByIdentity(identity);

    return ControllerHelper.createResponseEntity(request, CoreModelEdoMapper.toEdo(model), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @IflowPostRequestMapping(path = IflowRestPaths.CoreModule.WORKFLOW_SAVE)
  public ResponseEntity<WorkflowEdo> saveWorkflow(@RequestBody final WorkflowEdo workflowEdo, final HttpServletRequest request)
      throws Exception {

    final Workflow model = this.workflowService.save(CoreModelEdoMapper.fromEdo(workflowEdo));
    return ControllerHelper.createResponseEntity(request, CoreModelEdoMapper.toEdo(model), HttpStatus.ACCEPTED);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowPostRequestMapping(path = IflowRestPaths.CoreModule.WORKFLOW_READ_LIST)
  public ResponseEntity<WorkflowListEdo> readWorkflowList(@RequestBody final Set<String> idList, final HttpServletRequest request)
      throws Exception {

    final List<Workflow> modelList = this.workflowService.getListByIdentityList(idList);

    return ControllerHelper.createResponseEntity(request, new WorkflowListEdo(CoreModelEdoMapper.toWorkflowEdoList(modelList)),
        HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.WORKFLOW_READ_LIST_BY_TYPEIDENTITY)
  public ResponseEntity<WorkflowListEdo> readWorkflowListByType(@PathVariable(name = "identity") final String identity,
      final HttpServletRequest request) throws Exception {

    final List<Workflow> modelList = this.workflowService.getListByTypeId(identity);

    return ControllerHelper.createResponseEntity(request, new WorkflowListEdo(CoreModelEdoMapper.toWorkflowEdoList(modelList)),
        HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.WORKFLOW_READ_LIST_BY_USEREMAIL)
  public ResponseEntity<WorkflowListEdo> readWorkflowListForUser(@PathVariable(name = "email") final String email,
      @PathVariable(required = false) final int status, final HttpServletRequest request) throws Exception {

    final List<Workflow> modelList = this.workflowService.getListForUser(email, status);

    return ControllerHelper.createResponseEntity(request, new WorkflowListEdo(CoreModelEdoMapper.toWorkflowEdoList(modelList)),
        HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.WORKFLOW_ACTION_READ_BY_IDENTITY)
  public ResponseEntity<WorkflowActionEdo> readWorkflowAction(@PathVariable(name = "identity") final String identity,
      final HttpServletRequest request) throws Exception {

    final WorkflowAction model = this.workflowActionService.getByIdentity(identity);

    return ControllerHelper.createResponseEntity(request, CoreModelEdoMapper.toEdo(model), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @IflowPostRequestMapping(path = IflowRestPaths.CoreModule.WORKFLOW_ACTION_SAVE)
  public ResponseEntity<WorkflowActionEdo> saveWorkflowAction(@RequestBody final WorkflowActionEdo workflowActionEdo,
      final HttpServletRequest request) throws Exception {

    final WorkflowAction model = this.workflowActionService.save(CoreModelEdoMapper.fromEdo(workflowActionEdo));

    return ControllerHelper.createResponseEntity(request, CoreModelEdoMapper.toEdo(model), HttpStatus.ACCEPTED);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.WORKFLOW_ACTION_READ_LIST_BY_WORKFLOWIDENTITY)
  public ResponseEntity<WorkflowActionListEdo> readWorkflowActionListByWorkflow(@PathVariable(name = "identity") final String identity,
      final HttpServletRequest request) throws Exception {

    final List<WorkflowAction> modelList = this.workflowActionService.getListByIdWorkflowId(identity);

    return ControllerHelper.createResponseEntity(request,
        new WorkflowActionListEdo(CoreModelEdoMapper.toWorkflowActionEdoList(modelList)), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.WORKFLOW_FILE_READ_BY_IDENTITY)
  public ResponseEntity<WorkflowFileEdo> readWorkflowFile(@PathVariable(name = "identity") final String identity,
      final HttpServletRequest request) throws Exception {

    final WorkflowFile model = this.workflowFileService.getByIdentity(identity);

    return ControllerHelper.createResponseEntity(request, CoreModelEdoMapper.toEdo(model), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @IflowPostRequestMapping(path = IflowRestPaths.CoreModule.WORKFLOW_FILE_SAVE)
  public ResponseEntity<WorkflowFileEdo> saveWorkflowFile(@RequestBody final WorkflowFileEdo workflowActionEdo,
      final HttpServletRequest request) throws Exception {

    final WorkflowFile model = this.workflowFileService.save(CoreModelEdoMapper.fromEdo(workflowActionEdo));

    return ControllerHelper.createResponseEntity(request, CoreModelEdoMapper.toEdo(model), HttpStatus.ACCEPTED);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.WORKFLOW_FILE_READ_LIST_BY_WORKFLOWIDENTITY)
  public ResponseEntity<WorkflowFileListEdo> readWorkflowFileListByWorkflow(@PathVariable(name = "identity") final String identity,
      final HttpServletRequest request) throws Exception {

    final List<WorkflowFile> modelList = this.workflowFileService.getListByIdWorkflowIdentity(identity);

    return ControllerHelper.createResponseEntity(request, new WorkflowFileListEdo(CoreModelEdoMapper.toWorkflowFileEdoList(modelList)),
        HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @IflowPostRequestMapping(path = IflowRestPaths.CoreModule.WORKFLOW_SEARCH)
  public ResponseEntity<WorkflowListEdo> searchWorkflow(@RequestBody final WorkflowSearchFilterEdo workflowSearchFilterEdo,
      final HttpServletRequest request) throws Exception {

    final List<Workflow> modelList = this.workflowService.search(CoreModelEdoMapper.fromEdo(workflowSearchFilterEdo));

    return ControllerHelper.createResponseEntity(request, new WorkflowListEdo(CoreModelEdoMapper.toWorkflowEdoList(modelList)),
        HttpStatus.ACCEPTED);
  }

}
