package com.pth.iflow.core.service;

import com.pth.iflow.core.model.Company;

public interface ICompanyService {

  Company save(Company model);

  Company getById(Long id);

  Company getByIdentifyId(final String identifyId);
}
