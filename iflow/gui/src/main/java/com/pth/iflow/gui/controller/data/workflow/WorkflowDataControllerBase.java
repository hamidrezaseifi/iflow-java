package com.pth.iflow.gui.controller.data.workflow;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.pth.iflow.common.enums.EWorkflowIdentity;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.controller.data.GuiDataControllerBase;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.Department;
import com.pth.iflow.gui.models.User;
import com.pth.iflow.gui.models.WorkflowSearchFilter;
import com.pth.iflow.gui.models.WorkflowType;
import com.pth.iflow.gui.models.ui.FileSavingData;
import com.pth.iflow.gui.models.ui.UploadFileSavingData;
import com.pth.iflow.gui.models.workflow.IWorkflow;
import com.pth.iflow.gui.models.workflow.IWorkflowSaveRequest;
import com.pth.iflow.gui.services.IUploadFileManager;
import com.pth.iflow.gui.services.IUserAccess;
import com.pth.iflow.gui.services.IWorkflowHandler;

@Controller
public abstract class WorkflowDataControllerBase<W extends IWorkflow, WS extends IWorkflowSaveRequest<W>>
    extends GuiDataControllerBase {

  @Autowired
  private IWorkflowHandler<W, WS> workflowHandler;

  @Autowired
  private IUserAccess             userAccess;

  @Autowired
  private IUploadFileManager      uploadFileManager;

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/workflowlist/init" })
  @ResponseBody
  public Map<String, Object> loadWorkflowListInitialData()
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final Map<String, Object> map = new HashMap<>();

    final Collection<WorkflowType> workflowTypeList = this.getAllWorkflowTypes();
    final WorkflowSearchFilter workflowSearchFilter = WorkflowSearchFilter.generateNew(workflowTypeList);

    map.put("workflowTypes", workflowTypeList);
    map.put("newSearchFilter", workflowSearchFilter);

    return map;
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/initcreate" })
  @ResponseBody
  public Map<String, Object> loadWorkflowCreateData()
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final Map<String, Object> map = new HashMap<>();

    final List<User> userList = this.userAccess.getCompanyUserList(this.getLoggedCompany().getIdentity());
    final Collection<WorkflowType> workflowTypeList = this.getAllWorkflowTypes();
    final List<Department> departmentList = this.getSessionUserInfo().getCompanyDepartments();

    final W newWorkflow = this.generateInitialWorkflow(this.getLoggedUser().getIdentity());

    final WS workflowReq = this.generateInitialWorkflowSaveRequest(newWorkflow,
        newWorkflow.getHasActiveAction() ? newWorkflow.getActiveAction().getCurrentStep().getExpireDays() : 15);

    map.put("users", userList);
    map.put("departments", departmentList);
    map.put("workflowTypes", workflowTypeList);
    map.put("workflowCreateRequest", workflowReq);

    return map;
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/initedit/{workflowIdentity}" })
  @ResponseBody
  public Map<String, Object> loadWorkflowEditData(@PathVariable final String workflowIdentity)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final Map<String, Object> map = new HashMap<>();

    final List<User> userList = this.userAccess.getCompanyUserList(this.getLoggedCompany().getIdentity());

    final W workflow = this.workflowHandler.readWorkflow(workflowIdentity);

    final List<Department> departmentList = this.getSessionUserInfo().getCompanyDepartments();

    final Integer expireDays = workflow.getHasActiveAction() ? workflow.getActiveAction().getCurrentStep().getExpireDays() : 0;
    final WS saveRequest = this.generateInitialWorkflowSaveRequest(workflow, expireDays);

    map.put("users", userList);
    map.put("workflow", workflow);
    map.put("saveRequest", saveRequest);
    map.put("departments", departmentList);

    return map;
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = { "/create" })
  @ResponseBody
  public List<W> createWorkflow(@RequestBody final WS createRequest, final HttpSession session)
      throws GuiCustomizedException, IOException, IFlowMessageConversionFailureException {

    return this.workflowHandler.createWorkflow(createRequest, session);

  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = { "/createfile" })
  @ResponseBody
  public Map<String, Object> createWorkflowFile(@RequestParam(value = "files") final MultipartFile[] files,
      @RequestParam("titles") final String[] titles, final HttpSession session)
      throws GuiCustomizedException, JsonParseException, JsonMappingException, IOException {

    List<UploadFileSavingData> tempFiles = new ArrayList<>();
    if (files.length > 0) {
      final List<UploadFileSavingData> saveFiles = new ArrayList<>();
      for (int i = 0; i < files.length; i++) {
        final String ext = FileSavingData.getExtention(files[i]);
        String title = titles.length > i ? titles[i] : "";
        if (StringUtils.isEmpty(title)) {
          title = files[i].getOriginalFilename();
          title = ext.isEmpty() == false ? title.substring(0, title.length() - ext.length() - 1) : title;
        }

        saveFiles.add(new UploadFileSavingData(files[i], title, ext, EWorkflowIdentity.NOT_SET.getIdentity(), "no-action",
            this.getLoggedCompany().getIdentity()));
      }

      tempFiles = this.uploadFileManager.saveInTemp(saveFiles);
    }

    final String sessionKey = "temp_uploaded_" + System.currentTimeMillis();

    session.setAttribute(sessionKey, tempFiles);

    final Map<String, Object> results = new HashMap<>();
    results.put("sessionKey", sessionKey);
    results.put("titles", tempFiles.stream().map(uf -> uf.getTitle()).collect(Collectors.toList()));

    return results;

  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = { "/save" })
  @ResponseBody
  public void saveWorkflow(@RequestBody final W workflow, final HttpSession session)
      throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException {

    this.workflowHandler.saveWorkflow(workflow, session);

  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = { "/archive" })
  @ResponseBody
  public void archiveWorkflow(@RequestBody final W workflow, final HttpSession session)
      throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException {

    this.workflowHandler.archiveWorkflow(workflow, session);

  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = { "/done" })
  @ResponseBody
  public void makeDoneWorkflow(@RequestBody final WS saveRequest, final HttpSession session)
      throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException {

    this.workflowHandler.doneWorkflow(saveRequest, session);

  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/assign/{workflowIdentity}" })
  @ResponseBody
  public W assignWorkflow(@PathVariable final String workflowIdentity)
      throws GuiCustomizedException, IFlowMessageConversionFailureException, IOException {

    final W workflow = this.workflowHandler.assignWorkflow(workflowIdentity);

    return workflow;
  }

  protected abstract W generateInitialWorkflow(String userIdentity);

  protected abstract WS generateInitialWorkflowSaveRequest(W workflow, int expireDays);

}
