package com.pth.iflow.gui.controller;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pth.iflow.common.annotations.IflowGetRequestMapping;
import com.pth.iflow.common.annotations.IflowPostRequestMapping;
import com.pth.iflow.common.controllers.helper.ControllerHelper;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.models.edo.IdentityListEdo;
import com.pth.iflow.common.models.edo.WorkflowMessageListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.WorkflowMessage;
import com.pth.iflow.gui.models.mapper.GuiModelEdoMapper;
import com.pth.iflow.gui.services.ICompanyCachDataManager;

@RestController
@RequestMapping
public class CachDataController {

  private final ICompanyCachDataManager companyCachDataManager;

  @Autowired
  public CachDataController(final ICompanyCachDataManager companyCachDataManager) {

    this.companyCachDataManager = companyCachDataManager;
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(value = IflowRestPaths.GuiModule.CACHDATA_READ_USER_WORKFLOWMESSAGELIST)
  @ResponseBody
  public ResponseEntity<WorkflowMessageListEdo> readUserWorkflowMessageList(
      @PathVariable(name = "companyidentity") final String companyid, @PathVariable(name = "email") final String userid,
      final HttpServletRequest request)
      throws GuiCustomizedException, URISyntaxException, MalformedURLException, IFlowMessageConversionFailureException {

    final List<WorkflowMessage> list = this.companyCachDataManager.getUserWorkflowMessages(companyid, userid);

    final WorkflowMessageListEdo listEdo = new WorkflowMessageListEdo(GuiModelEdoMapper.toWorkflowMessageEdoList(list));

    return ControllerHelper.createResponseEntity(request, listEdo, HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(value = IflowRestPaths.GuiModule.CACHDATA_CAL_USER_DATARESET_BY_COMPANYIDENTITY)
  @ResponseBody
  public void resetUserData(@PathVariable(name = "companyidentity") final String companyidentity,
      @PathVariable(name = "email") final String userid, final Authentication authentication)
      throws GuiCustomizedException, URISyntaxException, MalformedURLException, IFlowMessageConversionFailureException {

    this.companyCachDataManager.resetUserData(companyidentity, userid, authentication, true);

  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(value = IflowRestPaths.GuiModule.CACHDATA_CAL_WORKFLOW_DATARESET_BY_WORKFLOWIDENTITY)
  @ResponseBody
  public void resetWorkflowrData(@PathVariable(name = "companyidentity") final String companyidentity,
      @PathVariable(name = "identity") final String workflowidentity, final Authentication authentication)
      throws GuiCustomizedException, URISyntaxException, MalformedURLException, IFlowMessageConversionFailureException {

    this.companyCachDataManager.resetWorkflowStepData(companyidentity, workflowidentity, authentication);

  }

  @ResponseStatus(HttpStatus.OK)
  @IflowPostRequestMapping(value = IflowRestPaths.GuiModule.CACHDATA_CAL_USERLIST_DATARESET_BY_COMPANYIDENTITY)
  @ResponseBody
  public void resetUserListData(@PathVariable(name = "companyidentity") final String companyidentity,
      @RequestBody final IdentityListEdo userIdListEdo, final Authentication authentication)
      throws GuiCustomizedException, URISyntaxException, MalformedURLException, IFlowMessageConversionFailureException {

    this.companyCachDataManager.resetUserListData(companyidentity, userIdListEdo.getIdentityList(), authentication);

  }

}
