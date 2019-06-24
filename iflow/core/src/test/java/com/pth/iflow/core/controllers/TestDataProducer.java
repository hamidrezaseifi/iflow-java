package com.pth.iflow.core.controllers;

import com.pth.iflow.core.model.Company;

public class TestDataProducer {
  
  protected Company getTestCompany() {
    final Company company = new Company();
    company.setCompanyName("companyName");
    company.setId(1L);
    company.setIdentifyid("identifyid");
    company.setStatus(1);
    company.setVersion(1);

    return company;
  }
}
