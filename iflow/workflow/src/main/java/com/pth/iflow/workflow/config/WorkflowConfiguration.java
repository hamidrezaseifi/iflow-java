package com.pth.iflow.workflow.config;

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

    @PostConstruct
    private void init() {
      log.info("CORE Base URL: {}", coreBaseUrl);
      log.info("PROFILE Base URL: {}", profileBaseUrl);

    }

    public URL generateCoreUrl(final String subUrl) throws MalformedURLException {
      String path = coreBaseUrl + "/" + subUrl;
      path = path.replace("//", "/");
      path = path.replace("http:/", "http://");

      return new URL(path);
    }

    public URL generateProfileUrl(final String subUrl) throws MalformedURLException {
      String path = profileBaseUrl + "/" + subUrl;
      path = path.replace("//", "/");
      path = path.replace("http:/", "http://");

      return new URL(path);
    }

  }

}
