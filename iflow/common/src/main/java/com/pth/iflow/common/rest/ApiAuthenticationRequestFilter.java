package com.pth.iflow.common.rest;

import java.io.IOException;
import java.util.Arrays;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.pth.iflow.common.controllers.helper.IflowSpringProfiles;
import com.pth.iflow.common.exceptions.IflowConfigurationException;
import com.pth.iflow.common.utils.DataLoggingUtils;

/**
 * simple impl. to control access to all our API Endpoints
 *
 * @BETTER a full authentication with client-id + secret would be better but is not needed for now.<br>
 *         on how to do this, see
 *         https://www.future-processing.pl/blog/exploring-spring-boot-and-spring-security-custom-token-based-authentication-of-rest-services-with-spring-security-and-pinch-of-spring-java-configuration-and-spring-integration-testing/
 *
 * @activation this bean/filter is active by default to make it as hard as possible to deactivate it by accident if the full application is
 *             running. To deactivate it, set the app property {@code mdm.common.rest.api.security.enabled} to the value 'false'.
 */
@Component
@Profile({ IflowSpringProfiles.SERVICE_APP })
@ConditionalOnProperty(name = "mdm.common.rest.api.security.enabled", matchIfMissing = true)
public class ApiAuthenticationRequestFilter extends OncePerRequestFilter /*
                                                                          * extending from this out of pure convenience, so i dont have to
                                                                          * do so much copy paste of code
                                                                          */ {

  private final Logger   log = LoggerFactory.getLogger(getClass());
  private final String[] allowedClientIds;
  private final String[] excludedEndpointPrefixes;

  /**
   * Instantiates a new api authentication request filter.
   *
   * @param allowedClientIds the allowed client ids
   * @param excludedEndpointPrefixes endpoint prefixes (w/o server and protocol) for which no client-id is needed, hence these are publicly
   *          available. Needed eg. for health check
   */
  @Autowired
  public ApiAuthenticationRequestFilter(@Value("${mdm.common.rest.api.security.allowed-client-ids:}") final String[] allowedClientIds,
                                        @Value("${mdm.common.rest.api.security.excluded-endpoint-prefixes:}") final String[] excludedEndpointPrefixes) {
    this.allowedClientIds = allowedClientIds;
    this.excludedEndpointPrefixes = excludedEndpointPrefixes;

    if (ArrayUtils.isEmpty(allowedClientIds)) {
      throw new IflowConfigurationException("No %s are configured, hence no body will be able to access any REST API.",
                                            "${mdm.common.rest.api.security.allowed-client-ids}");
    }
    else {
      log.info("MDM API Access: known mdm-client-ids: {}", DataLoggingUtils.getOrMask(StringUtils.join(allowedClientIds, ",")));
    }
    for (final String path : excludedEndpointPrefixes) {
      log.info("MDM API Access: excluded endpoint from authorization: {}", path);
    }
  }

  @Override
  protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response, final FilterChain filterChain) throws ServletException, IOException {

    final boolean exludeEndpointFromAuth = Arrays.stream(excludedEndpointPrefixes)
                                                 .anyMatch(request.getRequestURI()::startsWith);
    if (exludeEndpointFromAuth || isClientIdAuthorized(request)) {
      filterChain.doFilter(request, response);
    }
    else {
      response.setStatus(HttpStatus.FORBIDDEN.value());
    }

  }

  /**
   * @param request
   * @return
   */
  private boolean isClientIdAuthorized(final HttpServletRequest request) {
    final String clientId = request.getHeader(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID);
    final boolean contains = ArrayUtils.contains(allowedClientIds, clientId);
    if (!contains) {
      log.debug("MDM API Access Denied: unknown MDM-CLIENT-ID: {} from RemoteIP: {} / X-Forwarded-For: {}, endpoint: {}",
                clientId,
                request.getRemoteAddr(),
                request.getHeader("X-Forwarded-For"),
                request.getRequestURI());
    }

    return contains;
  }
}
