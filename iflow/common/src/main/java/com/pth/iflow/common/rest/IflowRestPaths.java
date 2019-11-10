package com.pth.iflow.common.rest;

import java.net.URI;

import org.springframework.web.util.DefaultUriBuilderFactory;

public class IflowRestPaths {

  public static class IflowUriBuilder {

    private final DefaultUriBuilderFactory uriFactory = new DefaultUriBuilderFactory();
    private final String                   template;

    public IflowUriBuilder(final String template) {
      this.template = template;
    }

    public URI build(final Object... args) {
      return this.uriFactory.expand(this.template, args);
    }

  }

  public static class CoreModule {

    public static final int    PORT                                                             = 1010;

    public static final String USER_SAVE                                                        = "/users/save";
    public static final String USER_READ_BY_EMAIL                                               = "/users/readbyemail/{email}";
    public static final String USER_USERGROUPS_LIST_BY_EMAIL                                    = "/users/user/groups/{email}";
    public static final String USER_DEPARTMENTS_LIST_BY_EMAIL                                   = "/users/user/departments/{email}";
    public static final String USER_DEPARTMENTGROUPS_LIST_BY_EMAIL                              = "/users/user/departmentgroups/{email}";
    public static final String USER_DEPUTIES_LIST_BY_EMAIL                                      = "/users/user/deputies/{email}";
    public static final String USER_USER_LIST_BY_COMPANYIDENTITY                                = "/users/company/users/{companyidentity}";
    public static final String USERPROFILE_READ_BY_EMAIL                                        = "/users/readprofile/{email}";

    public static final String COMPANY_READ_BY_IDENTITY                                         = "/companies/readbyid/{companyidentity}";

    public static final String DEPARTMENT_READ_BY_IDENTITY                                      = "/department/readbyid/{identity}";
    public static final String DEPARTMENT_READ_LIST                                             = "/department/list";
    public static final String DEPARTMENT_READ_LIST_BY_COMPANYIDENTITY                          = "/department/company/list/{companyidentity}";
    public static final String DEPARTMENT_READ_ALLUSERLIST_BY_DEPARTMENTIDENTITY                = "/department/alluser/list/{identity}";

    public static final String DEPARTMENTGRPUP_READ_BY_IDENTITY                                 = "/departmentgroup/readbyid/{identity}";
    public static final String DEPARTMENTGRPUP_READ_LIST_BY_DEPARTMENTIDENTITY                  = "/departmentgroup/department/list/{identity}";
    public static final String DEPARTMENTGRPUP_READ_LIST                                        = "/departmentgroup/list";
    public static final String DEPARTMENTGRPUP_READ_ALLUSERLIST_BY_DEPARTMENTGROUPIDENTITY      = "/departmentgroup/alluser/list/{identity}";

    public static final String WORKFLOWTYPE_READ_BY_IDENTITY                                    = "/workflowtype/readbyid/{identity}";
    public static final String WORKFLOWTYPE_READ_LIST                                           = "/workflowtype/list";
    public static final String WORKFLOWTYPE_READ_LIST_BY_COMPANYIDENTITY                        = "/workflowtype/company/list/{companyidentity}";

    public static final String WORKFLOWTYPESTEP_READ_BY_IDENTITY                                = "/workflowtypestep/readbyid/{identity}";
    public static final String WORKFLOWTYPESTEP_READ_LIST_BY_WORKFLOWIDENTITY                   = "/workflowtypestep/workflowtype/list/{identity}";
    public static final String WORKFLOWTYPESTEP_READ_LIST                                       = "/workflowtypestep/list";

    public static final String USERGROUP_READ_BY_IDENTITY                                       = "/usergroup/readbyid/{identity}";
    public static final String USERGROUP_READ_LIST                                              = "/usergroup/list";
    public static final String USERGROUP_READ_LIST_BY_COMPANYIDENTITY                           = "/usergroup/company/list/{companyidentity}";

