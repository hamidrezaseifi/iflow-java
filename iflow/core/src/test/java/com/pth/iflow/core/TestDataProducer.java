package com.pth.iflow.core;

import java.util.Arrays;
import java.util.List;

import com.pth.iflow.core.model.Company;
import com.pth.iflow.core.model.User;

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

  protected User getTestUser() {
    final User model = new User();
    model.setCompanyId(1L);
    model.setId(1L);
    model.setEmail("email");
    model.setFirstName("firstName");
    model.setLastName("lastName");
    model.setStatus(1);
    model.setVersion(1);
    model.setDepartmentGroups(getTestDepartmentGroupIdList());
    model.setDepartments(getTestDepartmentIdList());
    model.setDeputies(getTestDeputiyIdList());
    model.setGroups(getTestGroupIdList());
    
    return model;
  }
  
  protected List<Long> getTestGroupIdList() {
    return Arrays.asList(1L, 2L, 3L);
  }
  
  protected List<Long> getTestDepartmentIdList() {
    return Arrays.asList(1L, 2L, 3L);
  }
  
  protected List<Long> getTestDepartmentGroupIdList() {
    return Arrays.asList(1L, 2L, 3L);
  }
  
  protected List<Long> getTestWorkflowTypeIdList() {
    return Arrays.asList(1L, 2L, 3L);
  }
  
  protected List<Long> getTestWorkflowTypeStepIdList() {
    return Arrays.asList(1L, 2L, 3L);
  }
  
  protected List<Long> getTestDeputiyIdList() {
    return Arrays.asList(1L, 2L, 3L);
  }

}
