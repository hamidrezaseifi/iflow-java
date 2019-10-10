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
import com.pth.iflow.common.edo.models.WorkflowTypeEdo;
import com.pth.iflow.common.edo.models.WorkflowTypeListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.core.model.WorkflowType;
import com.pth.iflow.core.model.mapper.CoreModelEdoMapper;
import com.pth.iflow.core.service.IWorkflowTypeService;

@RestController
@RequestMapping
public class WorkflowTypeController {

  final IWorkflowTypeService workflowTypeService;

  public WorkflowTypeController(@Autowired final IWorkflowTypeService workflowTypeService) {
    this.workflowTypeService = workflowTypeService;
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.WORKFLOWTYPE_READ_BY_IDENTITY)
  public ResponseEntity<WorkflowTypeEdo> readWorkflow(@PathVariable(name = "identity") final String identity,
      final HttpServletRequest request) throws Exception {

    final WorkflowType model = this.workflowTypeService.getByIdentity(identity);

    return ControllerHelper.createResponseEntity(request, CoreModelEdoMapper.toEdo(model), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowPostRequestMapping(path = IflowRestPaths.CoreModule.WORKFLOWTYPE_READ_LIST)
  public ResponseEntity<WorkflowTypeListEdo> readWorkflowList(@RequestBody final Set<String> idList, final HttpServletRequest request)
      throws Exception {

    final List<WorkflowType> modelList = this.workflowTypeService.getListByIdentityList(idList);

    return ControllerHelper.createResponseEntity(request, new WorkflowTypeListEdo(CoreModelEdoMapper.toWorkflowTypeEdoList(modelList)),
        HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.WORKFLOWTYPE_READ_LIST_BY_COMPANYIDENTITY)
  public ResponseEntity<WorkflowTypeListEdo> readWorkflowListByCompany(
      @PathVariable(name = "companyidentity") final String companyidentity, final HttpServletRequest request) throws Exception {

    final List<WorkflowType> modelList = this.workflowTypeService.getListByIdCompanyId(companyidentity);

    return ControllerHelper.createResponseEntity(request, new WorkflowTypeListEdo(CoreModelEdoMapper.toWorkflowTypeEdoList(modelList)),
        HttpStatus.OK);
  }

}
