package com.pth.iflow.gui.configurations;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.pth.iflow.common.rest.IflowRestPaths;

/**
 * a class to collect gui configuration from property file
 *
 * @author rezasei
 *
 */
@Component
public class GuiConfiguration {

  public static final String NO_ACCESS_URL = "/noaccess";
  public static final String INVALID_TOKEN_URL = "/invalidtoken";

  public static final List<String> NOAUTHENTICATED_URL_LIST = Arrays.asList(NO_ACCESS_URL, INVALID_TOKEN_URL);

  @Component
  public static class WorkflowModuleAccessConfig {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${iflow.gui.urls.workflow.base}")
    private String workflowBaseUrl;

    private URI baseWorkflowBaseUri;

    @PostConstruct
    private void init() throws URISyntaxException {

      this.baseWorkflowBaseUri = new URI(this.workflowBaseUrl);

      this.log.info("WORKFLOW Base URI: {}", this.baseWorkflowBaseUri);

    }

    public URI getSearchWorkflowUri() throws MalformedURLException {

      return this.baseWorkflowBaseUri.resolve(IflowRestPaths.WorkflowModule.SEARCH_WORKFLOW());
    }

    public URI getReadWorkflowListByIdentityListUri() throws MalformedURLException {

      return this.baseWorkflowBaseUri.resolve(IflowRestPaths.WorkflowModule.READ_WORKFLOWLIST_BY_IDENTITYLIST());
    }

    /*
     *
     *
     */

    public URI getReadInvoiceWorkflowUri(final String workflowIdentity) throws MalformedURLException {

      return this.baseWorkflowBaseUri.resolve(IflowRestPaths.WorkflowModule.READ_INVOICEWORKFLOW_BY_IDENTITY_URIBUILDER(workflowIdentity));
    }

    public URI getReadInvoiceWorkflowListByIdentityListUri() throws MalformedURLException {

      return this.baseWorkflowBaseUri.resolve(IflowRestPaths.WorkflowModule.READ_INVOICEWORKFLOWLIST_BY_IDENTITYLIST_URIBUILDER());
    }

    public URI getReadWorkflowTypeListUri(final String companyIdentity) throws MalformedURLException {

      return this.baseWorkflowBaseUri.resolve(IflowRestPaths.WorkflowModule.READ_WORKFLOWTYPELIST_BY_COMPANYID_URIBUILDER(companyIdentity));
    }

    public URI getCreateInvoiceWorkflowUri() throws MalformedURLException {

      return this.baseWorkflowBaseUri.resolve(IflowRestPaths.WorkflowModule.CREATE_INVOICEWORKFLOW());
    }

    public URI getSaveInvoiceWorkflowUri() throws MalformedURLException {

      return this.baseWorkflowBaseUri.resolve(IflowRestPaths.WorkflowModule.SAVE_INVOICEWORKFLOW());
    }

    public URI getValidateInvoiceWorkflowUri() throws MalformedURLException {

      return this.baseWorkflowBaseUri.resolve(IflowRestPaths.WorkflowModule.VALIDATE_INVOICEWORKFLOW());
    }

    /*
     *
     *
     *
     */

    public URI getReadSingleTaskWorkflowUri(final String workflowIdentity) throws MalformedURLException {

      return this.baseWorkflowBaseUri
          .resolve(IflowRestPaths.WorkflowModule.READ_SINGLETASKWORKFLOW_BY_IDENTITY_URIBUILDER(workflowIdentity));
    }

    public URI getCreateSingleTaskWorkflowUri() throws MalformedURLException {

      return this.baseWorkflowBaseUri.resolve(IflowRestPaths.WorkflowModule.CREATE_SINGLETASKWORKFLOW());
    }

    public URI getSaveSingleTaskWorkflowUri() throws MalformedURLException {

      return this.baseWorkflowBaseUri.resolve(IflowRestPaths.WorkflowModule.SAVE_SINGLETASKWORKFLOW());
    }

