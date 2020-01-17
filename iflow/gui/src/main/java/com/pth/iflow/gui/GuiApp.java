package com.pth.iflow.gui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.pth.iflow.common.controllers.helper.IflowSpringProfiles;
import com.pth.iflow.common.rest.XmlRestConfig;

@SpringBootApplication(scanBasePackageClasses = { IflowSpringProfiles.class, GuiApp.class })
//@Configuration
//@EnableAutoConfiguration(exclude = WebMvcAutoConfiguration.class)
public class GuiApp implements ApplicationListener<ApplicationReadyEvent> {

  private static final Logger logger = LoggerFactory.getLogger(GuiApp.class);

  @Configuration
  @Import(XmlRestConfig.class)
  static class Config {

  }

  public static void main(final String[] args) {

    GuiApp.logger.info("Starting iFlow Backend application...");
    final SpringApplication springApplication = new SpringApplication(GuiApp.class);
    springApplication.setAdditionalProfiles(IflowSpringProfiles.GUI_APP);
    springApplication.run(args);

  }

  @Override
  public void onApplicationEvent(final ApplicationReadyEvent event) {

  }

}
