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
import com.pth.iflow.common.edo.models.IdentityListEdo;
import com.pth.iflow.common.edo.models.WorkflowActionEdo;
import com.pth.iflow.common.edo.models.WorkflowActionListEdo;
import com.pth.iflow.common.edo.models.WorkflowFileEdo;
import com.pth.iflow.common.edo.models.WorkflowFileListEdo;
import com.pth.iflow.common.edo.models.WorkflowSearchFilterEdo;
import com.pth.iflow.common.edo.models.workflow.invoice.InvoiceWorkflowEdo;
import com.pth.iflow.common.edo.models.workflow.invoice.InvoiceWorkflowListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.core.model.mapper.CoreModelEdoMapper;
import com.pth.iflow.core.model.workflow.InvoiceWorkflow;
import com.pth.iflow.core.model.workflow.sub.WorkflowAction;
import com.pth.iflow.core.model.workflow.sub.WorkflowFile;
import com.pth.iflow.core.service.IWorkflowActionService;
import com.pth.iflow.core.service.IWorkflowFileService;
import com.pth.iflow.core.service.IWorkflowService;

@RestController
@RequestMapping
public class InvoiceWorkflowController {

  final IWorkflowService<InvoiceWorkflow> workflowService;
  final IWorkflowActionService            workflowActionService;
  final IWorkflowFileService              workflowFileService;

