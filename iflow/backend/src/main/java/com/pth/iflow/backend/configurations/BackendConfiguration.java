package com.pth.iflow.backend.configurations;

import java.net.MalformedURLException;
import java.net.URL;
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
public class BackendConfiguration {

  public static final String       NO_ACCESS_URL            = "/noaccess";
  public static final String       INVALID_TOKEN_URL        = "/invalidtoken";

  public static final List<String> NOAUTHENTICATED_URL_LIST = Arrays.asList(NO_ACCESS_URL, INVALID_TOKEN_URL);

  /**
   * configs regarding core
   */
  @Component
  public static class ModuleAccessConfig {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${iflow.profile.urls.workflow.base}")
    private String       workflowBaseUrl;

    @Value("${iflow.profile.urls.profile.base}")
    private String       profileBaseUrl;

    @PostConstruct
    private void init() {
      this.log.info("WORKFLOW Base URL: {}", this.workflowBaseUrl);
      this.log.info("PROFILE Base URL: {}", this.profileBaseUrl);

    }

    public URL generateWorkflowUrl(final String subUrl) throws MalformedURLException {
      String path = this.workflowBaseUrl + "/" + subUrl;
      path = path.replace("//", "/");
      path = path.replace("http:/", "http://");

      return new URL(path);
    }

    public URL generateProfileUrl(final String subUrl) throws MalformedURLException {
      String path = this.profileBaseUrl + "/" + subUrl;
      path = path.replace("//", "/");
      path = path.replace("http:/", "http://");

      return new URL(path);
    }

  }

}