    public static final String INVOICEWORKFLOW_SAVE                                             = "/workflow/save";
    public static final String INVOICEWORKFLOW_READ_BY_IDENTITY                                 = "/workflow/readbyid/{identity}";
    public static final String INVOICEWORKFLOW_READ_LIST                                        = "/workflow/list";
    public static final String INVOICEWORKFLOW_READ_LIST_BY_USERIDENTITY                        = "/workflow/user/list/{email}/{status}";
    public static final String INVOICEWORKFLOW_ACTION_SAVE                                      = "/workflow/action/save";
    public static final String INVOICEWORKFLOW_ACTION_READ_BY_IDENTITY                          = "/workflow/action/readbyid/{identity}";
    public static final String INVOICEWORKFLOW_ACTION_READ_LIST_BY_WORKFLOWIDENTITY             = "/workflow/action/workflow/list/{identity}";
    public static final String INVOICEWORKFLOW_FILE_SAVE                                        = "/workflow/file/save";
    public static final String INVOICEWORKFLOW_FILE_READ_BY_IDENTITY                            = "/workflow/file/readbyid/{identity}";
    public static final String INVOICEWORKFLOW_FILE_READ_LIST_BY_WORKFLOWIDENTITY               = "/workflow/file/workflow/list/{identity}";
    public static final String INVOICEWORKFLOW_SEARCH                                           = "/workflow/search";

    public static final String WORKFLOWMESSAGE_READ_BY_USEREMAIL                                = "/workflowmessage/user/{email}/{status}";
    public static final String WORKFLOWMESSAGE_READ_BY_WORKFLOWIDENTITY                         = "/workflowmessage/workflow/{workflowid}";
    public static final String WORKFLOWMESSAGE_SAVE                                             = "/workflowmessage/save";
    public static final String WORKFLOWMESSAGE_CHANGE_WORKFLOWMESSAGE_STAUS_BY_WORKFLOWIDENTITY = "/workflowmessage/changestatus/{workflowid}/{stepidentity}/{email}/{status}";

    public static URI READ_WORKFLOWMESSAGE_READ_BY_USER(final String email, final int status) {
      final IflowUriBuilder builder = new IflowUriBuilder(WORKFLOWMESSAGE_READ_BY_USEREMAIL);
      return builder.build(email, status);
    }

    public static URI READ_WORKFLOWMESSAGE_READ_BY_WORKFLOW(final String workflowidentity) {
      final IflowUriBuilder builder = new IflowUriBuilder(WORKFLOWMESSAGE_READ_BY_WORKFLOWIDENTITY);
      return builder.build(workflowidentity);
    }

    public static URI SAVE_WORKFLOWMESSAGE() {
      final IflowUriBuilder builder = new IflowUriBuilder(WORKFLOWMESSAGE_SAVE);
      return builder.build();
    }

    public static URI CHANGE_WORKFLOWMESSAGE_WORKFLOWMESSAGE_STAUS(final String workflowidentity, final String stepidentity,
        final String email, final int status) {
      final IflowUriBuilder builder = new IflowUriBuilder(WORKFLOWMESSAGE_CHANGE_WORKFLOWMESSAGE_STAUS_BY_WORKFLOWIDENTITY);
      return builder.build(workflowidentity, stepidentity, email, status);
    }

    public static URI READ_DEPARTMENTGRPUP_ALLUSERLIST_BY_DEPARTMENTGROUP(final String identity) {
      final IflowUriBuilder builder = new IflowUriBuilder(DEPARTMENTGRPUP_READ_ALLUSERLIST_BY_DEPARTMENTGROUPIDENTITY);
      return builder.build(identity);
    }

    public static URI READ_USER_BY_EMAIL(final String email) {
      final IflowUriBuilder builder = new IflowUriBuilder(USER_READ_BY_EMAIL);
      return builder.build(email);
    }

    public static URI READ_USER_USER_LIST_BY_COMPANY(final String companyidentity) {
      final IflowUriBuilder builder = new IflowUriBuilder(USER_USER_LIST_BY_COMPANYIDENTITY);
      return builder.build(companyidentity);
    }

