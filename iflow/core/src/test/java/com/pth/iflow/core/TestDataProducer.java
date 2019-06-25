package com.pth.iflow.core;

import java.util.Arrays;
import java.util.List;

import com.pth.iflow.core.model.Company;
import com.pth.iflow.core.model.Department;
import com.pth.iflow.core.model.DepartmentGroup;
import com.pth.iflow.core.model.User;
import com.pth.iflow.core.model.UserGroup;
import com.pth.iflow.core.model.WorkflowType;
import com.pth.iflow.core.model.WorkflowTypeStep;

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
  
  protected User getTestUser(final Long id, final String fname, final String lname, final String email) {
    final User model = new User();
    model.setCompanyId(1L);
    model.setId(id);
    model.setEmail(email);
    model.setFirstName(fname);
    model.setLastName(lname);
    model.setStatus(1);
    model.setVersion(1);
    model.setDepartmentGroups(getTestDepartmentGroupIdList());
    model.setDepartments(getTestDepartmentIdList());
    model.setDeputies(getTestDeputiyIdList());
    model.setGroups(getTestGroupIdList());

    return model;
  }
  
  protected List<User> getTestUserList() {
    final List<User> list = Arrays.asList(getTestUser(1L, "fname 1", "lname 1", "email 1"), getTestUser(2L, "fname 2", "lname 2", "email 2"),
        getTestUser(3L, "fname 3", "lname 3", "email 3"));

    return list;
  }
  
  protected Department getTestDepartment() {
    final Department model = new Department();
    model.setCompanyId(1L);
    model.setId(1L);
    model.setTitle("title");
    model.setStatus(1);
    model.setVersion(1);
    model.setGroups(getTestDepartmentGroupIdList());

    return model;
  }
  
  protected Department getTestDepartment(final Long id, final String title) {
    final Department model = new Department();
    model.setCompanyId(1L);
    model.setId(id);
    model.setTitle(title);
    model.setStatus(1);
    model.setVersion(1);
    model.setGroups(getTestDepartmentGroupIdList());

    return model;
  }
  
  protected List<Department> getTestDepartmentList() {
    final List<Department> list = Arrays.asList(getTestDepartment(1L, "Department 1"), getTestDepartment(2L, "Department 2"),
        getTestDepartment(3L, "Department 3"));

    return list;
  }
  
  protected DepartmentGroup getTestDepartmentGroup() {
    final DepartmentGroup model = new DepartmentGroup();
    model.setDepartmentId(1L);
    model.setId(1L);
    model.setTitle("title");
    model.setStatus(1);
    model.setVersion(1);

    return model;
  }
  
  protected DepartmentGroup getTestDepartmentGroup(final Long id, final String title) {
    final DepartmentGroup model = new DepartmentGroup();
    model.setDepartmentId(1L);
    model.setId(id);
    model.setTitle(title);
    model.setStatus(1);
    model.setVersion(1);

    return model;
  }
  
  protected List<DepartmentGroup> getTestDepartmentGroupList() {
    final List<DepartmentGroup> list = Arrays.asList(getTestDepartmentGroup(1L, "DepartmentGroup 1"), getTestDepartmentGroup(2L, "DepartmentGroup 2"),
        getTestDepartmentGroup(3L, "DepartmentGroup 3"));

    return list;
  }
  
  protected UserGroup getTestUserGroup() {
    final UserGroup model = new UserGroup();
    model.setCompanyId(1L);
    model.setId(1L);
    model.setTitle("title");
    model.setStatus(1);
    model.setVersion(1);

    return model;
  }
  
  protected UserGroup getTestUserGroup(final Long id, final String title) {
    final UserGroup model = new UserGroup();
    model.setCompanyId(1L);
    model.setId(id);
    model.setTitle(title);
    model.setStatus(1);
    model.setVersion(1);

    return model;
  }
  
  protected List<UserGroup> getTestUserGroupList() {
    final List<UserGroup> list = Arrays.asList(getTestUserGroup(1L, "UserGroup 1"), getTestUserGroup(2L, "UserGroup 2"),
        getTestUserGroup(3L, "UserGroup 3"));

    return list;
  }
  
  protected WorkflowType getTestWorkflowType() {
    final WorkflowType model = new WorkflowType();
    model.setCompanyId(1L);
    model.setId(1L);
    model.setTitle("title");
    model.setStatus(1);
    model.setVersion(1);
    model.setSteps(getTestWorkflowTypeStepIdList());
    model.setComments("comments");

    return model;
  }
  
  protected WorkflowType getTestWorkflowType(final Long id, final String title) {
    final WorkflowType model = new WorkflowType();
    model.setCompanyId(1L);
    model.setId(id);
    model.setTitle(title);
    model.setStatus(1);
    model.setVersion(1);
    model.setSteps(getTestWorkflowTypeStepIdList());
    model.setComments("comments");

    return model;
  }
  
  protected List<WorkflowType> getTestWorkflowTypeList() {
    final List<WorkflowType> list = Arrays.asList(getTestWorkflowType(1L, "WorkflowType 1"), getTestWorkflowType(2L, "WorkflowType 2"),
        getTestWorkflowType(3L, "WorkflowType 3"));

    return list;
  }

  protected WorkflowTypeStep getTestWorkflowTypeStep() {
    final WorkflowTypeStep model = new WorkflowTypeStep();
    model.setWorkflowTypeId(1L);
    model.setId(1L);
    model.setTitle("title");
    model.setStatus(1);
    model.setVersion(1);
    model.setComments("comments");

    return model;
  }
  
  protected WorkflowTypeStep getTestWorkflowTypeStep(final Long id, final String title) {
    final WorkflowTypeStep model = new WorkflowTypeStep();
    model.setWorkflowTypeId(1L);
    model.setId(id);
    model.setTitle(title);
    model.setStatus(1);
    model.setVersion(1);
    model.setComments("comments");

    return model;
  }
  
  protected List<WorkflowTypeStep> getTestWorkflowTypeStepList() {
    final List<WorkflowTypeStep> list = Arrays.asList(getTestWorkflowTypeStep(1L, "WorkflowTypeStep 1"),
        getTestWorkflowTypeStep(2L, "WorkflowTypeStep 2"),
        getTestWorkflowTypeStep(3L, "WorkflowTypeStep 3"));

    return list;
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