    public URI getValidateSingleTaskWorkflowUri() throws MalformedURLException {

      return this.baseWorkflowBaseUri.resolve(IflowRestPaths.WorkflowModule.VALIDATE_SINGLETASKWORKFLOW());
    }

    public URI getReadSingleTaskWorkflowListByIdentityListUri() throws MalformedURLException {

      return this.baseWorkflowBaseUri.resolve(IflowRestPaths.WorkflowModule.READ_SINGLETASKWORKFLOWLIST_BY_IDENTITYLIST_URIBUILDER());
    }

    /*
    *
    *
    *
    */

    public URI getReadTestThreeTaskWorkflowUri(final String workflowIdentity) throws MalformedURLException {

      return this.baseWorkflowBaseUri
          .resolve(IflowRestPaths.WorkflowModule.READ_TESTTHREETASKWORKFLOW_BY_IDENTITY_URIBUILDER(workflowIdentity));
    }

    public URI getCreateTestThreeTaskWorkflowUri() throws MalformedURLException {

      return this.baseWorkflowBaseUri.resolve(IflowRestPaths.WorkflowModule.CREATE_TESTTHREETASKWORKFLOW());
    }

    public URI getSaveTestThreeTaskWorkflowUri() throws MalformedURLException {

      return this.baseWorkflowBaseUri.resolve(IflowRestPaths.WorkflowModule.SAVE_TESTTHREETASKWORKFLOW());
    }

    public URI getValidateTestThreeTaskWorkflowUri() throws MalformedURLException {

      return this.baseWorkflowBaseUri.resolve(IflowRestPaths.WorkflowModule.VALIDATE_TESTTHREETASKWORKFLOW());
    }

    public URI getReadTestThreeTaskWorkflowListByIdentityListUri() throws MalformedURLException {

      return this.baseWorkflowBaseUri.resolve(IflowRestPaths.WorkflowModule.READ_TESTTHREETASKWORKFLOWLIST_BY_IDENTITYLIST_URIBUILDER());
    }
    /*
    *
    *
    *
    */

    public URI getReadWorkflowUri(final String workflowIdentity) throws MalformedURLException {

      return this.baseWorkflowBaseUri.resolve(IflowRestPaths.WorkflowModule.READ_WORKFLOW_BY_IDENTITY_URIBUILDER(workflowIdentity));
    }

    public URI getReadWorkflowListUri() throws MalformedURLException {

      return this.baseWorkflowBaseUri.resolve(IflowRestPaths.WorkflowModule.READ_WORKFLOWLIST_BY_IDENTITYLIST());
    }

    public URI getReadUserWorkflowMessageListUri(final String userIdentity) throws MalformedURLException {

      return this.baseWorkflowBaseUri.resolve(IflowRestPaths.WorkflowModule.READ_WORKFLOWMESSAGE_READ_BY_USER(userIdentity, 0));
    }

    public URI getReadWorkflowWorkflowMessageListUri(final String workflowIdentity) throws MalformedURLException {

      return this.baseWorkflowBaseUri.resolve(IflowRestPaths.WorkflowModule.READ_WORKFLOWMESSAGE_READ_BY_WORKFLOW(workflowIdentity));
    }

  }

  @Component
  public static class ProfileModuleAccessConfig {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${iflow.gui.urls.profile.base}")
    private String profileBaseUrl;

    private URI baseProfileBaseUri;

    @PostConstruct
    private void init() throws URISyntaxException {

      this.baseProfileBaseUri = new URI(this.profileBaseUrl);

      this.log.info("PROFILE Base URI: {}", this.baseProfileBaseUri);

    }

    public URI getReadTokenInfoUri() throws MalformedURLException {

      return this.baseProfileBaseUri.resolve(IflowRestPaths.ProfileModule.READ_PROFILE_TOKENINFO_URIBUILDER());
    }

