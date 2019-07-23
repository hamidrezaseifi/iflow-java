package com.pth.iflow.common.rest;

public class IflowRestPaths {

  public static class CoreModul {

    public static final int PORT = 1010;

    public static final String USER_SAVE                  = "/users/save";
    public static final String USER_READ_BY_ID            = "/users/readbyid/{userid}";
    public static final String USER_READ_BY_EMAIL         = "/users/readbyemail/{email}";
    public static final String USER_USERGROUPS_LIST       = "/users/user/groups/{userid}";
    public static final String USER_DEPARTMENTS_LIST      = "/users/user/departments/{userid}";
    public static final String USER_DEPARTMENTGROUPS_LIST = "/users/user/departmentgroups/{userid}";
    public static final String USER_DEPUTIES_LIST         = "/users/user/deputies/{userid}";
    public static final String USER_USER_LIST_BY_COMPANY  = "/users/company/users/{companyid}";

    public static final String COMPANY_READ_BY_ID = "/companies/readbyid/{companyid}";

    public static final String DEPARTMENT_READ_BY_ID                     = "/department/readbyid/{id}";
    public static final String DEPARTMENT_READ_LIST                      = "/department/list";
    public static final String DEPARTMENT_READ_LIST_BY_COMPANY           = "/department/company/list/{id}";
    public static final String DEPARTMENT_READ_ALLUSERLIST_BY_DEPARTMENT = "/department/alluser/list/{id}";

    public static final String DEPARTMENTGRPUP_READ_BY_ID                          = "/departmentgroup/readbyid/{id}";
    public static final String DEPARTMENTGRPUP_READ_LIST_BY_DEPARTMENT             = "/departmentgroup/department/list/{id}";
    public static final String DEPARTMENTGRPUP_READ_LIST                           = "/departmentgroup/list";
    public static final String DEPARTMENTGRPUP_READ_ALLUSERLIST_BY_DEPARTMENTGROUP = "/departmentgroup/alluser/list/{id}";

    public static final String WORKFLOWTYPE_READ_BY_ID           = "/workflowtype/readbyid/{id}";
    public static final String WORKFLOWTYPE_READ_LIST            = "/workflowtype/list";
    public static final String WORKFLOWTYPE_READ_LIST_BY_COMPANY = "/workflowtype/company/list/{id}";

    public static final String WORKFLOWTYPESTEP_READ_BY_ID            = "/workflowtypestep/readbyid/{id}";
    public static final String WORKFLOWTYPESTEP_READ_LIST_BY_WORKFLOW = "/workflowtypestep/workflowtype/list/{id}";
    public static final String WORKFLOWTYPESTEP_READ_LIST             = "/workflowtypestep/list";

    public static final String USERGROUP_READ_BY_ID           = "/usergroup/readbyid/{id}";
    public static final String USERGROUP_READ_LIST            = "/usergroup/list";
    public static final String USERGROUP_READ_LIST_BY_COMPANY = "/usergroup/company/list/{id}";

    public static final String WORKFLOW_SAVE                         = "/workflow/save";
    public static final String WORKFLOW_READ_BY_ID                   = "/workflow/readbyid/{id}";
    public static final String WORKFLOW_READ_LIST                    = "/workflow/list";
    public static final String WORKFLOW_READ_LIST_BY_TYPE            = "/workflow/type/list/{id}";
    public static final String WORKFLOW_READ_LIST_BY_USER            = "/workflow/user/list/{id}/{status}";
    public static final String WORKFLOW_ACTION_SAVE                  = "/workflow/action/save";
    public static final String WORKFLOW_ACTION_READ_BY_ID            = "/workflow/action/readbyid/{id}";
    public static final String WORKFLOW_ACTION_READ_LIST_BY_WORKFLOW = "/workflow/action/workflow/list/{id}";
    public static final String WORKFLOW_FILE_SAVE                    = "/workflow/file/save";
    public static final String WORKFLOW_FILE_READ_BY_ID              = "/workflow/file/readbyid/{id}";
    public static final String WORKFLOW_FILE_READ_LIST_BY_WORKFLOW   = "/workflow/file/workflow/list/{id}";

  }

  public static class WorkflowModule {

    public static final int PORT = 1030;

    public static final String WORKFLOWTYPE_READ_BY_ID           = "/workflowtype/readbyid/{id}";
    public static final String WORKFLOWTYPE_READ_LIST            = "/workflowtype/list";
    public static final String WORKFLOWTYPE_READ_LIST_BY_COMPANY = "/workflowtype/company/list/{id}";

    public static final String WORKFLOWTYPESTEP_READ_BY_ID            = "/workflowtypestep/readbyid/{id}";
    public static final String WORKFLOWTYPESTEP_READ_LIST_BY_WORKFLOW = "/workflowtypestep/workflowtype/list/{id}";
    public static final String WORKFLOWTYPESTEP_READ_LIST             = "/workflowtypestep/list";

    public static final String WORKFLOW_SAVE              = "/workflow/save";
    public static final String WORKFLOW_READ_BY_ID        = "/workflow/readbyid/{id}";
    public static final String WORKFLOW_READ_LIST         = "/workflow/list";
    public static final String WORKFLOW_READ_LIST_BY_TYPE = "/workflow/type/list/{id}";
    public static final String WORKFLOW_READ_LIST_BY_USER = "/workflow/user/list/{id}/{status}";

  }

  public static class ProfileModule {

    public static final int PORT = 1020;

    public static final String AUTHENTICATION_AUTHENTICATE    = "/auth/authenticate";
    public static final String PROFILE_READ_AUTHENTOCATEDINFO = "/profile/read/authinfo";
    public static final String PROFILE_READ_TOKENINFO         = "/profile/read/tokeninfo";
    public static final String PROFILE_VALIDATE_TOKEN        = "/profile/validate/token";

    public static final String COMPANY_READ_BY_ID           = "/company/readbyid/{companyid}";
    public static final String COMPANY_READ_USER_LIST       = "/company/read/user/{companyid}";
    public static final String COMPANY_READ_USERGROUP_LIST  = "/company/read/usergroup/{companyid}";
    public static final String COMPANY_READ_DEPARTMENT_LIST = "/company/read/department/{companyid}";

    public static final String DEPARTMENT_READ_BY_ID                = "/department/readbyid/{id}";
    public static final String DEPARTMENT_READ_DEPARTMENTGROUP_LIST = "/department/read/departmentgroup/{id}";
    public static final String DEPARTMENT_READ_ALLUSERS_LIST        = "/department/read/allusers/{id}";

    public static final String DEPARTMENTGROUP_READ_BY_ID     = "/departmentgroup/readbyid/{id}";
    public static final String DEPARTMENTGROUP_READ_USER_LIST = "/departmentgroup/read/user/{id}";

  }
}
