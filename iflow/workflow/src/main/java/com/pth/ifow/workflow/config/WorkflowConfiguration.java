package com.pth.ifow.workflow.config;

import java.net.MalformedURLException;
import java.net.URL;

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

    public URL generateCoreSunUrlUrl(final String subUrl) throws MalformedURLException {
      String path = coreBaseUrl + "/" + subUrl;
      path = path.replace("//", "/");
      path = path.replace("http:/", "http://");

      return new URL(path);
    }

    public URL generateProfileSunUrlUrl(final String subUrl) throws MalformedURLException {
      String path = profileBaseUrl + "/" + subUrl;
      path = path.replace("//", "/");
      path = path.replace("http:/", "http://");

      return new URL(path);
    }

  }

}
