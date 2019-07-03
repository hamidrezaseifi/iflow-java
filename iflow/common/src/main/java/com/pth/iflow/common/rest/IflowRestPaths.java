package com.pth.iflow.common.rest;

public class IflowRestPaths {

  public static class CoreModul {

    public static final int PORT = 1010;

    public static final String USER_SAVE = "/users/save";
    public static final String USER_READ_BY_ID = "/users/readbyid/{userid}";
    public static final String USER_READ_BY_EMAIL = "/users/readbyemail/{email}";
    public static final String USER_USERGROUPS_LIST = "/users/user/groups/{userid}";
    public static final String USER_DEPARTMENTS_LIST = "/users/user/departments/{userid}";
    public static final String USER_DEPARTMENTGROUPS_LIST = "/users/user/departmentgroups/{userid}";
    public static final String USER_DEPUTIES_LIST = "/users/user/deputies/{userid}";

    public static final String COMPANY_READ_BY_ID = "/companies/readbyid/{companyid}";

    public static final String DEPARTMENT_READ_BY_ID = "/department/readbyid/{id}";
    public static final String DEPARTMENT_READ_LIST = "/department/list";
    public static final String DEPARTMENT_READ_LIST_BY_COMPANY = "/department/company/list/{id}";

    public static final String DEPARTMENTGRPUP_READ_BY_ID = "/departmentgroup/readbyid/{id}";
    public static final String DEPARTMENTGRPUP_READ_LIST_BY_DEPARTMENT = "/departmentgroup/department/list/{id}";
    public static final String DEPARTMENTGRPUP_READ_LIST = "/departmentgroup/list";

    public static final String WORKFLOWTYPE_READ_BY_ID = "/workflowtype/readbyid/{id}";
    public static final String WORKFLOWTYPE_READ_LIST = "/workflowtype/list";
    public static final String WORKFLOWTYPE_READ_LIST_BY_COMPANY = "/workflowtype/company/list/{id}";

    public static final String WORKFLOWTYPESTEP_READ_BY_ID = "/workflowtypestep/readbyid/{id}";
    public static final String WORKFLOWTYPESTEP_READ_LIST_BY_WORKFLOW = "/workflowtypestep/workflowtype/list/{id}";
    public static final String WORKFLOWTYPESTEP_READ_LIST = "/workflowtypestep/list";

    public static final String USERGROUP_READ_BY_ID = "/usergroup/readbyid/{id}";
    public static final String USERGROUP_READ_LIST = "/usergroup/list";
    public static final String USERGROUP_READ_LIST_BY_COMPANY = "/usergroup/company/list/{id}";

    public static final String WORKFLOW_SAVE = "/workflow/save";
    public static final String WORKFLOW_READ_BY_ID = "/workflow/readbyid/{id}";
    public static final String WORKFLOW_READ_LIST = "/workflow/list";
    public static final String WORKFLOW_READ_LIST_BY_TYPE = "/workflow/type/list/{id}";
    public static final String WORKFLOW_ACTION_SAVE = "/workflow/action/save";
    public static final String WORKFLOW_ACTION_READ_BY_ID = "/workflow/action/readbyid/{id}";
    public static final String WORKFLOW_ACTION_READ_LIST_BY_WORKFLOW = "/workflow/action/workflow/list/{id}";

  }

  public static class WorkflowModule {

    public static final int PORT = 1030;

    public static final String WORKFLOWTYPE_READ_BY_ID = "/workflowtype/readbyid/{id}";
    public static final String WORKFLOWTYPE_READ_LIST = "/workflowtype/list";
    public static final String WORKFLOWTYPE_READ_LIST_BY_COMPANY = "/workflowtype/company/list/{id}";

    public static final String WORKFLOWTYPESTEP_READ_BY_ID = "/workflowtypestep/readbyid/{id}";
    public static final String WORKFLOWTYPESTEP_READ_LIST_BY_WORKFLOW = "/workflowtypestep/workflowtype/list/{id}";
    public static final String WORKFLOWTYPESTEP_READ_LIST = "/workflowtypestep/list";

  }

  public static class ProfileModule {

    public static final int PORT = 1020;

    public static final String AUTHENTICATION_AUTHENTICATE = "/auth/authenticate";

  }
}
