package com.pth.iflow.common.rest;

public class IflowRestPaths {

  public static class Core {

    public static final String USER_READ_BY_ID = "/users/readbyid/{userid}";
    public static final String USER_READ_BY_EMAIL = "/users/readbyemail/{email}";
    public static final String USER_USERGROUPS_LIST = "/users/user/groups/{userid}";
    public static final String USER_DEPARTMENTS_LIST = "/users/user/departments/{userid}";
    public static final String USER_DEPARTMENTGROUPS_LIST = "/users/user/departmentgroups/{userid}";
    public static final String USER_DEPUTIES_LIST = "/users/user/deputies/{userid}";

    public static final String COMPANY_READ_BY_ID = "/companies/readbyid/{companyid}";

    public static final String DEPARTMENT_READ_BY_ID = "/departments/readbyid/{id}";
    public static final String DEPARTMENT_READ_LIST = "/departments/list";
    public static final String DEPARTMENT_READ_LIST_BY_COMPANY = "/departments/company/list/{id}";

    public static final String DEPARTMENTGRPUP_READ_BY_ID = "/departmentgropup/readbyid/{id}";
    public static final String DEPARTMENTGRPUP_READ_LIST_BY_DEPARTMENT = "/departmentgropup/department/list/{id}";
    public static final String DEPARTMENTGRPUP_READ_LIST = "/departmentgropup/list";

  }
}