    public static URI READ_USERPROFILE_BY_EMAIL(final String email) {
      final IflowUriBuilder builder = new IflowUriBuilder(USERPROFILE_READ_BY_EMAIL);
      return builder.build(email);
    }

    public static URI READ_USERGROUP_BY_ID(final String identity) {
      final IflowUriBuilder builder = new IflowUriBuilder(USERGROUP_READ_BY_IDENTITY);
      return builder.build(identity);
    }

    public static URI READ_USERGROUP_LIST_BY_COMPANY(final String companyidentity) {
      final IflowUriBuilder builder = new IflowUriBuilder(USERGROUP_READ_LIST_BY_COMPANYIDENTITY);
      return builder.build(companyidentity);
    }

    public static URI READ_COMPANY_BY_ID(final String companyidentity) {
      final IflowUriBuilder builder = new IflowUriBuilder(COMPANY_READ_BY_IDENTITY);
      return builder.build(companyidentity);
    }

    public static URI READ_DEPARTMENTGRPUP_BY_ID(final String identity) {
      final IflowUriBuilder builder = new IflowUriBuilder(DEPARTMENTGRPUP_READ_BY_IDENTITY);
      return builder.build(identity);
    }

    public static URI READ_DEPARTMENT_BY_ID(final String identity) {
      final IflowUriBuilder builder = new IflowUriBuilder(DEPARTMENT_READ_BY_IDENTITY);
      return builder.build(identity);
    }

    public static URI READ_DEPARTMENT_LIST_BY_COMPANY(final String companyidentity) {
      final IflowUriBuilder builder = new IflowUriBuilder(DEPARTMENT_READ_LIST_BY_COMPANYIDENTITY);
      return builder.build(companyidentity);
    }

    public static URI READ_DEPARTMENTGRPUP_LIST_BY_DEPARTMENT(final String identity) {
      final IflowUriBuilder builder = new IflowUriBuilder(DEPARTMENTGRPUP_READ_LIST_BY_DEPARTMENTIDENTITY);
      return builder.build(identity);
    }

    public static URI READ_DEPARTMENT_ALLUSERLIST_BY_DEPARTMENT(final String identity) {
      final IflowUriBuilder builder = new IflowUriBuilder(DEPARTMENT_READ_ALLUSERLIST_BY_DEPARTMENTIDENTITY);
      return builder.build(identity);
    }

    public static URI READ_WORKFLOWTYPESTEP_BY_IDENTITY(final String identity) {
      final IflowUriBuilder builder = new IflowUriBuilder(WORKFLOWTYPESTEP_READ_BY_IDENTITY);
      return builder.build(identity);
    }

    public static URI READ_WORKFLOWTYPESTEP_LIST_BY_WORKFLOW(final String identity) {
      final IflowUriBuilder builder = new IflowUriBuilder(WORKFLOWTYPESTEP_READ_LIST_BY_WORKFLOWIDENTITY);
      return builder.build(identity);
    }

    public static URI READ_WORKFLOWTYPESTEP_LIST() {
      final IflowUriBuilder builder = new IflowUriBuilder(WORKFLOWTYPESTEP_READ_LIST);
      return builder.build();
    }

    public static URI READ_WORKFLOWTYPE_BY_IDENTITY(final String identity) {
      final IflowUriBuilder builder = new IflowUriBuilder(WORKFLOWTYPE_READ_BY_IDENTITY);
      return builder.build(identity);
    }

    public static URI READ_WORKFLOWTYPE_LIST_BY_COMPANY(final String companyidentity) {
      final IflowUriBuilder builder = new IflowUriBuilder(WORKFLOWTYPE_READ_LIST_BY_COMPANYIDENTITY);
      return builder.build(companyidentity);
    }

    public static URI READ_WORKFLOWTYPE_LIST() {
      final IflowUriBuilder builder = new IflowUriBuilder(WORKFLOWTYPE_READ_LIST);
      return builder.build();
    }

