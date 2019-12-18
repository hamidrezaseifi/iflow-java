package com.pth.iflow.core.controllers.workflow;

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
import com.pth.iflow.common.edo.models.workflow.results.WorkflowResultListEdo;
import com.pth.iflow.common.models.IdentityListEdo;
import com.pth.iflow.common.models.WorkflowSearchFilterEdo;
import com.pth.iflow.common.models.workflow.WorkflowEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.core.model.entity.workflow.WorkflowEntity;
import com.pth.iflow.core.model.entity.workflow.WorkflowResultEntity;
import com.pth.iflow.core.service.interfaces.IWorkflowSearchService;
import com.pth.iflow.core.service.interfaces.workflow.IWorkflowService;

@RestController
@RequestMapping
public class WorkflowController {

  final IWorkflowSearchService workflowSearchService;
  final IWorkflowService       workflowService;

  public WorkflowController(@Autowired final IWorkflowSearchService workflowSearchService,
      @Autowired final IWorkflowService workflowService) {
    this.workflowSearchService = workflowSearchService;
    this.workflowService = workflowService;
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.WORKFLOW_READ_BY_IDENTITY)
  public ResponseEntity<WorkflowEdo> readWorkflow(@PathVariable(name = "identity") final String identity,
      final HttpServletRequest request) throws Exception {

    final WorkflowEntity model = this.workflowService.getByIdentity(identity);

    return ControllerHelper.createResponseEntity(request, this.workflowService.toEdo(model), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @IflowPostRequestMapping(path = IflowRestPaths.CoreModule.WORKFLOW_SEARCH)
  public ResponseEntity<WorkflowResultListEdo> searchWorkflow(@RequestBody final WorkflowSearchFilterEdo workflowSearchFilterEdo,
      final HttpServletRequest request) throws Exception {

    final List<WorkflowResultEntity> modelList = this.workflowSearchService
        .search(this.workflowSearchService.fromWorkflowSearchFilterEdo(workflowSearchFilterEdo));

    return ControllerHelper.createResponseEntity(request, new WorkflowResultListEdo(this.workflowSearchService.toEdoList(modelList)),
        HttpStatus.ACCEPTED);
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @IflowPostRequestMapping(path = IflowRestPaths.CoreModule.WORKFLOW_READLIST)
  public ResponseEntity<WorkflowResultListEdo> realWorkflowList(@RequestBody final IdentityListEdo identityList,
      final HttpServletRequest request) throws Exception {

    final List<WorkflowResultEntity> modelList = this.workflowSearchService.readByIdentityList(identityList.getIdentityList());

    return ControllerHelper.createResponseEntity(request, new WorkflowResultListEdo(this.workflowSearchService.toEdoList(modelList)),
        HttpStatus.ACCEPTED);
  }

}
