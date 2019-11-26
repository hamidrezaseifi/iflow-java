package com.pth.iflow.gui.controller.page.workflow;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pth.iflow.common.enums.EAssignType;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.controller.page.GuiPageControllerBase;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.WorkflowFile;
import com.pth.iflow.gui.models.ui.FileSavingData;
import com.pth.iflow.gui.models.workflow.IWorkflow;
import com.pth.iflow.gui.models.workflow.IWorkflowSaveRequest;
import com.pth.iflow.gui.services.IUploadFileManager;
import com.pth.iflow.gui.services.IWorkflowHandler;

public abstract class WorkflowPageControllerBase<W extends IWorkflow, WS extends IWorkflowSaveRequest<W>>
    extends GuiPageControllerBase {

  @Autowired
  protected IWorkflowHandler<W, WS> workflowHandler;

  @Autowired
  protected IUploadFileManager      uploadFileManager;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/create" })
  protected String showCreateWorkflow(final Model model, @PathVariable(required = false) final String workflowTypeIdentity)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    model.addAttribute("UserAssign", EAssignType.USER.getIdentity());
    model.addAttribute("DepartmentAssign", EAssignType.DEPARTMENT.getIdentity());
    model.addAttribute("DepartmentGroupAssign", EAssignType.DEPARTMENTGROUP.getIdentity());

    return this.getCreateView();

  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/edit/{workflowIdentity}/{workflowTypeIdentity}/{workflowTypeStepIdentity}" })
  public String showWorkflowEdit(final Model model, @PathVariable(required = false) final String workflowIdentity,
      @PathVariable(required = false) final String workflowTypeIdentity,
      @PathVariable(required = false) final String workflowTypeStepIdentity, final HttpServletResponse response)
      throws GuiCustomizedException, IOException, IFlowMessageConversionFailureException {

    // final W workflow = this.workflowHandler.readWorkflow(workflowIdentity);

    model.addAttribute("UserAssign", EAssignType.USER.getIdentity());
    model.addAttribute("DepartmentAssign", EAssignType.DEPARTMENT.getIdentity());
    model.addAttribute("DepartmentGroupAssign", EAssignType.DEPARTMENTGROUP.getIdentity());
    model.addAttribute("workflowIdentity", workflowIdentity);

    return this.getWorkflowStepTypeByIdentity(workflowTypeIdentity, workflowTypeStepIdentity).getViewName();

  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/file/view/{workflowIdentity}/{fileIdentity}" })
  public void viewWorkflowFile(final Model model, @PathVariable(required = true) final String fileIdentity,
      @PathVariable(required = true) final String workflowIdentity, final HttpServletResponse response)
      throws GuiCustomizedException, IOException, IFlowMessageConversionFailureException {

    final WorkflowFile wfile = this.workflowHandler.readWorkflowFile(workflowIdentity, fileIdentity);

    final FileSavingData fData = new FileSavingData(wfile.getTitle(), wfile.getExtention(), workflowIdentity, "no-asction",
        this.getLoggedCompany().getIdentity());
    final String readFilePath = this.uploadFileManager.getFilePath(fData);

    fData.prepareReposne(readFilePath, response);

  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/file/download/{workflowIdentity}/{fileIdentity}" })
  @ResponseBody
  public ResponseEntity<InputStreamResource> downloadWorkflowFile(final Model model,
      @PathVariable(required = true) final String fileIdentity, @PathVariable(required = true) final String workflowIdentity,
      final HttpServletResponse response) throws GuiCustomizedException, IOException, IFlowMessageConversionFailureException {

    final WorkflowFile wfile = this.workflowHandler.readWorkflowFile(workflowIdentity, fileIdentity);

    final FileSavingData fData = new FileSavingData(wfile.getTitle(), wfile.getExtention(), workflowIdentity, "no-asction",
        this.getLoggedCompany().getIdentity());
    final String readFilePath = this.uploadFileManager.getFilePath(fData);

    final ResponseEntity<InputStreamResource> respEntity = fData.generateFileReposneEntity(readFilePath);

    return respEntity;

  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/invalid-message" })
  public String showInvalidMessage(final Model model) throws GuiCustomizedException, MalformedURLException {

    return "workflow/invalid-message";
  }

  protected abstract String getCreateView();

}
