package com.pth.ifow.profile.config;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

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
public class ProfileConfiguration {

  /**
   * configs regarding core
   */
  @Component
  public static class CoreAccessConfig {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Value("${iflow.profile.urls.core.base}")
    private String coreBaseUrl;

    @PostConstruct
    private void init() {
      log.info("CORE Base URL: {}", coreBaseUrl);

    }

    /**
     * @return the allProjectReadAllPath
     * @throws MalformedURLException
     * @throws URISyntaxException
     */
    public URL getReadUserByEmailUrl() throws MalformedURLException {
      String path = coreBaseUrl + "/" + IflowRestPaths.CoreModul.USER_READ_BY_EMAIL;
      path = path.replace("//", "/");
      path = path.replace("http:/", "http://");

      return new URL(path);
    }

    /**
     * @return the allProjectReadAllPath
     * @throws MalformedURLException
     * @throws URISyntaxException
     */
    public URL getReadCompanyByIdUrl() throws MalformedURLException {
      String path = coreBaseUrl + "/" + IflowRestPaths.CoreModul.COMPANY_READ_BY_ID;
      path = path.replace("//", "/");
      path = path.replace("http:/", "http://");

      return new URL(path);
    }

  }

}
