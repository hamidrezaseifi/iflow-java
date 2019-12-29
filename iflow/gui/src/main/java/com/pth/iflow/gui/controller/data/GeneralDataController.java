package com.pth.iflow.gui.controller.data;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.controller.GuiLogedControllerBase;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.WorkflowMessage;
import com.pth.iflow.gui.models.ui.UiMenuItem;
import com.pth.iflow.gui.models.workflow.IWorkflow;
import com.pth.iflow.gui.models.workflow.workflow.Workflow;
import com.pth.iflow.gui.models.workflow.workflow.WorkflowSaveRequest;
import com.pth.iflow.gui.services.IMessagesHelper;
import com.pth.iflow.gui.services.IWorkflowHandler;
import com.pth.iflow.gui.services.UiMenuService;
import com.pth.iflow.gui.services.impl.workflow.WorkflowHandlerSelect;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

@Controller
@RequestMapping(value = "/general/data")
public class GeneralDataController extends GuiLogedControllerBase {

  @Autowired
  private UiMenuService menuService;

  @Autowired
  protected IMessagesHelper messagesHelper;

  @Autowired
  private IWorkflowHandler<Workflow, WorkflowSaveRequest> workflowHandlerBase;

  @Autowired
  WorkflowHandlerSelect workflowHandlerSelect;

  @Autowired
  SimpMessagingTemplate simpMessagingTemplate;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/generaldatat" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public Map<String, Object> loadGeneralData() throws IFlowMessageConversionFailureException {

    final Map<String, Object> map = new HashMap<>();
    map.put("isLogged", "false");

    if (this.isSessionValidAndLoggedIn()) {

      Map<String, Object> childsMap = new HashMap<>();
      childsMap.put("company", this.getSessionUserInfo().getCompany());
      childsMap.put("departments", this.getSessionUserInfo().getCompanyDepartments());
      childsMap.put("users", this.getSessionUserInfo().getCompanyUserList());
      map.put("company", childsMap);

      childsMap = new HashMap<>();
      childsMap.put("worlflowTypes", this.getSessionUserInfo().getAllWorkflowTypes());
      map.put("workflow", childsMap);

      childsMap = new HashMap<>();
      childsMap.put("currentUser", this.getLoggedUser());
      map.put("user", childsMap);

      childsMap = new HashMap<>();
      childsMap.put("menus", this.getMenus());
      map.put("app", childsMap);

      map.put("isLogged", "true");

    }
    else {
      Map<String, Object> childsMap = new HashMap<>();
      childsMap.put("company", null);
      childsMap.put("departments", new ArrayList<>());
      childsMap.put("users", new ArrayList<>());
      map.put("company", childsMap);

      childsMap = new HashMap<>();
      childsMap.put("worlflowTypes", new ArrayList<>());
      map.put("workflow", childsMap);

      childsMap = new HashMap<>();
      childsMap.put("currentUser", null);
      map.put("user", childsMap);

      childsMap = new HashMap<>();
      childsMap.put("menus", new ArrayList<>());
      map.put("app", childsMap);

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

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/workflow/assign/{workflowIdentity}" })
  @ResponseBody
  public IWorkflow assignWorkflow(@PathVariable final String workflowIdentity)
      throws GuiCustomizedException, IFlowMessageConversionFailureException, IOException {

    if (this.isSessionValidAndLoggedIn()) {
      final Workflow workflow = this.workflowHandlerBase.readWorkflow(workflowIdentity);

      final IWorkflowHandler handler = this.workflowHandlerSelect.getHandlerByType(workflow.getWorkflowTypeEnum());

      final IWorkflow assignedWorkflow = handler.assignWorkflow(workflowIdentity);

      return workflow;
    }
    throw new GuiCustomizedException("not loggeg in!");
  }

  @GetMapping(path = { "/testsocket/{data}" })
  @ResponseBody
  public String testSentSocket(@PathVariable final String data) throws Exception {

    Thread.sleep(100);

    final Map<String, Object> map = new HashMap<>();
    map.put("sentMessage", data);
    map.put("status", "received-from-test");

    this.simpMessagingTemplate.convertAndSend("/socket/test", map);

    return data;
  }

  private boolean isSessionValidAndLoggedIn() {

    return this.getSessionUserInfo() != null && this.getSessionUserInfo().isValid();
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/testocr" })
  @ResponseBody
  public String testOcr() throws IllegalStateException, IOException, TesseractException {

    // System.setProperty("jna.library.path", "C:\\Git\\home\\iflow\\iflow-java\\iflow\\gui\\src\\main\\resources\\tess4dlls");

    System.out.println(System.getProperty("jna.library.path"));
    final File file = new File("E:\\TestRechnung\\2_ohne OCR.pdf");
    final Tesseract tesseract = new Tesseract();
    tesseract.setDatapath("F://Softwares//Tess4J//tessdata");
    tesseract.setLanguage("deu");
    tesseract.setHocr(true);
    final String res = tesseract.doOCR(file);

    return res;
  }

}
