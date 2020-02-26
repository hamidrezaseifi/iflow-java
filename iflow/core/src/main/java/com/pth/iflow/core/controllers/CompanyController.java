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
import com.pth.iflow.common.models.edo.CompanyWorkflowtypeItemOcrSettingPresetItemEdo;
import com.pth.iflow.common.models.edo.CompanyWorkflowtypeItemOcrSettingPresetListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.core.model.entity.CompanyEntity;
import com.pth.iflow.core.model.entity.CompanyWorkflowtypeItemOcrSettingPresetItemEntity;
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

    final List<CompanyWorkflowtypeItemOcrSettingPresetItemEntity> modelList = this.companyService
        .readCompanyWorkflowtypeItemOcrSettingsByCompanyIdentity(companyidentity);

    final List<CompanyWorkflowtypeItemOcrSettingPresetItemEdo> edoList = this.companyService.toCompanyWorkflowtypeItemOcrSettingEdoList(modelList);

    return ControllerHelper.createResponseEntity(request, new CompanyWorkflowtypeItemOcrSettingPresetListEdo(edoList), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @IflowPostRequestMapping(path = IflowRestPaths.CoreModule.COMPANY_SAVE_WORKFLOWTYPE_ITEMS_OCR_SETTINGS)
  public ResponseEntity<CompanyWorkflowtypeItemOcrSettingPresetListEdo>
      saveCompanyWorkflowtypeItemOcrSettings(@RequestBody final CompanyWorkflowtypeItemOcrSettingPresetListEdo workflowtypeItemOcrSettingListEdo,
          final HttpServletRequest request) throws Exception {

    final List<CompanyWorkflowtypeItemOcrSettingPresetItemEntity> modelInputList = this.companyService
        .fromCompanyWorkflowtypeItemOcrSettingEdoList(workflowtypeItemOcrSettingListEdo.getCompanyWorkflowtypeItemOcrSettings());

    final List<CompanyWorkflowtypeItemOcrSettingPresetItemEntity> modelList = this.companyService
        .saveCompanyWorkflowtypeItemOcrSettings(modelInputList);

    final List<CompanyWorkflowtypeItemOcrSettingPresetItemEdo> edoList = this.companyService.toCompanyWorkflowtypeItemOcrSettingEdoList(modelList);

    return ControllerHelper.createResponseEntity(request, new CompanyWorkflowtypeItemOcrSettingPresetListEdo(edoList), HttpStatus.CREATED);
  }

}
