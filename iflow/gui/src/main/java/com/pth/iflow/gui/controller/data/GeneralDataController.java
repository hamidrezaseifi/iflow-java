package com.pth.iflow.gui.controller.data;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.controller.GuiLogedControllerBase;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.Department;
import com.pth.iflow.gui.models.User;
import com.pth.iflow.gui.models.WorkflowMessage;
import com.pth.iflow.gui.models.ui.UiMenuItem;
import com.pth.iflow.gui.services.IMessagesHelper;
import com.pth.iflow.gui.services.UiMenuService;

@Controller
@RequestMapping(value = "/general/data")
public class GeneralDataController extends GuiLogedControllerBase {

  @Autowired
  private UiMenuService     menuService;

  @Autowired
  protected IMessagesHelper messagesHelper;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/generaldatat" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public Map<String, Object> loadGeneralData() throws IFlowMessageConversionFailureException {

    final Map<String, Object> map = new HashMap<>();
    map.put("isLogged", "false");
    map.put("currentUser", this.getLoggedUser());
    map.put("users", new ArrayList<>());
    map.put("departments", new ArrayList<>());
    map.put("menus", new ArrayList<>());

    if (this.isSessionValidAndLoggedIn()) {

      final List<User>       userList       = this.getSessionUserInfo().getCompanyUserList();
      final List<Department> departmentList = this.getSessionUserInfo().getCompanyDepartments();

      map.put("isLogged", "true");
      map.put("currentUser", this.getLoggedUser());
      map.put("users", userList);
      map.put("departments", departmentList);
      map.put("menus", this.getMenus());

    }

    return map;
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/workflowmessages" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public List<WorkflowMessage> listWorkflowMessages(final HttpServletRequest request)
      throws GuiCustomizedException, MalformedURLException, IFlowMessageConversionFailureException {

    if (this.isSessionValidAndLoggedIn()) {
      final String resetCach = request.getParameter("reset");
      if ("1".equals(resetCach)) {
        this.callUserMessageReset();
      }

      final List<WorkflowMessage> messageList = this.readUserMessages();

      return messageList;
    }
    return new ArrayList<>();
  }

  protected List<UiMenuItem> getMenus() {
    return this.menuService.getAllMenus();

  }

  private boolean isSessionValidAndLoggedIn() {
    return this.getSessionUserInfo() != null && this.getSessionUserInfo().isValid();
  }
}
