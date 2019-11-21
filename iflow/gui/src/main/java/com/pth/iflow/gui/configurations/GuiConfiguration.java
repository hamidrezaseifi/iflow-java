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

  public static final String NO_ACCESS_URL     = "/noaccess";
  public static final String INVALID_TOKEN_URL = "/invalidtoken";

  public static final List<String> NOAUTHENTICATED_URL_LIST = Arrays.asList(NO_ACCESS_URL, INVALID_TOKEN_URL);

  @Component
  public static class WorkflowModuleAccessConfig {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${iflow.profile.urls.workflow.base}")
    private String workflowBaseUrl;

    private URI baseWorkflowBaseUri;

    @PostConstruct
    private void init() throws URISyntaxException {
      this.baseWorkflowBaseUri = new URI(this.workflowBaseUrl);

      this.log.info("WORKFLOW Base URI: {}", this.baseWorkflowBaseUri);

    }

    public URI getReadInvoiceWorkflowUri(final String workflowIdentity) throws MalformedURLException {
      return this.baseWorkflowBaseUri.resolve(IflowRestPaths.WorkflowModule.READ_INVOICEWORKFLOW_BY_IDENTITY_URIBUILDER(workflowIdentity));
    }

    public URI getReadWorkflowTypeListUri(final String companyIdentity) throws MalformedURLException {
      return this.baseWorkflowBaseUri
                                     .resolve(IflowRestPaths.WorkflowModule.READ_WORKFLOWTYPELIST_BY_COMPANYID_URIBUILDER(companyIdentity));
    }

    public URI getCreateInvoiceWorkflowUri() throws MalformedURLException {
      return this.baseWorkflowBaseUri.resolve(IflowRestPaths.WorkflowModule.CREATE_INVOICEWORKFLOW());
    }

    public URI getSaveInvoiceWorkflowUri() throws MalformedURLException {
      return this.baseWorkflowBaseUri.resolve(IflowRestPaths.WorkflowModule.SAVE_INVOICEWORKFLOW());
    }

    public URI getSearchInvoiceWorkflowUri() throws MalformedURLException {
      return this.baseWorkflowBaseUri.resolve(IflowRestPaths.WorkflowModule.SEARCH_INVOICEWORKFLOW());
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
      return this.baseWorkflowBaseUri.resolve(IflowRestPaths.WorkflowModule.READ_SINGLETASKWORKFLOW_BY_IDENTITY_URIBUILDER(workflowIdentity));
    }

    public URI getCreateSingleTaskWorkflowUri() throws MalformedURLException {
      return this.baseWorkflowBaseUri.resolve(IflowRestPaths.WorkflowModule.CREATE_SINGLETASKWORKFLOW());
    }

    public URI getSaveSingleTaskWorkflowUri() throws MalformedURLException {
      return this.baseWorkflowBaseUri.resolve(IflowRestPaths.WorkflowModule.SAVE_SINGLETASKWORKFLOW());
    }

    public URI getSearchSingleTaskWorkflowUri() throws MalformedURLException {
      return this.baseWorkflowBaseUri.resolve(IflowRestPaths.WorkflowModule.SEARCH_SINGLETASKWORKFLOW());
    }

    public URI getValidateSingleTaskWorkflowUri() throws MalformedURLException {
      return this.baseWorkflowBaseUri.resolve(IflowRestPaths.WorkflowModule.VALIDATE_SINGLETASKWORKFLOW());
    }

    /*
     *
     *
     *
     */

    public URI getReadTestThreeTaskWorkflowUri(final String workflowIdentity) throws MalformedURLException {
      return this.baseWorkflowBaseUri.resolve(IflowRestPaths.WorkflowModule.READ_TESTTHREETASKWORKFLOW_BY_IDENTITY_URIBUILDER(workflowIdentity));
    }

    public URI getCreateTestThreeTaskWorkflowUri() throws MalformedURLException {
      return this.baseWorkflowBaseUri.resolve(IflowRestPaths.WorkflowModule.CREATE_TESTTHREETASKWORKFLOW());
    }

    public URI getSaveTestThreeTaskWorkflowUri() throws MalformedURLException {
      return this.baseWorkflowBaseUri.resolve(IflowRestPaths.WorkflowModule.SAVE_TESTTHREETASKWORKFLOW());
    }

    public URI getSearchTestThreeTaskWorkflowUri() throws MalformedURLException {
      return this.baseWorkflowBaseUri.resolve(IflowRestPaths.WorkflowModule.SEARCH_TESTTHREETASKWORKFLOW());
    }

    public URI getValidateTestThreeTaskWorkflowUri() throws MalformedURLException {
      return this.baseWorkflowBaseUri.resolve(IflowRestPaths.WorkflowModule.VALIDATE_TESTTHREETASKWORKFLOW());
    }

  }

  @Component
  public static class ProfileModuleAccessConfig {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${iflow.profile.urls.profile.base}")
    private String profileBaseUrl;

    private URI baseProfileBaseUri;

    @PostConstruct
    private void init() throws URISyntaxException {
      this.baseProfileBaseUri = new URI(this.profileBaseUrl);

      this.log.info("PROFILE Base URI: {}", this.baseProfileBaseUri);

    }

    public URI getReadTokenInfoUri() throws MalformedURLException {
      return this.baseProfileBaseUri.resolve(IflowRestPaths.ProfileModule.READ_PROFILE_TOKENINFO());
    }

    public URI getAuthenticationUri() throws MalformedURLException {
      return this.baseProfileBaseUri.resolve(IflowRestPaths.ProfileModule.AUTHENTICATE_AUTHENTICATION());
    }

    public URI getReadAuthenticationInfoUri() throws MalformedURLException {
      return this.baseProfileBaseUri.resolve(IflowRestPaths.ProfileModule.READ_PROFILE_AUTHENTOCATEDINFO());
    }

    public URI getReadCompanyUserListUri(final String companyIdentity) throws MalformedURLException {
      return this.baseProfileBaseUri.resolve(IflowRestPaths.ProfileModule.READ_USERLIST_BY_COMPANYID_URIBUILDER(companyIdentity));
    }

    public URI getReadUserWorkflowMessageListUri(final String companyIdentity, final String userId) throws MalformedURLException {
      return this.baseProfileBaseUri
                                    .resolve(IflowRestPaths.ProfileModule.READ_CACHDATA_USER_WORKFLOWMESSAGELIST(companyIdentity, userId));
    }

    public URI getCalUserWorkflowMessageResetUri(final String companyIdentity, final String userId) throws MalformedURLException {
      return this.baseProfileBaseUri.resolve(IflowRestPaths.ProfileModule.CAL_CACHDATA_USER_DATARESET(companyIdentity, userId));
    }

  }

}
