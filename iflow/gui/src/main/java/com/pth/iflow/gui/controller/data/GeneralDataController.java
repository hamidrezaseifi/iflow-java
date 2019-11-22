package com.pth.iflow.gui.controller.data;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.controller.page.GuiPageControllerBase;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.Department;
import com.pth.iflow.gui.models.User;
import com.pth.iflow.gui.models.WorkflowMessage;

@Controller
@RequestMapping(value = "/general/data")
public class GeneralDataController extends GuiPageControllerBase {

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/generaldatat" })
  @ResponseBody
  public Map<String, Object> loadWorkflowTypeInitData(@PathVariable final String typeIdentity)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final Map<String, Object> map = new HashMap<>();

    final List<User> userList = this.getSessionUserInfo().getCompanyUserList();
    final List<Department> departmentList = this.getSessionUserInfo().getCompanyDepartments();

    map.put("users", userList);
    map.put("departments", departmentList);

    return map;
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/workflowmessages" })
  @ResponseBody
  public List<WorkflowMessage> listWorkflowMessages(final HttpServletRequest request)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    final String resetCach = request.getParameter("reset");
    if ("1".equals(resetCach)) {
      this.callUserMessageReset();
    }

    final List<WorkflowMessage> messageList = this.readUserMessages();

    return messageList;
  }

}
