package com.pth.iflow.gui.controller.data;

import java.net.MalformedURLException;
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
import com.pth.iflow.gui.models.Company;
import com.pth.iflow.gui.models.CompanyWorkflowtypeItemOcrSettingPreset;
import com.pth.iflow.gui.models.CompanyWorkflowtypeItemOcrSettingPresetItem;
import com.pth.iflow.gui.services.ICompanyHandler;

@Controller
@RequestMapping(value = "/company/data")
public class CompanyDataController extends GuiDataControllerBase {

  @Autowired
  private ICompanyHandler companyHandler;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/info" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public Company readCompanyInfo() throws MalformedURLException, IFlowMessageConversionFailureException {

    return this.companyHandler.readCompany(this.getLoggedCompany().getIdentity());
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = { "/update" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public Company saveCompany(@RequestBody final Company requestCompany)
      throws MalformedURLException, IFlowMessageConversionFailureException {

    final Company savedCompany = this.companyHandler.saveCompany(requestCompany);

    return savedCompany;
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/readworkflowtypeitemocrsettings" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public List<CompanyWorkflowtypeItemOcrSettingPreset> readCompanyWorkflowtypeItemOcrSettings()
      throws MalformedURLException, IFlowMessageConversionFailureException {

    return this.companyHandler.readCompanyWorkflowtypeItemOcrSettings(this.getLoggedCompany().getIdentity());
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = { "/saveworkflowtypeitemocrsettings/{workflowtypeidentity}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public List<CompanyWorkflowtypeItemOcrSettingPreset>
      saveCompanyWorkflowtypeItemOcrSettings(@RequestBody final CompanyWorkflowtypeItemOcrSettingPreset preset,
          @PathVariable final String workflowtypeidentity)
          throws MalformedURLException, IFlowMessageConversionFailureException {

    final List<CompanyWorkflowtypeItemOcrSettingPreset> savedList = this.companyHandler
        .saveCompanyWorkflowtypeItemOcrSettings(preset, this.getLoggedCompany().getIdentity());

    return savedList;
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/readworkflowtypeitems/{workflowtypeidentity}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public List<String> readWorkflowtypeItems(@PathVariable final String workflowtypeidentity)
      throws MalformedURLException, IFlowMessageConversionFailureException {

    return this.companyHandler.readWorkflowtypeItems(workflowtypeidentity);
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path = { "/readpresetallitems/{presetName}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public Map<String, CompanyWorkflowtypeItemOcrSettingPresetItem> readPresetAllItems(@PathVariable final String presetName)
      throws MalformedURLException, IFlowMessageConversionFailureException {

    return this.companyHandler.readPresetAllItems(presetName);
  }

}
