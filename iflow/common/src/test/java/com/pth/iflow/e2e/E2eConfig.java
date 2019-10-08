package com.pth.iflow.e2e;

import org.springframework.beans.BeansException;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.support.TestPropertySourceUtils;
import com.pth.iflow.common.rest.XmlRestConfig;

@TestConfiguration
@AutoConfigureWebMvc
@Import(XmlRestConfig.class)
public class E2eConfig implements ApplicationContextAware {

  /**
   * WORKAROUND: goal: i wanted to centralize the config of these default properties <br>
   * but neither of these worked:
   * <ul>
   * <li>due to having no Spring App auto-loading of app-props isnt happening
   * <li>{@link TestPropertySource} is not working on a config class
   * </ul>
   *
   * | TM @ 08.03.2019
   */
  @Override
  public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
    TestPropertySourceUtils.addInlinedPropertiesToEnvironment((ConfigurableApplicationContext) applicationContext,
                                                              XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID + ": iflow-inner-module",
                                                              "iflow.common.rest.api.security.client-id.internal: iflow-inner-module");

  }

}
