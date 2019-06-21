package com.pth.iflow.core.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * a class to collect gui configuration from property file
 *
 * @author rezasei
 *
 */
@Component
public class CoreConfiguration {

  public static final String NO_ACCESS_URL = "/noaccess";
  public static final String INVALID_TOKEN_URL = "/invalidtoken";

  public static final List<String> NOAUTHENTICATED_URL_LIST = Arrays.asList(NO_ACCESS_URL, INVALID_TOKEN_URL);

}