    public URI getAuthenticationUri() throws MalformedURLException {

      return this.baseProfileBaseUri.resolve(IflowRestPaths.ProfileModule.AUTHENTICATE_AUTHENTICATION_URIBUILDER());
    }

    public URI getReadAuthenticationInfoUri() throws MalformedURLException {

      return this.baseProfileBaseUri.resolve(IflowRestPaths.ProfileModule.READ_PROFILE_AUTHENTOCATEDINFO_URIBUILDER());
    }

    public URI getReadCompanyUserListUri(final String companyIdentity) throws MalformedURLException {

      return this.baseProfileBaseUri.resolve(IflowRestPaths.ProfileModule.READ_USERLIST_BY_COMPANYID_URIBUILDER(companyIdentity));
    }

    public URI getReadUserUri(final String identity) throws MalformedURLException {

      return this.baseProfileBaseUri.resolve(IflowRestPaths.ProfileModule.READ_USER_BY_IDENTITY_URIBUILDER(identity));
    }

    public URI getSaveUserUri() throws MalformedURLException {

      return this.baseProfileBaseUri.resolve(IflowRestPaths.ProfileModule.SAVE_USER_URIBUILDER());
    }

    public URI getDeleteUserUri() throws MalformedURLException {

      return this.baseProfileBaseUri.resolve(IflowRestPaths.ProfileModule.DELETE_USER_URIBUILDER());
    }

    public URI getResetPasswordUserUri() throws MalformedURLException {

      return this.baseProfileBaseUri.resolve(IflowRestPaths.ProfileModule.RESETPASSWORD_USER_URIBUILDER());
    }

    public URI getDeleteUserAuthenticationUri() throws MalformedURLException {

      return this.baseProfileBaseUri.resolve(IflowRestPaths.ProfileModule.DELETE_USER_AUTHENTICATION_URIBUILDER());
    }

    public URI getReadCompanyUri(final String identity) throws MalformedURLException {

      return this.baseProfileBaseUri.resolve(IflowRestPaths.ProfileModule.READ_COMPANY_BY_ID_URIBUILDER(identity));
    }

    public URI getSaveCompanyUri() throws MalformedURLException {

      return this.baseProfileBaseUri.resolve(IflowRestPaths.ProfileModule.SAVE_COMPANY());
    }

    public URI getReadCompanyDepartmentListUri(final String companyIdentity) throws MalformedURLException {

      return this.baseProfileBaseUri.resolve(IflowRestPaths.ProfileModule.READ_DEPARTMENTLIST_BY_COMPANYID_URIBUILDER(companyIdentity));
    }

    public URI getSaveDepartmentUri() throws MalformedURLException {

      return this.baseProfileBaseUri.resolve(IflowRestPaths.ProfileModule.SAVE_DEPARTMENT_URIBUILDER());
    }

    public URI getDeleteDepartmentUri() throws MalformedURLException {

      return this.baseProfileBaseUri.resolve(IflowRestPaths.ProfileModule.DELETE_DEPARTMENT_URIBUILDER());
    }

    public URI getReadCompanyWorkflowTypeItemOcrSettingsUri(final String identity) throws MalformedURLException {

      return this.baseProfileBaseUri
          .resolve(IflowRestPaths.ProfileModule.READ_COMPANY_WORKFLOWTYPE_ITEMS_OCR_SETTINGS_BY_IDENTITY(identity));
    }

    public URI getSaveCompanyWorkflowTypeItemOcrSettingsUri() throws MalformedURLException {

      return this.baseProfileBaseUri
          .resolve(IflowRestPaths.ProfileModule.SAVE_COMPANY_WORKFLOWTYPE_ITEMS_OCR_SETTINGS());
    }

    public URI getDeleteCompanyWorkflowTypeItemOcrSettingsUri() throws MalformedURLException {

      return this.baseProfileBaseUri
          .resolve(IflowRestPaths.ProfileModule.DELETE_COMPANY_WORKFLOWTYPE_ITEMS_OCR_SETTINGS());
    }

  }

}
