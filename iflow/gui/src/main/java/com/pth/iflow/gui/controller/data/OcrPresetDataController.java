package com.pth.iflow.gui.controller.data;

import java.net.MalformedURLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.models.CompanyWorkflowtypeItemOcrSettingPreset;
import com.pth.iflow.gui.models.CompanyWorkflowtypeItemOcrSettingPresetItem;
import com.pth.iflow.gui.models.WorkflowType;
import com.pth.iflow.gui.services.ICompanyHandler;

@Controller
@RequestMapping(value = "/ocrpreset/data")
public class OcrPresetDataController extends GuiDataControllerBase {

  @Autowired
  private ICompanyHandler companyHandler;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/initpage" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public Map<String, Object> readCompanyInfo() throws MalformedURLException, IFlowMessageConversionFailureException {

    final Map<String, Object> map = new HashMap<>();

    final Collection<WorkflowType> workflowTypes = this.getSessionUserInfo().getAllWorkflowTypes();
    map.put("worlflowTypes", workflowTypes);
    final Map<String, List<String>> workflowTypeItems = new HashMap<>();
    for (final WorkflowType type : workflowTypes) {
      workflowTypeItems.put(type.getIdentity(), this.companyHandler.readWorkflowtypeItems(type.getIdentity()));
    }
    map.put("worlflowTypeItems", workflowTypeItems);

    return map;
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/list" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public List<CompanyWorkflowtypeItemOcrSettingPreset> readCompanyWorkflowtypeItemOcrSettings()
      throws MalformedURLException, IFlowMessageConversionFailureException {

    return this.companyHandler.readCompanyWorkflowtypeItemOcrSettings(this.getLoggedCompany().getIdentity(), this.getLoggedToken());
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = { "/save" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public List<CompanyWorkflowtypeItemOcrSettingPreset>
      saveCompanyWorkflowtypeItemOcrSettings(@RequestBody final CompanyWorkflowtypeItemOcrSettingPreset preset)
          throws MalformedURLException, IFlowMessageConversionFailureException {

    preset.setCompanyIdentity(this.getLoggedCompany().getIdentity());

    this.companyHandler.saveCompanyWorkflowtypeItemOcrSetting(preset, this.getLoggedToken());

    return this.readCompanyWorkflowtypeItemOcrSettings();
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @PostMapping(path = { "/delete" })
  @ResponseBody
  public List<CompanyWorkflowtypeItemOcrSettingPreset>
      deleteCompanyWorkflowtypeItemOcrSettings(@RequestBody final CompanyWorkflowtypeItemOcrSettingPreset preset)
          throws MalformedURLException, IFlowMessageConversionFailureException {

    preset.setCompanyIdentity(this.getLoggedCompany().getIdentity());

    this.companyHandler.deleteCompanyWorkflowtypeItemOcrSetting(preset, this.getLoggedToken());

    return this.readCompanyWorkflowtypeItemOcrSettings();
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/read/{presetName}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public Map<String, CompanyWorkflowtypeItemOcrSettingPresetItem> readPresetAllItems(@PathVariable final String presetName)
      throws MalformedURLException, IFlowMessageConversionFailureException {

    return this.companyHandler.readPresetAllItemsFromSession(presetName);
  }

}
