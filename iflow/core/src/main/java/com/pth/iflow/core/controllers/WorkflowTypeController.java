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
import com.pth.iflow.common.edo.models.base.ModelMapperBase;
import com.pth.iflow.common.edo.models.xml.WorkflowTypeEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowTypeListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.core.model.WorkflowType;
import com.pth.iflow.core.service.IWorkflowTypeService;

@RestController
@RequestMapping
public class WorkflowTypeController {

  final IWorkflowTypeService workflowTypeService;

  public WorkflowTypeController(@Autowired final IWorkflowTypeService workflowTypeService) {
    this.workflowTypeService = workflowTypeService;
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.WORKFLOWTYPE_READ_BY_ID)
  public ResponseEntity<WorkflowTypeEdo> readWorkflow(@PathVariable final Long id, final HttpServletRequest request) throws Exception {

    final WorkflowType model = this.workflowTypeService.getById(id);

    return ControllerHelper.createResponseEntity(request, model.toEdo(), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowPostRequestMapping(path = IflowRestPaths.CoreModule.WORKFLOWTYPE_READ_LIST)
  public ResponseEntity<WorkflowTypeListEdo> readWorkflowList(@RequestBody final List<Long> idList, final HttpServletRequest request)
      throws Exception {

    final List<WorkflowType> modelList = this.workflowTypeService.getListByIdList(idList);

    return ControllerHelper.createResponseEntity(request, new WorkflowTypeListEdo(ModelMapperBase.toEdoList(modelList)),
        HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.WORKFLOWTYPE_READ_LIST_BY_COMPANY)
  public ResponseEntity<WorkflowTypeListEdo> readWorkflowListByCompany(@PathVariable final Long id, final HttpServletRequest request)
      throws Exception {

    final List<WorkflowType> modelList = this.workflowTypeService.getListByIdCompanyId(id);

    return ControllerHelper.createResponseEntity(request, new WorkflowTypeListEdo(ModelMapperBase.toEdoList(modelList)),
        HttpStatus.OK);
  }

}
