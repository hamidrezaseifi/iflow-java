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

    public static final String INVOICEWORKFLOW_SAVE                                             = "/invworkflow/save";
    public static final String INVOICEWORKFLOW_READ_BY_IDENTITY                                 = "/invworkflow/readbyid/{identity}";
    public static final String INVOICEWORKFLOW_READ_LIST                                        = "/invworkflow/list";
    public static final String INVOICEWORKFLOW_READ_LIST_BY_USERIDENTITY                        = "/invworkflow/user/list/{email}/{status}";
    public static final String INVOICEWORKFLOW_ACTION_SAVE                                      = "/invworkflow/action/save";
    public static final String INVOICEWORKFLOW_ACTION_READ_BY_IDENTITY                          = "/invworkflow/action/readbyid/{identity}";
    public static final String INVOICEWORKFLOW_ACTION_READ_LIST_BY_WORKFLOWIDENTITY             = "/invworkflow/action/workflow/list/{identity}";
    public static final String INVOICEWORKFLOW_FILE_SAVE                                        = "/invworkflow/file/save";
    public static final String INVOICEWORKFLOW_FILE_READ_BY_IDENTITY                            = "/invworkflow/file/readbyid/{identity}";
    public static final String INVOICEWORKFLOW_FILE_READ_LIST_BY_WORKFLOWIDENTITY               = "/invworkflow/file/workflow/list/{identity}";
    public static final String INVOICEWORKFLOW_SEARCH                                           = "/invworkflow/search";

    public static final String SINGLETASKWORKFLOW_SAVE                                          = "/singletaskworkflow/save";
    public static final String SINGLETASKWORKFLOW_READ_BY_IDENTITY                              = "/singletaskworkflow/readbyid/{identity}";
    public static final String SINGLETASKWORKFLOW_READ_LIST                                     = "/singletaskworkflow/list";
    public static final String SINGLETASKWORKFLOW_READ_LIST_BY_USERIDENTITY                     = "/singletaskworkflow/user/list/{email}/{status}";
    public static final String SINGLETASKWORKFLOW_ACTION_SAVE                                   = "/singletaskworkflow/action/save";
    public static final String SINGLETASKWORKFLOW_ACTION_READ_BY_IDENTITY                       = "/singletaskworkflow/action/readbyid/{identity}";
    public static final String SINGLETASKWORKFLOW_ACTION_READ_LIST_BY_WORKFLOWIDENTITY          = "/singletaskworkflow/action/workflow/list/{identity}";
    public static final String SINGLETASKWORKFLOW_FILE_SAVE                                     = "/singletaskworkflow/file/save";
    public static final String SINGLETASKWORKFLOW_FILE_READ_BY_IDENTITY                         = "/singletaskworkflow/file/readbyid/{identity}";
    public static final String SINGLETASKWORKFLOW_FILE_READ_LIST_BY_WORKFLOWIDENTITY            = "/singletaskworkflow/file/workflow/list/{identity}";
    public static final String SINGLETASKWORKFLOW_SEARCH                                        = "/singletaskworkflow/search";

    public static final String TESTTHREETASKWORKFLOW_SAVE                                       = "/threetaskworkflow/save";
    public static final String TESTTHREETASKWORKFLOW_READ_BY_IDENTITY                           = "/threetaskworkflow/readbyid/{identity}";
    public static final String TESTTHREETASKWORKFLOW_READ_LIST                                  = "/threetaskworkflow/list";
    public static final String TESTTHREETASKWORKFLOW_READ_LIST_BY_USERIDENTITY                  = "/threetaskworkflow/user/list/{email}/{status}";
    public static final String TESTTHREETASKWORKFLOW_ACTION_SAVE                                = "/threetaskworkflow/action/save";
    public static final String TESTTHREETASKWORKFLOW_ACTION_READ_BY_IDENTITY                    = "/threetaskworkflow/action/readbyid/{identity}";
    public static final String TESTTHREETASKWORKFLOW_ACTION_READ_LIST_BY_WORKFLOWIDENTITY       = "/threetaskworkflow/action/workflow/list/{identity}";
    public static final String TESTTHREETASKWORKFLOW_FILE_SAVE                                  = "/threetaskworkflow/file/save";
    public static final String TESTTHREETASKWORKFLOW_FILE_READ_BY_IDENTITY                      = "/threetaskworkflow/file/readbyid/{identity}";
    public static final String TESTTHREETASKWORKFLOW_FILE_READ_LIST_BY_WORKFLOWIDENTITY         = "/threetaskworkflow/file/workflow/list/{identity}";
    public static final String TESTTHREETASKWORKFLOW_SEARCH                                     = "/threetaskworkflow/search";

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

    /*
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */

    public static URI READ_SINGLETASKWORKFLOW_BY_IDENTITY(final String identity) {
      final IflowUriBuilder builder = new IflowUriBuilder(SINGLETASKWORKFLOW_READ_BY_IDENTITY);
      return builder.build(identity);
    }

    public static URI SAVE_SINGLETASKWORKFLOW() {
      final IflowUriBuilder builder = new IflowUriBuilder(SINGLETASKWORKFLOW_SAVE);
      return builder.build();
    }

    public static URI READ_SINGLETASKWORKFLOW_LIST() {
      final IflowUriBuilder builder = new IflowUriBuilder(SINGLETASKWORKFLOW_READ_LIST);
      return builder.build();
    }

    public static URI SEARCH_SINGLETASKWORKFLOW() {
      final IflowUriBuilder builder = new IflowUriBuilder(SINGLETASKWORKFLOW_SEARCH);
      return builder.build();
    }

    public static URI READ_SINGLETASKWORKFLOW_LIST_BY_USERIDENTITY(final String email, final int status) {
      final IflowUriBuilder builder = new IflowUriBuilder(SINGLETASKWORKFLOW_READ_LIST_BY_USERIDENTITY);
      return builder.build(email, status);
    }

    /*
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */

    public static URI READ_TESTTHREETASKWORKFLOW_BY_IDENTITY(final String identity) {
      final IflowUriBuilder builder = new IflowUriBuilder(TESTTHREETASKWORKFLOW_READ_BY_IDENTITY);
      return builder.build(identity);
    }

    public static URI SAVE_TESTTHREETASKWORKFLOW() {
      final IflowUriBuilder builder = new IflowUriBuilder(TESTTHREETASKWORKFLOW_SAVE);
      return builder.build();
    }

    public static URI READ_TESTTHREETASKWORKFLOW_LIST() {
      final IflowUriBuilder builder = new IflowUriBuilder(TESTTHREETASKWORKFLOW_READ_LIST);
      return builder.build();
    }

    public static URI SEARCH_TESTTHREETASKWORKFLOW() {
      final IflowUriBuilder builder = new IflowUriBuilder(TESTTHREETASKWORKFLOW_SEARCH);
      return builder.build();
    }

    public static URI READ_TESTTHREETASKWORKFLOW_LIST_BY_USERIDENTITY(final String email, final int status) {
      final IflowUriBuilder builder = new IflowUriBuilder(TESTTHREETASKWORKFLOW_READ_LIST_BY_USERIDENTITY);
      return builder.build(email, status);
    }
  }

  public static class WorkflowModule {

    public static final int    PORT                                            = 1030;

    public static final String WORKFLOWTYPE_READ_BY_IDENTITY                   = "/workflowtype/readbyid/{identity}";
    public static final String WORKFLOWTYPE_READ_LIST                          = "/workflowtype/list";
    public static final String WORKFLOWTYPE_READ_LIST_BY_COMPANYIDENTITY       = "/workflowtype/company/list/{identity}";

    public static final String WORKFLOWTYPESTEP_READ_BY_IDENTITY               = "/workflowtypestep/readbyid/{identity}";
    public static final String WORKFLOWTYPESTEP_READ_LIST_BY_WORKFLOWIDENTITY  = "/workflowtypestep/workflowtype/list/{identity}";
    public static final String WORKFLOWTYPESTEP_READ_LIST                      = "/workflowtypestep/list";

    public static final String WORKFLOWMESSAGE_READ_BY_USEREMAIL               = "/workflowoffer/user/{email}/{status}";

    public static final String INVOICEWORKFLOW_CREATE                          = "/workflow/invoice/create";
    public static final String INVOICEWORKFLOW_SAVE                            = "/workflow/invoice/save";
    public static final String INVOICEWORKFLOW_READ_BY_IDENTITY                = "/workflow/invoice/readbyid/{identity}";
    public static final String INVOICEWORKFLOW_READ_LIST                       = "/workflow/invoice/list";
    public static final String INVOICEWORKFLOW_READ_LIST_BY_USEREMAIL          = "/workflow/invoice/user/list/{email}/{status}";
    public static final String INVOICEWORKFLOW_SEARCH                          = "/workflow/invoice/search";
    public static final String INVOICEWORKFLOW_VALIDATE                        = "/workflow/invoice/validate";

    public static final String SINGLETASKWORKFLOW_CREATE                       = "/workflow/singletask/create";
    public static final String SINGLETASKWORKFLOW_SAVE                         = "/workflow/singletask/save";
    public static final String SINGLETASKWORKFLOW_READ_BY_IDENTITY             = "/workflow/singletask/readbyid/{identity}";
    public static final String SINGLETASKWORKFLOW_READ_LIST                    = "/workflow/singletask/list";
    public static final String SINGLETASKWORKFLOW_READ_LIST_BY_TYPEIDENTITY    = "/workflow/singletask/type/list/{identity}";
    public static final String SINGLETASKWORKFLOW_READ_LIST_BY_USEREMAIL       = "/workflow/singletask/user/list/{email}/{status}";
    public static final String SINGLETASKWORKFLOW_SEARCH                       = "/workflow/singletask/search";
    public static final String SINGLETASKWORKFLOW_VALIDATE                     = "/workflow/singletask/validate";

    public static final String TESTTHREETASKWORKFLOW_CREATE                    = "/workflow/testthreetask/create";
    public static final String TESTTHREETASKWORKFLOW_SAVE                      = "/workflow/testthreetask/save";
    public static final String TESTTHREETASKWORKFLOW_READ_BY_IDENTITY          = "/workflow/testthreetask/readbyid/{identity}";
    public static final String TESTTHREETASKWORKFLOW_READ_LIST                 = "/workflow/testthreetask/list";
    public static final String TESTTHREETASKWORKFLOW_READ_LIST_BY_TYPEIDENTITY = "/workflow/testthreetask/type/list/{identity}";
    public static final String TESTTHREETASKWORKFLOW_READ_LIST_BY_USEREMAIL    = "/workflow/testthreetask/user/list/{email}/{status}";
    public static final String TESTTHREETASKWORKFLOW_SEARCH                    = "/workflow/testthreetask/search";
    public static final String TESTTHREETASKWORKFLOW_VALIDATE                  = "/workflow/testthreetask/validate";

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

    public static URI READ_WORKFLOWMESSAGE_READ_BY_USER(final String email, final int status) {
      final IflowUriBuilder builder = new IflowUriBuilder(WORKFLOWMESSAGE_READ_BY_USEREMAIL);
      return builder.build(email, status);
    }

    public static URI READ_INVOICEWORKFLOW_BY_IDENTITY_URIBUILDER(final String identity) {
      final IflowUriBuilder builder = new IflowUriBuilder(INVOICEWORKFLOW_READ_BY_IDENTITY);
      return builder.build(identity);
    }

    public static URI READ_INVOICEWORKFLOWLIST_BY_USERID_URIBUILDER(final String email, final int status) {
      final IflowUriBuilder builder = new IflowUriBuilder(INVOICEWORKFLOW_READ_LIST_BY_USEREMAIL);
      return builder.build(email, status);
    }

    public static URI CREATE_INVOICEWORKFLOW() {
      final IflowUriBuilder builder = new IflowUriBuilder(INVOICEWORKFLOW_CREATE);
      return builder.build();
    }

    public static URI SAVE_INVOICEWORKFLOW() {
      final IflowUriBuilder builder = new IflowUriBuilder(INVOICEWORKFLOW_SAVE);
      return builder.build();
    }

    public static URI SEARCH_INVOICEWORKFLOW() {
      final IflowUriBuilder builder = new IflowUriBuilder(INVOICEWORKFLOW_SEARCH);
      return builder.build();
    }

    public static URI VALIDATE_INVOICEWORKFLOW() {
      final IflowUriBuilder builder = new IflowUriBuilder(INVOICEWORKFLOW_VALIDATE);
      return builder.build();
    }

    public static URI READ_SINGLETASKWORKFLOW_BY_IDENTITY_URIBUILDER(final String identity) {
      final IflowUriBuilder builder = new IflowUriBuilder(SINGLETASKWORKFLOW_READ_BY_IDENTITY);
      return builder.build(identity);
    }

    public static URI READ_SINGLETASKWORKFLOWLIST_BY_USERID_URIBUILDER(final String email, final int status) {
      final IflowUriBuilder builder = new IflowUriBuilder(SINGLETASKWORKFLOW_READ_LIST_BY_USEREMAIL);
      return builder.build(email, status);
    }

    public static URI CREATE_SINGLETASKWORKFLOW() {
      final IflowUriBuilder builder = new IflowUriBuilder(SINGLETASKWORKFLOW_CREATE);
      return builder.build();
    }

    public static URI SAVE_SINGLETASKWORKFLOW() {
      final IflowUriBuilder builder = new IflowUriBuilder(SINGLETASKWORKFLOW_SAVE);
      return builder.build();
    }

    public static URI SEARCH_SINGLETASKWORKFLOW() {
      final IflowUriBuilder builder = new IflowUriBuilder(SINGLETASKWORKFLOW_SEARCH);
      return builder.build();
    }

    public static URI VALIDATE_SINGLETASKWORKFLOW() {
      final IflowUriBuilder builder = new IflowUriBuilder(SINGLETASKWORKFLOW_VALIDATE);
      return builder.build();
    }

    public static URI READ_TESTTHREETASKWORKFLOW_BY_IDENTITY_URIBUILDER(final String identity) {
      final IflowUriBuilder builder = new IflowUriBuilder(TESTTHREETASKWORKFLOW_READ_BY_IDENTITY);
      return builder.build(identity);
    }

    public static URI READ_TESTTHREETASKWORKFLOWLIST_BY_USERID_URIBUILDER(final String email, final int status) {
      final IflowUriBuilder builder = new IflowUriBuilder(TESTTHREETASKWORKFLOW_READ_LIST_BY_USEREMAIL);
      return builder.build(email, status);
    }

    public static URI CREATE_TESTTHREETASKWORKFLOW() {
      final IflowUriBuilder builder = new IflowUriBuilder(TESTTHREETASKWORKFLOW_CREATE);
      return builder.build();
    }

    public static URI SAVE_TESTTHREETASKWORKFLOW() {
      final IflowUriBuilder builder = new IflowUriBuilder(TESTTHREETASKWORKFLOW_SAVE);
      return builder.build();
    }

    public static URI SEARCH_TESTTHREETASKWORKFLOW() {
      final IflowUriBuilder builder = new IflowUriBuilder(TESTTHREETASKWORKFLOW_SEARCH);
      return builder.build();
    }

    public static URI VALIDATE_TESTTHREETASKWORKFLOW() {
      final IflowUriBuilder builder = new IflowUriBuilder(TESTTHREETASKWORKFLOW_VALIDATE);
      return builder.build();
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

  public static class GuiModule {

    private GuiModule() {
    }

    public static final int    PORT                                   = 1200;

    public static final String INVOICEWORKFLOW_PAGE_BASE              = "/workflow/invoice/";
    public static final String SINGLETASKWORKFLOW_PAGE_BASE           = "/workflow/singletask/";
    public static final String TESTTHREETASKWORKFLOW_PAGE_BASE        = "/workflow/testthreetask/";

    public static final String INVOICEWORKFLOW_CREATE                 = "/workflow/create";

    public static final String INVOICEWORKFLOW_SAVE                   = "/workflow/invoice/save";
    public static final String INVOICEWORKFLOW_READ_BY_IDENTITY       = "/workflow/invoice/readbyid/{identity}";
    public static final String INVOICEWORKFLOW_READ_LIST              = "/workflow/invoice/list";
    public static final String INVOICEWORKFLOW_READ_LIST_BY_USEREMAIL = "/workflow/invoice/user/list/{email}/{status}";
    public static final String INVOICEWORKFLOW_SEARCH                 = "/workflow/invoice/search";
    public static final String INVOICEWORKFLOW_VALIDATE               = "/workflow/invoice/validate";

  }
}
