package com.pth.iflow.gui.services.impl.access;

import java.net.MalformedURLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.configurations.GuiConfiguration;
import com.pth.iflow.gui.models.Department;
import com.pth.iflow.gui.models.ui.SessionUserInfo;
import com.pth.iflow.gui.services.IDepartmentAccess;
import com.pth.iflow.gui.services.IRestTemplateCall;

@Service
public class DepartmentAccess implements IDepartmentAccess {

  private static final Logger logger = LoggerFactory.getLogger(UserAccess.class);

  private final IRestTemplateCall restTemplate;
  private final GuiConfiguration.ProfileModuleAccessConfig profileModuleAccessConfig;

  private final SessionUserInfo sessionUserInfo;

  public DepartmentAccess(@Autowired final IRestTemplateCall restTemplate,
      @Autowired final GuiConfiguration.ProfileModuleAccessConfig profileModuleAccessConfig,
      @Autowired final SessionUserInfo sessionUserInfo) {

    this.restTemplate = restTemplate;
    this.profileModuleAccessConfig = profileModuleAccessConfig;
    this.sessionUserInfo = sessionUserInfo;
  }

  @Override
  public List<Department> getCompanyDepartmentList(final String companyIdentity)
      throws MalformedURLException, IFlowMessageConversionFailureException {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Department saveDepartment(final Department department) throws MalformedURLException, IFlowMessageConversionFailureException {

    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void deleteDepartment(final Department department) throws MalformedURLException, IFlowMessageConversionFailureException {

    // TODO Auto-generated method stub

  }

}