    public static URI READ_INVOICEWORKFLOW_BY_IDENTITY(final String identity) {
      final IflowUriBuilder builder = new IflowUriBuilder(INVOICEWORKFLOW_READ_BY_IDENTITY);
      return builder.build(identity);
    }

    public static URI SAVE_INVOICEWORKFLOW() {
      final IflowUriBuilder builder = new IflowUriBuilder(INVOICEWORKFLOW_SAVE);
      return builder.build();
    }

    public static URI READ_INVOICEWORKFLOW_LIST() {
      final IflowUriBuilder builder = new IflowUriBuilder(INVOICEWORKFLOW_READ_LIST);
      return builder.build();
    }

    public static URI SEARCH_INVOICEWORKFLOW() {
      final IflowUriBuilder builder = new IflowUriBuilder(INVOICEWORKFLOW_SEARCH);
      return builder.build();
    }

    public static URI READ_INVOICEWORKFLOW_LIST_BY_USERIDENTITY(final String email, final int status) {
      final IflowUriBuilder builder = new IflowUriBuilder(INVOICEWORKFLOW_READ_LIST_BY_USERIDENTITY);
      return builder.build(email, status);
    }

  }

  public static class WorkflowModule {

    public static final int    PORT                                           = 1030;

    public static final String WORKFLOWTYPE_READ_BY_IDENTITY                  = "/workflowtype/readbyid/{identity}";
    public static final String WORKFLOWTYPE_READ_LIST                         = "/workflowtype/list";
    public static final String WORKFLOWTYPE_READ_LIST_BY_COMPANYIDENTITY      = "/workflowtype/company/list/{identity}";

    public static final String WORKFLOWTYPESTEP_READ_BY_IDENTITY              = "/workflowtypestep/readbyid/{identity}";
    public static final String WORKFLOWTYPESTEP_READ_LIST_BY_WORKFLOWIDENTITY = "/workflowtypestep/workflowtype/list/{identity}";
    public static final String WORKFLOWTYPESTEP_READ_LIST                     = "/workflowtypestep/list";

    public static final String WORKFLOW_CREATE                                = "/workflow/create";
    public static final String WORKFLOW_SAVE                                  = "/workflow/save";
    public static final String WORKFLOW_READ_BY_IDENTITY                      = "/workflow/readbyid/{identity}";
    public static final String WORKFLOW_READ_LIST                             = "/workflow/list";
    public static final String WORKFLOW_READ_LIST_BY_TYPEIDENTITY             = "/workflow/type/list/{identity}";
    public static final String WORKFLOW_READ_LIST_BY_USEREMAIL                = "/workflow/user/list/{email}/{status}";
    public static final String WORKFLOW_SEARCH                                = "/workflow/search";
    public static final String WORKFLOW_VALIDATE                              = "/workflow/validate";

    public static final String WORKFLOWMESSAGE_READ_BY_USEREMAIL              = "/workflowoffer/user/{email}/{status}";

    public static final String INVOICE_CREATE                                 = "/invoice/create";
    public static final String INVOICE_SAVE                                   = "/invoice/save";
    public static final String INVOICE_READ_BY_IDENTITY                       = "/invoice/readbyid/{identity}";
    public static final String INVOICE_READ_LIST                              = "/invoice/list";
    public static final String INVOICE_READ_LIST_BY_TYPEIDENTITY              = "/invoice/type/list/{identity}";
    public static final String INVOICE_READ_LIST_BY_USEREMAIL                 = "/invoice/user/list/{email}/{status}";
    public static final String INVOICE_SEARCH                                 = "/invoice/search";
    public static final String INVOICE_VALIDATE                               = "/invoice/validate";

    public static URI WORKFLOWTYPE_BY_ID_URIBUILDER(final String identity) {
      final IflowUriBuilder builder = new IflowUriBuilder(WORKFLOWTYPE_READ_BY_IDENTITY);
      return builder.build(identity);
    }

