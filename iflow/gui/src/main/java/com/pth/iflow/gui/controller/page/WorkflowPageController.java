package com.pth.iflow.gui.controller.page;

import java.io.IOException;
import java.net.MalformedURLException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.pth.iflow.common.enums.EAssignType;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.GuiWorkflow;
import com.pth.iflow.gui.models.GuiWorkflowFile;
import com.pth.iflow.gui.models.ui.FileSavingData;
import com.pth.iflow.gui.services.IUploadFileManager;
import com.pth.iflow.gui.services.IWorkflowHandler;

@Controller
@RequestMapping(value = "/workflow")
public class WorkflowPageController extends GuiPageControllerBase {

  @Autowired
  private IWorkflowHandler workflowHandler;

  @Autowired
  private IUploadFileManager uploadFileManager;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/", "/list" })
  public String showWorkflowList(final Model model) throws GuiCustomizedException, MalformedURLException {

    return "workflow/index";
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/create" })
  public String showWorkflowCreate(final Model model) throws GuiCustomizedException, MalformedURLException {

    model.addAttribute("UserAssign", EAssignType.USER.getName());
    model.addAttribute("DepartmentAssign", EAssignType.DEPARTMENT.getName());
    model.addAttribute("DepartmentGroupAssign", EAssignType.DEPARTMENTGROUP.getName());

    return "workflow/create";
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/edit/{workflowIdentity}" })
  public String showWorkflowEdit(final Model model, @PathVariable(required = false) final String workflowIdentity, final HttpServletResponse response) throws GuiCustomizedException, IOException, IFlowMessageConversionFailureException {

    final GuiWorkflow workflow = this.workflowHandler.readWorkflow(workflowIdentity);

    model.addAttribute("UserAssign", EAssignType.USER.getName());
    model.addAttribute("DepartmentAssign", EAssignType.DEPARTMENT.getName());
    model.addAttribute("DepartmentGroupAssign", EAssignType.DEPARTMENTGROUP.getName());
    model.addAttribute("workflowId", workflowIdentity);

    return workflow.getCurrentStep().getViewName(); // "workflow/edit";
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/file/view/{workflowIdentity}/{fileIdentity}" })
  public void viewWorkflowFile(final Model model, @PathVariable(required = true) final String fileIdentity, @PathVariable(required = true) final String workflowIdentity, final HttpServletResponse response) throws GuiCustomizedException, IOException, IFlowMessageConversionFailureException {

    final GuiWorkflowFile wfile = this.workflowHandler.readWorkflowFile(workflowIdentity, fileIdentity);

    final FileSavingData fData = new FileSavingData(wfile.getTitle(),
                                                    wfile.getExtention(),
                                                    workflowIdentity,
                                                    0L,
                                                    this.getLoggedCompany().getId());
    final String readFilePath = this.uploadFileManager.getFilePath(fData);

    // final ResponseEntity<InputStreamResource> respEntity =
    // fData.generateFileReposneEntity(readFilePath);

    fData.prepareReposne(readFilePath, response);

  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/file/download/{workflowIdentity}/{fileIdentity}" })
  @ResponseBody
  public ResponseEntity<InputStreamResource> downloadWorkflowFile(final Model model, @PathVariable(required = true) final String fileIdentity, @PathVariable(required = true) final String workflowIdentity, final HttpServletResponse response) throws GuiCustomizedException, IOException, IFlowMessageConversionFailureException {

    final GuiWorkflowFile wfile = this.workflowHandler.readWorkflowFile(workflowIdentity, fileIdentity);

    final FileSavingData fData = new FileSavingData(wfile.getTitle(),
                                                    wfile.getExtention(),
                                                    workflowIdentity,
                                                    0L,
                                                    this.getLoggedCompany().getId());
    final String readFilePath = this.uploadFileManager.getFilePath(fData);

    final ResponseEntity<InputStreamResource> respEntity = fData.generateFileReposneEntity(readFilePath);

    return respEntity;
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/invalid-message" })
  public String showInvalidMessage(final Model model) throws GuiCustomizedException, MalformedURLException {

    return "workflow/invalid-message";
  }

}
