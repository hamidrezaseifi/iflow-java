package com.pth.iflow.core.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pth.iflow.common.annotations.IflowGetRequestMapping;
import com.pth.iflow.common.annotations.IflowPostRequestMapping;
import com.pth.iflow.common.controllers.helper.ControllerHelper;
import com.pth.iflow.common.models.edo.CompanyEdo;
import com.pth.iflow.common.models.edo.CompanyWorkflowtypeItemOcrSettingPresetEdo;
import com.pth.iflow.common.models.edo.CompanyWorkflowtypeItemOcrSettingPresetListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.core.model.entity.CompanyEntity;
import com.pth.iflow.core.model.entity.CompanyWorkflowTypeOcrSettingPresetEntity;
import com.pth.iflow.core.service.interfaces.ICompanyService;

@RestController
@RequestMapping
public class CompanyController {

  final ICompanyService companyService;

  public CompanyController(@Autowired final ICompanyService companyService) {

    this.companyService = companyService;
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.COMPANY_READ_BY_IDENTITY)
  public ResponseEntity<CompanyEdo> readCompany(@PathVariable(name = "companyidentity") final String companyidentity,
      final HttpServletRequest request) throws Exception {

    final CompanyEntity company = this.companyService.getByIdentity(companyidentity);

    return ControllerHelper.createResponseEntity(request, this.companyService.toEdo(company), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @IflowPostRequestMapping(path = IflowRestPaths.CoreModule.COMPANY_SAVE)
  @ResponseBody
  public ResponseEntity<CompanyEdo> saveCompany(@RequestBody final CompanyEdo requestCompany, final HttpServletRequest request)
      throws Exception {

    final CompanyEntity savedCompany = this.companyService.save(companyService.fromEdo(requestCompany));

    return ControllerHelper.createResponseEntity(request, this.companyService.toEdo(savedCompany), HttpStatus.CREATED);
  }

  @ResponseStatus(HttpStatus.OK)
  @IflowGetRequestMapping(path = IflowRestPaths.CoreModule.COMPANY_READ_WORKFLOWTYPE_ITEMS_OCR_SETTINGS_BY_IDENTITY)
  public ResponseEntity<CompanyWorkflowtypeItemOcrSettingPresetListEdo>
      readCompanyWorkflowtypeItemOcrSettings(@PathVariable(name = "companyidentity") final String companyidentity,
          final HttpServletRequest request) throws Exception {

    final List<CompanyWorkflowTypeOcrSettingPresetEntity> modelList = this.companyService
        .readCompanyWorkflowtypeItemOcrSettingsByCompanyIdentity(companyidentity);

    final List<CompanyWorkflowtypeItemOcrSettingPresetEdo> edoList = this.companyService
        .toCompanyWorkflowtypeItemOcrSettingPresetEdoList(modelList);

    return ControllerHelper.createResponseEntity(request, new CompanyWorkflowtypeItemOcrSettingPresetListEdo(edoList), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @IflowPostRequestMapping(path = IflowRestPaths.CoreModule.COMPANY_SAVE_WORKFLOWTYPE_ITEMS_OCR_SETTINGS)
  public ResponseEntity<CompanyWorkflowtypeItemOcrSettingPresetEdo>
      saveCompanyWorkflowtypeItemOcrSettings(
          @RequestBody final CompanyWorkflowtypeItemOcrSettingPresetEdo presetEdo,
          final HttpServletRequest request) throws Exception {

    final CompanyWorkflowTypeOcrSettingPresetEntity modelInput = this.companyService
        .fromCompanyWorkflowtypeItemOcrSettingPresetEdo(presetEdo);

    final CompanyWorkflowTypeOcrSettingPresetEntity modelSaved = this.companyService
        .saveCompanyWorkflowtypeItemOcrSetting(modelInput);

    final CompanyWorkflowtypeItemOcrSettingPresetEdo savedEdo = this.companyService
        .toCompanyWorkflowtypeItemOcrSettingPresetEdo(modelSaved);

    return ControllerHelper.createResponseEntity(request, savedEdo, HttpStatus.CREATED);
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @IflowPostRequestMapping(path = IflowRestPaths.CoreModule.COMPANY_DELETE_WORKFLOWTYPE_ITEMS_OCR_SETTINGS)
  public void deleteCompanyWorkflowtypeItemOcrSettings(
      @RequestBody final CompanyWorkflowtypeItemOcrSettingPresetEdo presetEdo,
      final HttpServletRequest request) throws Exception {

    final CompanyWorkflowTypeOcrSettingPresetEntity modelInput = this.companyService
        .fromCompanyWorkflowtypeItemOcrSettingPresetEdo(presetEdo);

    this.companyService.deleteCompanyWorkflowtypeItemOcrSetting(modelInput);

  }

}