    public static URI READ_WORKFLOWTYPELIST_BY_COMPANYID_URIBUILDER(final String companyidentity) {
      final IflowUriBuilder builder = new IflowUriBuilder(WORKFLOWTYPE_READ_LIST_BY_COMPANYIDENTITY);
      return builder.build(companyidentity);
    }

    public static URI READ_WORKFLOWTYPESTEP_BY_ID_URIBUILDER(final String identity) {
      final IflowUriBuilder builder = new IflowUriBuilder(WORKFLOWTYPESTEP_READ_BY_IDENTITY);
      return builder.build(identity);
    }

    public static URI READ_WORKFLOWTYPESTELIST_BY_WORKFLOWID_URIBUILDER(final String identity) {
      final IflowUriBuilder builder = new IflowUriBuilder(WORKFLOWTYPESTEP_READ_LIST_BY_WORKFLOWIDENTITY);
      return builder.build(identity);
    }

    public static URI READ_WORKFLOW_BY_IDENTITY_URIBUILDER(final String identity) {
      final IflowUriBuilder builder = new IflowUriBuilder(WORKFLOW_READ_BY_IDENTITY);
      return builder.build(identity);
    }

    public static URI READ_WORKFLOWLIST_BY_TYPEID_URIBUILDER(final String identity) {
      final IflowUriBuilder builder = new IflowUriBuilder(WORKFLOW_READ_LIST_BY_TYPEIDENTITY);
      return builder.build(identity);
    }

    public static URI READ_WORKFLOWLIST_BY_USERID_URIBUILDER(final String email, final int status) {
      final IflowUriBuilder builder = new IflowUriBuilder(WORKFLOW_READ_LIST_BY_USEREMAIL);
      return builder.build(email, status);
    }

    public static URI CREATE_WORKFLOW() {
      final IflowUriBuilder builder = new IflowUriBuilder(WORKFLOW_CREATE);
      return builder.build();
    }

    public static URI SAVE_WORKFLOW() {
      final IflowUriBuilder builder = new IflowUriBuilder(WORKFLOW_SAVE);
      return builder.build();
    }

    public static URI SEARCH_WORKFLOW() {
      final IflowUriBuilder builder = new IflowUriBuilder(WORKFLOW_SEARCH);
      return builder.build();
    }

    public static URI VALIDATE_WORKFLOW() {
      final IflowUriBuilder builder = new IflowUriBuilder(WORKFLOW_VALIDATE);
      return builder.build();
    }

    public static URI READ_INVOICE_BY_IDENTITY_URIBUILDER(final String identity) {
      final IflowUriBuilder builder = new IflowUriBuilder(INVOICE_READ_BY_IDENTITY);
      return builder.build(identity);
    }

    public static URI READ_INVOICELIST_BY_TYPEID_URIBUILDER(final String identity) {
      final IflowUriBuilder builder = new IflowUriBuilder(INVOICE_READ_LIST_BY_TYPEIDENTITY);
      return builder.build(identity);
    }

    public static URI READ_INVOICELIST_BY_USERID_URIBUILDER(final String email, final int status) {
      final IflowUriBuilder builder = new IflowUriBuilder(INVOICE_READ_LIST_BY_USEREMAIL);
      return builder.build(email, status);
    }

    public static URI CREATE_INVOICE() {
      final IflowUriBuilder builder = new IflowUriBuilder(INVOICE_CREATE);
      return builder.build();
    }

    public static URI SAVE_INVOICE() {
      final IflowUriBuilder builder = new IflowUriBuilder(INVOICE_SAVE);
      return builder.build();
    }

    public static URI SEARCH_INVOICE() {
      final IflowUriBuilder builder = new IflowUriBuilder(INVOICE_SEARCH);
      return builder.build();
    }

    public static URI VALIDATE_INVOICE() {
      final IflowUriBuilder builder = new IflowUriBuilder(INVOICE_VALIDATE);
      return builder.build();
    }

