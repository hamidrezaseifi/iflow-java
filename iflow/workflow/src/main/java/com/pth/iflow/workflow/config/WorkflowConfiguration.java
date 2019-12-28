package com.pth.iflow.workflow.config;

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

/**
 * a class to collect gui configuration from property file
 *
 * @author rezasei
 *
 */
@Component
public class WorkflowConfiguration {

  public static final String NO_ACCESS_URL = "/noaccess";
  public static final String INVALID_TOKEN_URL = "/invalidtoken";

  public static final List<String> NOAUTHENTICATED_URL_LIST = Arrays.asList(NO_ACCESS_URL, INVALID_TOKEN_URL);

  /**
   * configs regarding core
   */
  @Component
  public static class ModuleAccessConfig {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Value("${iflow.profile.urls.core.base}")
    private String coreBaseUrl;

    @Value("${iflow.profile.urls.profile.base}")
    private String profileBaseUrl;

    @Value("${iflow.profile.urls.gui.base}")
    private String guiBaseUrl;

    private URI baseCoreBaseUri;

    private URI baseProfileBaseUri;

    private URI baseGuiBaseUri;

    @PostConstruct
    private void init() throws URISyntaxException {

      this.baseCoreBaseUri = new URI(this.coreBaseUrl);
      this.baseProfileBaseUri = new URI(this.profileBaseUrl);
      this.baseGuiBaseUri = new URI(this.guiBaseUrl);

      log.info("CORE Base URL: {}", coreBaseUrl);
      log.info("PROFILE Base URL: {}", profileBaseUrl);

    }

    public URI generateCoreUrl(final URI subUrl) throws MalformedURLException {

      return this.baseCoreBaseUri.resolve(subUrl);
    }

    public URI generateProfileUrl(final URI subUrl) throws MalformedURLException {

      return this.baseProfileBaseUri.resolve(subUrl);
    }

    public URI generateGuieUrl(final URI subUrl) throws MalformedURLException {

      return this.baseGuiBaseUri.resolve(subUrl);
    }

  }

}
