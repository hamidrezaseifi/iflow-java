package com.pth.iflow.gui.services.impl.handler;

import java.net.MalformedURLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.models.Department;
import com.pth.iflow.gui.models.ui.SessionUserInfo;
import com.pth.iflow.gui.services.IDepartmentAccess;
import com.pth.iflow.gui.services.IDepartmentHandler;

@Service
public class DepartmentHandler implements IDepartmentHandler {

  private final IDepartmentAccess departmentAccess;
  private final SessionUserInfo sessionUserInfo;

  public DepartmentHandler(@Autowired final IDepartmentAccess departmentAccess, @Autowired final SessionUserInfo sessionUserInfo) {

    this.departmentAccess = departmentAccess;
    this.sessionUserInfo = sessionUserInfo;
  }

  @Override
  public List<Department> getCompanyDepartmentList(final String companyIdentity)
      throws MalformedURLException, IFlowMessageConversionFailureException {

    return this.departmentAccess.getCompanyDepartmentList(companyIdentity);
  }

  @Override
  public Department createDepartment(final Department department) throws MalformedURLException, IFlowMessageConversionFailureException {

    department.setCompanyIdentity(this.sessionUserInfo.getCompany().getIdentity());
    return this.departmentAccess.saveDepartment(department);
  }

  @Override
  public Department updateDepartment(final Department department) throws MalformedURLException, IFlowMessageConversionFailureException {

    department.setCompanyIdentity(this.sessionUserInfo.getCompany().getIdentity());
    return this.departmentAccess.saveDepartment(department);
  }

  @Override
  public void deleteDepartment(final Department department) throws MalformedURLException, IFlowMessageConversionFailureException {

    this.departmentAccess.deleteDepartment(department);

  }

}