    public static URI READ_WORKFLOWMESSAGE_READ_BY_USER(final String email, final int status) {
      final IflowUriBuilder builder = new IflowUriBuilder(WORKFLOWMESSAGE_READ_BY_USEREMAIL);
      return builder.build(email, status);
    }

  }

  public static class ProfileModule {

    public static final int    PORT                                                = 1020;

    public static final String AUTHENTICATION_AUTHENTICATE                         = "/auth/authenticate";
    public static final String PROFILE_READ_AUTHENTOCATEDINFO                      = "/profile/read/authinfo";
    public static final String PROFILE_READ_TOKENINFO                              = "/profile/read/tokeninfo";
    public static final String PROFILE_VALIDATE_TOKEN                              = "/profile/validate/token";

    public static final String COMPANYIDENTITY_READ_BY_IDENTITY                    = "/company/readbyid/{companyidentity}";
    public static final String COMPANYIDENTITY_READ_USER_LIST                      = "/company/read/user/{companyidentity}";
    public static final String COMPANYIDENTITY_READ_USERGROUP_LIST                 = "/company/read/usergroup/{companyidentity}";
    public static final String COMPANYIDENTITY_READ_DEPARTMENT_LIST                = "/company/read/department/{companyidentity}";
    public static final String COMPANYIDENTITY_READ_PROFILE                        = "/company/read/profile/{companyidentity}";

    public static final String DEPARTMENT_READ_BY_IDENTITY                         = "/department/readbyid/{identity}";
    public static final String DEPARTMENT_READ_DEPARTMENTGROUP_LIST                = "/department/read/departmentgroup/{identity}";
    public static final String DEPARTMENT_READ_ALLUSERS_LIST                       = "/department/read/allusers/{identity}";

    public static final String DEPARTMENTGROUP_READ_BY_IDENTITY                    = "/departmentgroup/readbyid/{identity}";
    public static final String DEPARTMENTGROUP_READ_USER_LIST                      = "/departmentgroup/read/user/{identity}";

    public static final String CACHDATA_READ_USER_WORKFLOWMESSAGELIST              = "/cachdata/user/readworkflowmessagelist/{companyidentity}/{email}";
    public static final String CACHDATA_ADD_USER_WORKFLOWMESSAGELIST               = "/cachdata/user/addworkflowmessagelist/{companyidentity}/{email}";
    public static final String CACHDATA_CAL_USER_DATARESET_BY_COMPANYIDENTITY      = "/cachdata/user/datareset/{companyidentity}/{email}";
    public static final String CACHDATA_CAL_USERLIST_DATARESET_BY_COMPANYIDENTITY  = "/cachdata/userlist/datareset/{companyidentity}";
    public static final String CACHDATA_CAL_WORKFLOW_DATARESET_BY_WORKFLOWIDENTITY = "/cachdata/workflow/datareset/{companyidentity}/{identity}";

    public static URI READ_COMPANY_BY_ID_URIBUILDER(final String companyidentity) {
      final IflowUriBuilder builder = new IflowUriBuilder(COMPANYIDENTITY_READ_BY_IDENTITY);
      return builder.build(companyidentity);
    }

    public static URI READ_USERLIST_BY_COMPANYID_URIBUILDER(final String companyidentity) {
      final IflowUriBuilder builder = new IflowUriBuilder(COMPANYIDENTITY_READ_USER_LIST);
      return builder.build(companyidentity);
    }

    public static URI READ_USERGROUPLIST_BY_COMPANYID_URIBUILDER(final String companyidentity) {
      final IflowUriBuilder builder = new IflowUriBuilder(COMPANYIDENTITY_READ_USERGROUP_LIST);
      return builder.build(companyidentity);
    }

    public static URI READ_DEPARTMENTLIST_BY_COMPANYID_URIBUILDER(final String companyidentity) {
      final IflowUriBuilder builder = new IflowUriBuilder(COMPANYIDENTITY_READ_DEPARTMENT_LIST);
      return builder.build(companyidentity);
    }

