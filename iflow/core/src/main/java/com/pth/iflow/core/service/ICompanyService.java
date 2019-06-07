package com.pth.iflow.core.service;

import com.pth.iflow.core.model.Company;

public interface ICompanyService {

  public Company getById(Long id);

  public Company getByIdentifyId(final String identifyId);
}
