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

  /**
   * configs regarding core
   */
  @Component
  public static class ModuleAccessConfig {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${iflow.profile.urls.workflow.base}")
    private String workflowBaseUrl;

    @Value("${iflow.profile.urls.profile.base}")
    private String profileBaseUrl;

    private URI baseWorkflowBaseUri;

    private URI baseProfileBaseUri;

    @PostConstruct
    private void init() throws URISyntaxException {
      this.baseWorkflowBaseUri = new URI(this.workflowBaseUrl);
      this.baseProfileBaseUri = new URI(this.profileBaseUrl);

      this.log.info("WORKFLOW Base URI: {}", this.baseWorkflowBaseUri);
      this.log.info("PROFILE Base URI: {}", this.baseProfileBaseUri);

    }

    public URI getReadTokenInfoUri() throws MalformedURLException {
      return this.baseProfileBaseUri.resolve(IflowRestPaths.ProfileModule.PROFILE_READ_TOKENINFO);
    }

    public URI getAuthenticationUri() throws MalformedURLException {
      return this.baseProfileBaseUri.resolve(IflowRestPaths.ProfileModule.AUTHENTICATION_AUTHENTICATE);
    }

    public URI getReadAuthenticationInfoUri() throws MalformedURLException {
      return this.baseProfileBaseUri.resolve(IflowRestPaths.ProfileModule.PROFILE_READ_AUTHENTOCATEDINFO);
    }

    public URI getReadCompanyUserListUri(final Long companyId) throws MalformedURLException {
      return this.baseProfileBaseUri.resolve(IflowRestPaths.ProfileModule.READ_USERLIST_BY_COMPANYID_URIBUILDER(companyId));
    }

    public URI getReadWorkflowUri(final Long id) throws MalformedURLException {
      return this.baseWorkflowBaseUri.resolve(IflowRestPaths.WorkflowModule.READ_WORKFLOW_BY_ID_URIBUILDER(id));
    }

    public URI getReadWorkflowTypeListUri(final Long companyId) throws MalformedURLException {
      return this.baseWorkflowBaseUri.resolve(IflowRestPaths.WorkflowModule.READ_WORKFLOWTYPELIST_BY_COMPANYID_URIBUILDER(companyId));
    }

    public URI getCreateWorkflowUri() throws MalformedURLException {
      return this.baseWorkflowBaseUri.resolve(IflowRestPaths.WorkflowModule.WORKFLOW_CREATE);
    }

    public URI getSearchWorkflowUri() throws MalformedURLException {
      return this.baseWorkflowBaseUri.resolve(IflowRestPaths.WorkflowModule.WORKFLOW_SEARCH);
    }

  }

}
