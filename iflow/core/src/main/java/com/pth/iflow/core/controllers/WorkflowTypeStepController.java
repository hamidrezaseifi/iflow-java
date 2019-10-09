package com.pth.iflow.core.controllers;

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
import com.pth.iflow.common.edo.models.WorkflowTypeStepEdo;
import com.pth.iflow.common.edo.models.WorkflowTypeStepListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.core.model.WorkflowTypeStep;
import com.pth.iflow.core.model.mapper.CoreModelEdoMapper;
import com.pth.iflow.core.service.IWorkflowTypeStepService;

@RestController
@RequestMapping
public class WorkflowTypeStepController {

  final IWorkflowTypeStepService workflowStepService;

  public WorkflowTypeStepController(@Autowired final IWorkflowTypeStepService workflowStepService) {
    this.workflowStepService = workflowStepService;
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.WORKFLOWTYPESTEP_READ_BY_ID)
  public ResponseEntity<WorkflowTypeStepEdo> readDepartmentGroup(@PathVariable final Long id, final HttpServletRequest request)
      throws Exception {

    final WorkflowTypeStep model = this.workflowStepService.getById(id);

    return ControllerHelper.createResponseEntity(request, CoreModelEdoMapper.toEdo(model), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowPostRequestMapping(path = IflowRestPaths.CoreModule.WORKFLOWTYPESTEP_READ_LIST)
  public ResponseEntity<WorkflowTypeStepListEdo> readDepartmentList(@RequestBody final Set<String> idList,
      final HttpServletRequest request) throws Exception {

    final Set<WorkflowTypeStep> modelList = this.workflowStepService.getListByIdentityList(idList);

    return ControllerHelper.createResponseEntity(request,
        new WorkflowTypeStepListEdo(CoreModelEdoMapper.toWorkflowTypeStepEdoSet(modelList)), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.WORKFLOWTYPESTEP_READ_LIST_BY_WORKFLOW)
  public ResponseEntity<WorkflowTypeStepListEdo> readDepartmentListByCompany(@PathVariable final Long id,
      final HttpServletRequest request) throws Exception {

    final Set<WorkflowTypeStep> modelList = this.workflowStepService.getListByWorkflowTypeId(id);

    return ControllerHelper.createResponseEntity(request,
        new WorkflowTypeStepListEdo(CoreModelEdoMapper.toWorkflowTypeStepEdoSet(modelList)), HttpStatus.OK);
  }

}
