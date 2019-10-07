package com.pth.iflow.common.controllers.helper;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.pth.iflow.common.exceptions.IflowConfigurationException;
import com.pth.iflow.common.exceptions.IflowHealthException;

/**
 * generic controller to provide an endpoint returning the health of a module
 */
@RestController
@FullAppConfig
public class HealthController {

  private final Logger log = LoggerFactory.getLogger(getClass());

  private static final String SETTING_MDM_COMMON_HEALTHCECK_URIS = "${mdm.common.health-check.uris}";
  private final RestTemplate  restTemplate;

  /**
   * The uris that are used to check the health of this service incl. depending services. To facilitate custom checks implement an own
   * handler in the module and add that endpoint to the list here.
   * <p>
   * It is possible to have an empty array here. This just verifies that the module itself is up and running.
   */
  private final URI[] uris;

  @Autowired
  public HealthController(final RestTemplate restTemplate, @Value(SETTING_MDM_COMMON_HEALTHCECK_URIS) final String[] healthCheckUris) {
    super();
    this.restTemplate = restTemplate;

    uris = initUris(healthCheckUris);

  }

  /**
   * @param healthCheckUris
   * @return
   */
  private URI[] initUris(final String[] healthCheckUris) {
    final URI[] uris = new URI[healthCheckUris.length];
    final ArrayList<String> invalidUris = new ArrayList<>();
    for (int i = 0; i < healthCheckUris.length; i++) {
      final String uri = healthCheckUris[i];
      try {
        log.info("Registering health check URI: {}", uri);
        uris[i] = new URI(uri);
      }
      catch (final URISyntaxException e) {
        invalidUris.add(uri);
      }
    }
    if (invalidUris.size() > 0) {
      throw new IflowConfigurationException("Configured health check URIs are invalid: %s. Check the setting: %s",
                                            StringUtils.join(invalidUris, ", "),
                                            SETTING_MDM_COMMON_HEALTHCECK_URIS);
    }

    return uris;
  }

  @GetMapping(path = "/mdm/common/admin/health", produces = MediaType.APPLICATION_XML_VALUE)
  public void getHealth() throws IflowHealthException {

    for (final URI uri : uris) {
      try {
        restTemplate.getForObject(uri, Void.class);
      }
      catch (final Exception e) {
        throw new IflowHealthException("Failure while getting health from dependant service: " + uri, e);
      }
    }
  }

}
