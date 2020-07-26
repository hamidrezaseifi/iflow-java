package com.pth.iflow.profile.controller;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.pth.iflow.common.models.edo.CompanyEdo;
import com.pth.iflow.common.models.edo.CompanyProfileEdo;
import com.pth.iflow.common.models.edo.CompanyWorkflowtypeItemOcrSettingPresetEdo;
import com.pth.iflow.common.models.edo.CompanyWorkflowtypeItemOcrSettingPresetListEdo;
import com.pth.iflow.common.models.edo.DepartmentListEdo;
import com.pth.iflow.common.models.edo.UserGroupListEdo;
import com.pth.iflow.common.models.edo.UserListEdo;
import com.pth.iflow.common.moduls.security.RestAccessRoles;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.profile.exceptions.ProfileCustomizedException;
import com.pth.iflow.profile.model.Company;
import com.pth.iflow.profile.model.CompanyWorkflowtypeItemOcrSettingPreset;
import com.pth.iflow.profile.model.Department;
import com.pth.iflow.profile.model.ProfileResponse;
import com.pth.iflow.profile.model.User;
import com.pth.iflow.profile.model.UserGroup;
import com.pth.iflow.profile.model.mapper.ProfileModelEdoMapper;
import com.pth.iflow.profile.service.handler.ICompaniesHandlerService;
import com.pth.iflow.profile.service.handler.ITokenUserDataManager;

@RestController
@RequestMapping
public class CompanyController {

  private final ITokenUserDataManager tokenUserDataManager;

  private final ICompaniesHandlerService companiesHandlerService;

  public CompanyController(@Autowired final ITokenUserDataManager tokenUserDataManager,
      @Autowired final ICompaniesHandlerService companiesHandlerService) {

    this.tokenUserDataManager = tokenUserDataManager;
    this.companiesHandlerService = companiesHandlerService;
  }