  public InvoiceWorkflowController(@Autowired final IWorkflowService<InvoiceWorkflow> invoiceWorkflowService,
                                   @Autowired final IWorkflowActionService workflowActionService,
                                   @Autowired final IWorkflowFileService workflowFileService) {
    this.workflowService = invoiceWorkflowService;
    this.workflowActionService = workflowActionService;
    this.workflowFileService = workflowFileService;
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.INVOICEWORKFLOW_READ_BY_IDENTITY)
  public ResponseEntity<InvoiceWorkflowEdo> readWorkflow(@PathVariable(name = "identity") final String identity, final HttpServletRequest request) throws Exception {

    final InvoiceWorkflow model = this.workflowService.getByIdentity(identity);

    return ControllerHelper.createResponseEntity(request, CoreModelEdoMapper.toEdo(model), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @IflowPostRequestMapping(path = IflowRestPaths.CoreModule.INVOICEWORKFLOW_SAVE)
  public ResponseEntity<InvoiceWorkflowEdo> saveWorkflow(@RequestBody final InvoiceWorkflowEdo invoiceWorkflowEdo, final HttpServletRequest request) throws Exception {

    final InvoiceWorkflow model = this.workflowService.save(CoreModelEdoMapper.fromEdo(invoiceWorkflowEdo));
    return ControllerHelper.createResponseEntity(request, CoreModelEdoMapper.toEdo(model), HttpStatus.ACCEPTED);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowPostRequestMapping(path = IflowRestPaths.CoreModule.INVOICEWORKFLOW_READ_LIST)
  public ResponseEntity<InvoiceWorkflowListEdo> readWorkflowList(@RequestBody final IdentityListEdo idList, final HttpServletRequest request) throws Exception {

    final List<InvoiceWorkflow> modelList = this.workflowService.getListByIdentityList(idList.getIdentityList());

    return ControllerHelper.createResponseEntity(request,
                                                 new InvoiceWorkflowListEdo(CoreModelEdoMapper.toInvoiceWorkflowEdoList(modelList)),
                                                 HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.INVOICEWORKFLOW_READ_LIST_BY_USERIDENTITY)
  public ResponseEntity<InvoiceWorkflowListEdo> readWorkflowListForUser(@PathVariable(name = "email") final String email, @PathVariable(required = false) final int status, final HttpServletRequest request) throws Exception {

    final List<InvoiceWorkflow> modelList = this.workflowService.getListForUser(email, status);

    return ControllerHelper.createResponseEntity(request,
                                                 new InvoiceWorkflowListEdo(CoreModelEdoMapper.toInvoiceWorkflowEdoList(modelList)),
                                                 HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.INVOICEWORKFLOW_ACTION_READ_BY_IDENTITY)
  public ResponseEntity<WorkflowActionEdo> readWorkflowAction(@PathVariable(name = "identity") final String identity, final HttpServletRequest request) throws Exception {

    final WorkflowAction model = this.workflowActionService.getByIdentity(identity);

    return ControllerHelper.createResponseEntity(request, CoreModelEdoMapper.toEdo(model), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @IflowPostRequestMapping(path = IflowRestPaths.CoreModule.INVOICEWORKFLOW_ACTION_SAVE)
  public ResponseEntity<WorkflowActionEdo> saveWorkflowAction(@RequestBody final WorkflowActionEdo workflowActionEdo, final HttpServletRequest request) throws Exception {

    final WorkflowAction model = this.workflowActionService.save(CoreModelEdoMapper.fromEdo(workflowActionEdo));

    return ControllerHelper.createResponseEntity(request, CoreModelEdoMapper.toEdo(model), HttpStatus.ACCEPTED);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.INVOICEWORKFLOW_ACTION_READ_LIST_BY_WORKFLOWIDENTITY)
  public ResponseEntity<WorkflowActionListEdo> readWorkflowActionListByWorkflow(@PathVariable(name = "identity") final String identity, final HttpServletRequest request) throws Exception {

    final List<WorkflowAction> modelList = this.workflowActionService.getListByIdWorkflowIdentity(identity);

    return ControllerHelper.createResponseEntity(request,
                                                 new WorkflowActionListEdo(CoreModelEdoMapper.toWorkflowActionEdoList(modelList)),
                                                 HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.INVOICEWORKFLOW_FILE_READ_BY_IDENTITY)
  public ResponseEntity<WorkflowFileEdo> readWorkflowFile(@PathVariable(name = "identity") final String identity, final HttpServletRequest request) throws Exception {

    final WorkflowFile model = this.workflowFileService.getByIdentity(identity);

    return ControllerHelper.createResponseEntity(request, CoreModelEdoMapper.toEdo(model), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @IflowPostRequestMapping(path = IflowRestPaths.CoreModule.INVOICEWORKFLOW_FILE_SAVE)
  public ResponseEntity<WorkflowFileEdo> saveWorkflowFile(@RequestBody final WorkflowFileEdo workflowActionEdo, final HttpServletRequest request) throws Exception {

    final WorkflowFile model = this.workflowFileService.save(CoreModelEdoMapper.fromEdo(workflowActionEdo));

    return ControllerHelper.createResponseEntity(request, CoreModelEdoMapper.toEdo(model), HttpStatus.ACCEPTED);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.INVOICEWORKFLOW_FILE_READ_LIST_BY_WORKFLOWIDENTITY)
  public ResponseEntity<WorkflowFileListEdo> readWorkflowFileListByWorkflow(@PathVariable(name = "identity") final String identity, final HttpServletRequest request) throws Exception {

    final List<WorkflowFile> modelList = this.workflowFileService.getListByIdWorkflowIdentity(identity);

    return ControllerHelper.createResponseEntity(request,
                                                 new WorkflowFileListEdo(CoreModelEdoMapper.toWorkflowFileEdoList(modelList)),
                                                 HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @IflowPostRequestMapping(path = IflowRestPaths.CoreModule.INVOICEWORKFLOW_SEARCH)
  public ResponseEntity<InvoiceWorkflowListEdo> searchWorkflow(@RequestBody final WorkflowSearchFilterEdo workflowSearchFilterEdo, final HttpServletRequest request) throws Exception {

    final List<InvoiceWorkflow> modelList = this.workflowService.search(CoreModelEdoMapper.fromEdo(workflowSearchFilterEdo));

    return ControllerHelper.createResponseEntity(request,
                                                 new InvoiceWorkflowListEdo(CoreModelEdoMapper.toInvoiceWorkflowEdoList(modelList)),
                                                 HttpStatus.ACCEPTED);
  }

}
