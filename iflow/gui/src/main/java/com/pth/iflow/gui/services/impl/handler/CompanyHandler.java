package com.pth.iflow.gui.services.impl.handler;

import java.net.MalformedURLException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.models.Company;
import com.pth.iflow.gui.models.CompanyWorkflowtypeItemOcrSetting;
import com.pth.iflow.gui.services.ICompanyAccess;
import com.pth.iflow.gui.services.ICompanyHandler;

@Service
public class CompanyHandler implements ICompanyHandler {

  private final ICompanyAccess companyAccess;

  public CompanyHandler(@Autowired final ICompanyAccess companyAccess) {

    this.companyAccess = companyAccess;

  }

  @Override
  public Company readCompany(final String identity) throws MalformedURLException, IFlowMessageConversionFailureException {

    return this.companyAccess.readCompany(identity);
  }

  @Override
  public Company saveCompany(final Company company) throws MalformedURLException, IFlowMessageConversionFailureException {

    return this.companyAccess.saveCompany(company);
  }

  @Override
  public List<CompanyWorkflowtypeItemOcrSetting> readCompanyWorkflowtypeItemOcrSettings(final String identity)
      throws MalformedURLException, IFlowMessageConversionFailureException {

    return this.companyAccess.readCompanyWorkflowtypeItemOcrSettings(identity);
  }

  @Override
  public List<CompanyWorkflowtypeItemOcrSetting> saveCompanyWorkflowtypeItemOcrSettings(
      final List<CompanyWorkflowtypeItemOcrSetting> settingList,
      final String companyidentity, final String workflowtypeidentity)
      throws MalformedURLException, IFlowMessageConversionFailureException {

    final List<CompanyWorkflowtypeItemOcrSetting> readList = this.companyAccess.readCompanyWorkflowtypeItemOcrSettings(companyidentity);

    final List<CompanyWorkflowtypeItemOcrSetting> newList = readList
        .stream()
        .filter(item -> item.getWorkflowIdentity().equals(workflowtypeidentity) == false)
        .collect(Collectors.toList());

    newList.addAll(settingList);

    return this.companyAccess.saveCompanyWorkflowtypeItemOcrSettings(newList);

  }

}
