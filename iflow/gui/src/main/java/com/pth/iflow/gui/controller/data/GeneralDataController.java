package com.pth.iflow.gui.controller.data;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.controller.GuiLogedControllerBase;
import com.pth.iflow.gui.exceptions.GuiCustomizedException;
import com.pth.iflow.gui.models.UserDashboardMenu;
import com.pth.iflow.gui.models.WorkflowMessage;
import com.pth.iflow.gui.models.ui.FileSavingData;
import com.pth.iflow.gui.models.ui.GuiSocketMessage;
import com.pth.iflow.gui.models.ui.UiMenuItem;
import com.pth.iflow.gui.models.workflow.IWorkflow;
import com.pth.iflow.gui.models.workflow.workflow.Workflow;
import com.pth.iflow.gui.models.workflow.workflow.WorkflowSaveRequest;
import com.pth.iflow.gui.services.IMessagesHelper;
import com.pth.iflow.gui.services.IUploadFileManager;
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

  @Autowired
  protected IUploadFileManager uploadFileManager;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/generaldatat" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public Map<String, Object> loadGeneralData() throws IFlowMessageConversionFailureException {

    final Map<String, Object> map = new HashMap<>();
    map.put("isLogged", "false");

    this.generateGeneralData(map);

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

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = { "/uploadtempfile" })
  @ResponseBody
  public GuiSocketMessage uploadTempFile(@RequestParam(value = "file") final MultipartFile file)
      throws GuiCustomizedException, JsonParseException, JsonMappingException, IOException {

    final GuiSocketMessage results = GuiSocketMessage.generate("processing");

    if (file != null && file.getOriginalFilename().isEmpty() == false) {
      final String tempPath = this.uploadFileManager.saveSingleMultipartInTemp(file);

      final FileSavingData fileSaveData = FileSavingData.generateFromFilePath(tempPath);
      fileSaveData.getFileExtention();

      final File tempFile = new File(tempPath);
      String hocrpPath = tempFile.getParent() + "/" + tempFile.getName() + ".hocr";
      hocrpPath = hocrpPath.replace("\\", "/");

      results.setStatus("done");
      results.setFileName(file.getOriginalFilename());
      results.setFileNotHash(tempPath);
      results.setHocrFileNotHash(hocrpPath);
      results.setIsFileImage(fileSaveData.isFileImage());
      results.setIsFilePdf(fileSaveData.isFilePdf());

    }

    return results;

  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/file/view/{hashfilepath}" })
  public void
      viewUploadedFile(final Model model, @PathVariable(required = true) final String hashfilepath, final HttpServletResponse response)
          throws GuiCustomizedException, IOException, IFlowMessageConversionFailureException {

    final String readFilePath = GuiSocketMessage.decodeHashPath(hashfilepath);
    final String extention = FileSavingData.getExtention(readFilePath);

    final FileSavingData fData = new FileSavingData(extention);

    fData.prepareReposne(readFilePath, response);

  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/file/download/{hashfilepath}" })
  @ResponseBody
  public ResponseEntity<InputStreamResource> downloadUploadedFile(final Model model,
      @PathVariable(required = true) final String hashfilepath, @RequestParam(value = "filename", required = false, defaultValue = "") final String fileName)
      throws GuiCustomizedException, IOException, IFlowMessageConversionFailureException {

    final String readFilePath = GuiSocketMessage.decodeHashPath(hashfilepath);
    final String extention = FileSavingData.getExtention(readFilePath);

    final FileSavingData fData = new FileSavingData(extention);

    final ResponseEntity<InputStreamResource> respEntity = fData.generateFileReposneEntity(readFilePath, fileName);

    return respEntity;
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

  @ResponseStatus(HttpStatus.OK)
  @PostMapping(path = { "/userdashboard/dashboardmenu/update" })
  @ResponseBody
  public Map<String, Object> setUserDashboardMenus(@RequestBody final List<List<UserDashboardMenu>> userDashboardMenus)
      throws GuiCustomizedException, IFlowMessageConversionFailureException, IOException {

    final Map<String, Object> dashboardMap = new HashMap<>();
    dashboardMap.put("totalColumns", this.getSessionUserInfo().getDashboarTotalColumns());
    dashboardMap.put("totalRows", this.getSessionUserInfo().getDashboarTotalRows());
    dashboardMap.put("dashboardMenus", this.getSessionUserInfo().getPreparedUserDashboardMenus(this.getMenus()));

    return dashboardMap;
  }

  private void generateGeneralData(final Map<String, Object> map) throws IFlowMessageConversionFailureException {

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

      final Map<String, Object> dashboardMap = new HashMap<>();
      dashboardMap.put("totalColumns", this.getSessionUserInfo().getDashboarTotalColumns());
      dashboardMap.put("totalRows", this.getSessionUserInfo().getDashboarTotalRows());
      dashboardMap.put("dashboardMenus", this.getSessionUserInfo().getPreparedUserDashboardMenus(this.getMenus()));
      childsMap.put("dashboard", dashboardMap);

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
  }
}
