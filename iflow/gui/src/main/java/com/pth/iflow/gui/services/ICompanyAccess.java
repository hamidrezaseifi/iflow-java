package com.pth.iflow.gui.services;

import java.net.MalformedURLException;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;
import com.pth.iflow.gui.models.Company;

public interface ICompanyAccess {

  public Company readCompany(final String identity) throws MalformedURLException, IFlowMessageConversionFailureException;

  public Company saveCompany(final Company company) throws MalformedURLException, IFlowMessageConversionFailureException;

}
