package com.pth.iflow.gui.controller.data;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.pth.iflow.common.enums.EWorkflowIdentity;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.GuiDepartment;
import com.pth.iflow.gui.models.GuiUser;
import com.pth.iflow.gui.models.GuiWorkflow;
import com.pth.iflow.gui.models.GuiWorkflowMessage;
import com.pth.iflow.gui.models.GuiWorkflowSaveRequest;
import com.pth.iflow.gui.models.GuiWorkflowSearchFilter;
import com.pth.iflow.gui.models.GuiWorkflowType;
import com.pth.iflow.gui.models.ui.FileSavingData;
import com.pth.iflow.gui.models.ui.UploadFileSavingData;
import com.pth.iflow.gui.services.IUploadFileManager;
import com.pth.iflow.gui.services.IUserAccess;
import com.pth.iflow.gui.services.IWorkflowHandler;

@Controller
@RequestMapping(value = "/workflow/data")
public class WorkflowDataController extends GuiDataControllerBase {

  @Autowired
  private IWorkflowHandler   workflowHandler;

  @Autowired
  private IUserAccess        userAccess;

  @Autowired
  private IUploadFileManager uploadFileManager;

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/workflowlist/init" })
  @ResponseBody
  public Map<String, Object> loadWorkflowListInitialData()
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final Map<String, Object> map = new HashMap<>();

    final List<GuiWorkflowType> workflowTypeList = this.workflowHandler.readWorkflowTypeList(this.getLoggedCompany().getIdentity());
    final GuiWorkflowSearchFilter workflowSearchFilter = GuiWorkflowSearchFilter.generateNew();

    map.put("workflowTypes", workflowTypeList);
    map.put("newSearchFilter", workflowSearchFilter);

    return map;
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/workflowlist/search" })
  @ResponseBody
  public List<GuiWorkflow> searchWorkflows(@RequestBody final GuiWorkflowSearchFilter workflowSearchFilter)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    if (workflowSearchFilter.isMeAssigned()) {
      workflowSearchFilter.setAssignedUserIdList(Arrays.asList(this.getLoggedUser().getId()));
    }

    final List<GuiWorkflow> workflowList = this.workflowHandler.searchWorkflow(workflowSearchFilter);

    return workflowList;
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/companyusers" })
  @ResponseBody
  public List<GuiUser> listCompanyUsers()
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final List<GuiUser> userList = this.userAccess.getCompanyUserList(this.getLoggedCompany().getIdentity());

    return userList;
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/workflowcreate/init" })
  @ResponseBody
  public Map<String, Object> loadWorkflowCreateData()
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final Map<String, Object> map = new HashMap<>();

    final List<GuiUser> userList = this.userAccess.getCompanyUserList(this.getLoggedCompany().getIdentity());
    final List<GuiWorkflowType> workflowTypeList = this.workflowHandler.readWorkflowTypeList(this.getLoggedCompany().getIdentity());

    final GuiWorkflow newWorkflow = GuiWorkflow.generateInitial(this.getLoggedUser().getId());

    final GuiWorkflowSaveRequest workflowReq = GuiWorkflowSaveRequest.generateNewWihExpireDays(newWorkflow,
        newWorkflow.getHasActiveAction() ? newWorkflow.getActiveAction().getCurrentStep().getExpireDays() : 15);

    map.put("users", userList);
    map.put("workflowTypes", workflowTypeList);
    map.put("workflowCreateRequest", workflowReq);

    return map;
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/workflowcreate/typedata/{typeId}" })
  @ResponseBody
  public Map<String, Object> loadWorkflowTypeInitData(@PathVariable final Long typeId)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final Map<String, Object> map = new HashMap<>();

    final List<GuiUser> userList = this.getSessionUserInfo().getCompanyUserList();
    final List<GuiDepartment> departmentList = this.getSessionUserInfo().getCompanyDepartments();

    map.put("users", userList);
    map.put("departments", departmentList);

    return map;
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/workflow/edit/{workflowIdentity}" })
  @ResponseBody
  public Map<String, Object> loadWorkflowEditData(@PathVariable final String workflowIdentity)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final Map<String, Object> map = new HashMap<>();

    final List<GuiUser> userList = this.userAccess.getCompanyUserList(this.getLoggedCompany().getIdentity());

    final GuiWorkflow workflow = this.workflowHandler.readWorkflow(workflowIdentity);

    final List<GuiDepartment> departmentList = this.getSessionUserInfo().getCompanyDepartments();

    final Integer expireDays = workflow.getHasActiveAction() ? workflow.getActiveAction().getCurrentStep().getExpireDays() : 0;
    final GuiWorkflowSaveRequest saveRequest = GuiWorkflowSaveRequest.generateNewWihExpireDays(workflow, expireDays);

    map.put("users", userList);
    map.put("workflow", workflow);
    map.put("saveRequest", saveRequest);
    map.put("departments", departmentList);

    return map;
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = { "/workflowcreate/create" })
  @ResponseBody
  public List<GuiWorkflow> createWorkflow(@RequestBody final GuiWorkflowSaveRequest createRequest, final HttpSession session)
      throws GuiCustomizedException, IOException, IFlowMessageConversionFailureException {

    return this.workflowHandler.createWorkflow(createRequest, session);

  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = { "/workflowcreate/file" })
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

        saveFiles.add(new UploadFileSavingData(files[i], title, ext, EWorkflowIdentity.NOT_SET.getName(), 0l,
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
  @PostMapping(path = { "/workflow/save" })
  @ResponseBody
  public void saveWorkflow(@RequestBody final GuiWorkflow workflow, final HttpSession session)
      throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException {

    this.workflowHandler.saveWorkflow(workflow, session);

  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = { "/workflow/archive" })
  @ResponseBody
  public void archiveWorkflow(@RequestBody final GuiWorkflow workflow, final HttpSession session)
      throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException {

    this.workflowHandler.archiveWorkflow(workflow, session);

  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = { "/workflow/done" })
  @ResponseBody
  public void makeDoneWorkflow(@RequestBody final GuiWorkflowSaveRequest saveRequest, final HttpSession session)
      throws GuiCustomizedException, MalformedURLException, IOException, IFlowMessageConversionFailureException {

    this.workflowHandler.doneWorkflow(saveRequest, session);

  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/workflowmessages" })
  @ResponseBody
  public List<GuiWorkflowMessage> listWorkflowMessages(final HttpServletRequest request)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final String resetCach = request.getParameter("reset");
    if ("1".equals(resetCach)) {
      this.callUserMessageReset();
    }

    final List<GuiWorkflowMessage> messageList = this.readUserMessages();

    return messageList;
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/assignworkflow/{workflowIdentity}" })
  @ResponseBody
  public GuiWorkflow assignWorkflow(@PathVariable final String workflowIdentity)
      throws GuiCustomizedException, IFlowMessageConversionFailureException, IOException {

    final GuiWorkflow workflow = this.workflowHandler.assignWorkflow(workflowIdentity);

    return workflow;
  }

}
