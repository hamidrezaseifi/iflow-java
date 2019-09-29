package com.pth.iflow.profile.controller;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.pth.iflow.common.annotations.IflowGetRequestMapping;
import com.pth.iflow.common.annotations.IflowPostRequestMapping;
import com.pth.iflow.common.controllers.helper.ControllerHelper;
import com.pth.iflow.common.edo.models.IdLongListEdo;
import com.pth.iflow.common.edo.models.WorkflowMessageListEdo;
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.TokenVerficationHandlerInterceptor;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.WorkflowMessage;
import com.pth.iflow.profile.model.mapper.ProfileModelEdoMapper;
import com.pth.iflow.profile.service.ICompanyCachDataManager;
import com.pth.iflow.profile.service.ITokenUserDataManager;

@RestController
@RequestMapping
public class CachDataController {

  private final ICompanyCachDataManager companyCachDataManager;

  private final ITokenUserDataManager tokenUserDataManager;

  @Autowired
  public CachDataController(final ICompanyCachDataManager companyCachDataManager, final ITokenUserDataManager tokenUserDataManager) {

    this.companyCachDataManager = companyCachDataManager;
    this.tokenUserDataManager = tokenUserDataManager;
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(value = IflowRestPaths.ProfileModule.CACHDATA_READ_USER_WORKFLOWMESSAGELIST)
  @ResponseBody
  public ResponseEntity<WorkflowMessageListEdo> readUserWorkflowMessageList(@PathVariable(name = "companyid") final Long companyid, @PathVariable(name = "userid") final Long userid, final HttpServletRequest request, @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId) throws ProfileCustomizedException, URISyntaxException, MalformedURLException, IFlowMessageConversionFailureException {

    this.tokenUserDataManager.validateToken(headerTokenId);

    final List<WorkflowMessage> list = this.companyCachDataManager.getUserWorkflowMessages(companyid, userid);

    final WorkflowMessageListEdo listEdo = new WorkflowMessageListEdo(ProfileModelEdoMapper.toWorkflowMessageEdoList(list));

    return ControllerHelper.createResponseEntity(request, listEdo, HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowPostRequestMapping(value = IflowRestPaths.ProfileModule.CACHDATA_ADD_USER_WORKFLOWMESSAGELIST)
  public void addUserWorkflowMessageList(@PathVariable(name = "companyid") final Long companyid, @PathVariable(name = "userid") final Long userid, @RequestBody final WorkflowMessageListEdo edoMessageList, final HttpServletRequest request, @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId) throws ProfileCustomizedException, URISyntaxException, MalformedURLException, IFlowMessageConversionFailureException {

    this.tokenUserDataManager.validateToken(headerTokenId);

    final List<WorkflowMessage> messageList = ProfileModelEdoMapper.fromWorkflowMessageEdoList(edoMessageList.getWorkflowMessages());

    this.companyCachDataManager.addWorkflowMessageList(companyid, userid, messageList);

  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(value = IflowRestPaths.ProfileModule.CACHDATA_CAL_USER_DATARESET)
  @ResponseBody
  public void resetUserData(@PathVariable(name = "companyid") final Long companyid, @PathVariable(name = "userid") final Long userid, final HttpServletRequest request, @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId) throws ProfileCustomizedException, URISyntaxException, MalformedURLException, IFlowMessageConversionFailureException {

    this.tokenUserDataManager.validateToken(headerTokenId);

    this.companyCachDataManager.resetUserData(companyid, userid);

  }

  @ResponseStatus(HttpStatus.OK)
  @IflowPostRequestMapping(value = IflowRestPaths.ProfileModule.CACHDATA_CAL_USERLIST_DATARESET)
  @ResponseBody
  public void resetUserListData(@PathVariable(name = "companyid") final Long companyid, @RequestBody final IdLongListEdo userIdListEdo, final HttpServletRequest request, @RequestHeader(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY) final String headerTokenId) throws ProfileCustomizedException, URISyntaxException, MalformedURLException, IFlowMessageConversionFailureException {

    this.tokenUserDataManager.validateToken(headerTokenId);

    this.companyCachDataManager.resetUserListData(companyid, userIdListEdo.getIdList());

  }

}
