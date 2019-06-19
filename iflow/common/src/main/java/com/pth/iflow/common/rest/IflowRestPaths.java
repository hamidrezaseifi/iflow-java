package com.pth.iflow.common.rest;

public class IflowRestPaths {
  
  public static class Core {
    
    public static final String USER_READ_BY_ID            = "/users/readbyid/{userid}";
    public static final String USER_READ_BY_EMAIL         = "/users/readbyemail/{email}";
    public static final String USER_USERGROUPS_LIST       = "/users/user/groups/{userid}";
    public static final String USER_DEPARTMENTS_LIST      = "/users/user/departments/{userid}";
    public static final String USER_DEPARTMENTGROUPS_LIST = "/users/user/departmentgroups/{userid}";
    public static final String USER_DEPUTIES_LIST         = "/users/user/deputies/{userid}";
    
    public static final String COMPANY_READ_BY_ID = "/companies/readbyid/{companyid}";
    
    public static final String DEPARTMENT_READ_BY_ID           = "/department/readbyid/{id}";
    public static final String DEPARTMENT_READ_LIST            = "/department/list";
    public static final String DEPARTMENT_READ_LIST_BY_COMPANY = "/department/company/list/{id}";
    
    public static final String DEPARTMENTGRPUP_READ_BY_ID              = "/departmentgroup/readbyid/{id}";
    public static final String DEPARTMENTGRPUP_READ_LIST_BY_DEPARTMENT = "/departmentgroup/department/list/{id}";
    public static final String DEPARTMENTGRPUP_READ_LIST               = "/departmentgroup/list";
    
    public static final String WORKFLOW_READ_BY_ID           = "/workflow/readbyid/{id}";
    public static final String WORKFLOW_READ_LIST            = "/workflow/list";
    public static final String WORKFLOW_READ_LIST_BY_COMPANY = "/workflow/company/list/{id}";
    
    public static final String WORKFLOWSTEP_READ_BY_ID              = "/workflowstep/readbyid/{id}";
    public static final String WORKFLOWSTEP_READ_LIST_BY_DEPARTMENT = "/workflowstep/department/list/{id}";
    public static final String WORKFLOWSTEP_READ_LIST               = "/workflowstep/list";
    
  }
}