  @ResponseStatus(HttpStatus.OK)
  @PreAuthorize(RestAccessRoles.General.HAS_ROLE_USER)
  @IflowGetRequestMapping(value = IflowRestPaths.ProfileModule.COMPANY_READ_BY_IDENTITY)
  @ResponseBody
  public ResponseEntity<CompanyEdo> readById(@PathVariable(name = "companyidentity") final String companyidentity,
      final HttpServletRequest request,
      final Authentication authentication)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException, IFlowMessageConversionFailureException {

    final Company company = this.companiesHandlerService.getCompanyByIdentity(companyidentity);

    return ControllerHelper.createResponseEntity(request, ProfileModelEdoMapper.toEdo(company), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PreAuthorize(RestAccessRoles.Companies.COMPANIES_SAVE)
  @IflowPostRequestMapping(value = IflowRestPaths.ProfileModule.COMPANY_SAVE)
  @ResponseBody
  public ResponseEntity<CompanyEdo> saveCompany(@RequestBody final CompanyEdo companyEdo,
      final HttpServletRequest request,
      final Authentication authentication)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException, IFlowMessageConversionFailureException {

    final Company savedComapny = this.companiesHandlerService.saveCompany(ProfileModelEdoMapper.fromEdo(companyEdo));

    return ControllerHelper.createResponseEntity(request, ProfileModelEdoMapper.toEdo(savedComapny), HttpStatus.CREATED);
  }

  @ResponseStatus(HttpStatus.OK)
  @PreAuthorize(RestAccessRoles.General.HAS_ROLE_USER)
  @IflowGetRequestMapping(value = IflowRestPaths.ProfileModule.COMPANY_READ_USER_LIST)
  @ResponseBody
  public ResponseEntity<UserListEdo> readUserList(@PathVariable(name = "companyidentity") final String companyidentity,
      final HttpServletRequest request,
      final Authentication authentication)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException, IFlowMessageConversionFailureException {

    final List<User> list = this.tokenUserDataManager.getUserListByToken(authentication, companyidentity);

    final UserListEdo edo = new UserListEdo(ProfileModelEdoMapper.toUserEdoList(list));

    return ControllerHelper.createResponseEntity(request, edo, HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @PreAuthorize(RestAccessRoles.General.HAS_ROLE_USER)
  @IflowGetRequestMapping(value = IflowRestPaths.ProfileModule.COMPANY_READ_USERGROUP_LIST)
  @ResponseBody
  public ResponseEntity<UserGroupListEdo> readUserGroupList(@PathVariable(name = "companyidentity") final String companyidentity,
      final HttpServletRequest request,
      final Authentication authentication)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException, IFlowMessageConversionFailureException {

    final List<UserGroup> list = this.tokenUserDataManager.getUserGroupListByToken(authentication, companyidentity);

    final UserGroupListEdo edo = new UserGroupListEdo(ProfileModelEdoMapper.toUserGroupEdoList(list));

    return ControllerHelper.createResponseEntity(request, edo, HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @PreAuthorize(RestAccessRoles.General.HAS_ROLE_USER)
  @IflowGetRequestMapping(value = IflowRestPaths.ProfileModule.COMPANY_READ_DEPARTMENT_LIST)
  @ResponseBody
  public ResponseEntity<DepartmentListEdo> readDepartmentList(@PathVariable(name = "companyidentity") final String companyidentity,
      final HttpServletRequest request,
      final Authentication authentication)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException, IFlowMessageConversionFailureException {

    final List<Department> list = this.tokenUserDataManager.getDepartmentListByToken(authentication, companyidentity);

    final DepartmentListEdo edo = new DepartmentListEdo(ProfileModelEdoMapper.toDepartmentEdoList(list));

    return ControllerHelper.createResponseEntity(request, edo, HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @PreAuthorize(RestAccessRoles.General.HAS_ROLE_USER)
  @IflowGetRequestMapping(value = IflowRestPaths.ProfileModule.COMPANY_READ_PROFILE)
  @ResponseBody
  public ResponseEntity<CompanyProfileEdo> readProfile(@PathVariable(name = "appIdentity") final String appIdentity,
      @PathVariable(name = "companyidentity") final String companyidentity,
      final HttpServletRequest request,
      final Authentication authentication)
      throws ProfileCustomizedException, URISyntaxException, MalformedURLException, IFlowMessageConversionFailureException {

    final ProfileResponse profile = this.tokenUserDataManager.getProfileByToken(appIdentity, authentication);

    return ControllerHelper.createResponseEntity(request, ProfileModelEdoMapper.toEdo(profile.getCompanyProfile()), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.OK)
  @PreAuthorize(RestAccessRoles.General.HAS_ROLE_USER)
  @IflowGetRequestMapping(path = IflowRestPaths.ProfileModule.COMPANY_READ_WORKFLOWTYPE_ITEMS_OCR_SETTINGS_BY_IDENTITY)
  public ResponseEntity<CompanyWorkflowtypeItemOcrSettingPresetListEdo>
      readCompanyWorkflowtypeItemOcrSettings(@PathVariable(name = "companyidentity") final String companyidentity,
          final HttpServletRequest request,
          final Authentication authentication) throws Exception {

    final List<CompanyWorkflowtypeItemOcrSettingPreset> modelList = this.companiesHandlerService
        .readCompanyWorkflowtypeItemOcrSettingsByCompanyIdentity(companyidentity);

    final List<
        CompanyWorkflowtypeItemOcrSettingPresetEdo> edoList = ProfileModelEdoMapper
            .toCompanyWorkflowtypeItemOcrSettingPresetEdoList(modelList);

    return ControllerHelper.createResponseEntity(request, new CompanyWorkflowtypeItemOcrSettingPresetListEdo(edoList), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PreAuthorize(RestAccessRoles.Companies.COMPANIES_UPDATE)
  @IflowPostRequestMapping(path = IflowRestPaths.ProfileModule.COMPANY_SAVE_WORKFLOWTYPE_ITEMS_OCR_SETTINGS)
  public ResponseEntity<CompanyWorkflowtypeItemOcrSettingPresetEdo>
      saveCompanyWorkflowtypeItemOcrSettings(
          @RequestBody final CompanyWorkflowtypeItemOcrSettingPresetEdo ocrSettingEdo,
          final HttpServletRequest request,
          final Authentication authentication) throws Exception {

    final CompanyWorkflowtypeItemOcrSettingPreset modelInput = ProfileModelEdoMapper
        .fromCompanyWorkflowtypeItemOcrSettingPresetEdo(ocrSettingEdo);

    final CompanyWorkflowtypeItemOcrSettingPreset resultModel = this.companiesHandlerService
        .saveCompanyWorkflowtypeItemOcrSettings(modelInput);

    final CompanyWorkflowtypeItemOcrSettingPresetEdo edo = ProfileModelEdoMapper
        .toCompanyWorkflowtypeItemOcrSettingPresetEdo(resultModel);

    return ControllerHelper.createResponseEntity(request, edo, HttpStatus.CREATED);
  }

  @ResponseStatus(HttpStatus.ACCEPTED)
  @PreAuthorize(RestAccessRoles.Companies.COMPANIES_UPDATE)
  @IflowPostRequestMapping(path = IflowRestPaths.ProfileModule.COMPANY_DELETE_WORKFLOWTYPE_ITEMS_OCR_SETTINGS)
  public void deleteCompanyWorkflowtypeItemOcrSettings(
      @RequestBody final CompanyWorkflowtypeItemOcrSettingPresetEdo ocrSettingEdo,
      final HttpServletRequest request,
      final Authentication authentication) throws Exception {

    final CompanyWorkflowtypeItemOcrSettingPreset modelInput = ProfileModelEdoMapper
        .fromCompanyWorkflowtypeItemOcrSettingPresetEdo(ocrSettingEdo);

    this.companiesHandlerService.deleteCompanyWorkflowtypeItemOcrSettings(modelInput);

  }

}
