package com.pth.iflow.gui.services;

import java.net.MalformedURLException;
import java.util.List;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.models.Department;

public interface IDepartmentHandler {

  public List<Department> getCompanyDepartmentList(final String companyIdentity)
      throws MalformedURLException, IFlowMessageConversionFailureException;

  public Department createDepartment(final Department department) throws MalformedURLException, IFlowMessageConversionFailureException;

  public Department updateDepartment(final Department department) throws MalformedURLException, IFlowMessageConversionFailureException;

  public void deleteDepartment(Department department) throws MalformedURLException, IFlowMessageConversionFailureException;

}
