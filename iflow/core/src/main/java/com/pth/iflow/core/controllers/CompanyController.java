package com.pth.iflow.core.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pth.iflow.common.annotations.IflowGetRequestMapping;
import com.pth.iflow.common.controllers.helper.ControllerHelper;
import com.pth.iflow.common.models.CompanyEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.core.model.entity.CompanyEntity;
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

}