    public static URI READ_PROFILE_BY_COMPANYID_URIBUILDER(final String companyidentity) {
      final IflowUriBuilder builder = new IflowUriBuilder(COMPANYIDENTITY_READ_PROFILE);
      return builder.build(companyidentity);
    }

    public static URI READ_DEPARTMENT_BY_ID_URIBUILDER(final String identity) {
      final IflowUriBuilder builder = new IflowUriBuilder(DEPARTMENT_READ_BY_IDENTITY);
      return builder.build(identity);
    }

    public static URI READ_DEPARTMENTGROUP_BY_DEPARTMENTID_URIBUILDER(final String identity) {
      final IflowUriBuilder builder = new IflowUriBuilder(DEPARTMENT_READ_DEPARTMENTGROUP_LIST);
      return builder.build(identity);
    }

    public static URI READ_ALLUSERS_BY_DEPARTMENTID_URIBUILDER(final String identity) {
      final IflowUriBuilder builder = new IflowUriBuilder(DEPARTMENT_READ_ALLUSERS_LIST);
      return builder.build(identity);
    }

    public static URI READ_DEPARTMENTGROUP_BY_ID_URIBUILDER(final String identity) {
      final IflowUriBuilder builder = new IflowUriBuilder(DEPARTMENTGROUP_READ_BY_IDENTITY);
      return builder.build(identity);
    }

    public static URI READ_ALLUSERS_BY_DEPARTMENTGROUPID_URIBUILDER(final String identity) {
      final IflowUriBuilder builder = new IflowUriBuilder(DEPARTMENTGROUP_READ_USER_LIST);
      return builder.build(identity);
    }

    public static URI READ_CACHDATA_USER_WORKFLOWMESSAGELIST(final String companyidentity, final String email) {
      final IflowUriBuilder builder = new IflowUriBuilder(CACHDATA_READ_USER_WORKFLOWMESSAGELIST);
      return builder.build(companyidentity, email);
    }

    public static URI ADD_CACHDATA_USER_WORKFLOWMESSAGELIST(final String companyidentity, final String email) {
      final IflowUriBuilder builder = new IflowUriBuilder(CACHDATA_ADD_USER_WORKFLOWMESSAGELIST);
      return builder.build(companyidentity, email);
    }

    public static URI CAL_CACHDATA_USER_DATARESET(final String companyidentity, final String email) {
      final IflowUriBuilder builder = new IflowUriBuilder(CACHDATA_CAL_USER_DATARESET_BY_COMPANYIDENTITY);
      return builder.build(companyidentity, email);
    }

    public static URI CAL_CACHDATA_USERLIST_DATARESET(final String companyidentity) {
      final IflowUriBuilder builder = new IflowUriBuilder(CACHDATA_CAL_USERLIST_DATARESET_BY_COMPANYIDENTITY);
      return builder.build(companyidentity);
    }

    public static URI CAL_CACHDATA_WORKFLOW_DATARESET(final String companyidentity, final String identity) {
      final IflowUriBuilder builder = new IflowUriBuilder(CACHDATA_CAL_WORKFLOW_DATARESET_BY_WORKFLOWIDENTITY);
      return builder.build(companyidentity, identity);
    }

    public static URI READ_PROFILE_TOKENINFO() {
      final IflowUriBuilder builder = new IflowUriBuilder(PROFILE_READ_TOKENINFO);
      return builder.build();
    }

    public static URI AUTHENTICATE_AUTHENTICATION() {
      final IflowUriBuilder builder = new IflowUriBuilder(AUTHENTICATION_AUTHENTICATE);
      return builder.build();
    }

    public static URI READ_PROFILE_AUTHENTOCATEDINFO() {
      final IflowUriBuilder builder = new IflowUriBuilder(PROFILE_READ_AUTHENTOCATEDINFO);
      return builder.build();
    }

  }
}
