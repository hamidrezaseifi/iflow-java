package com.pth.iflow.gui.services;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.models.Department;

public interface IDepartmentAccess {

  public List<Department> getCompanyDepartmentList(final String companyIdentity)
      throws MalformedURLException, IFlowMessageConversionFailureException;

  public Department saveDepartment(final Department department) throws MalformedURLException, IFlowMessageConversionFailureException;

  public void deleteDepartment(Department department) throws MalformedURLException, IFlowMessageConversionFailureException;

}
