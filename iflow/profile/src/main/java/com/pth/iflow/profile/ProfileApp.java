package com.pth.iflow.profile;

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

@SpringBootApplication(scanBasePackageClasses = { IflowSpringProfiles.class, ProfileApp.class })
public class ProfileApp implements ApplicationListener<ApplicationReadyEvent> {

  private static final Logger logger = LoggerFactory.getLogger(ProfileApp.class);

  @Configuration
  @Import(XmlRestConfig.class)
  static class Config {

  }

  public static void main(final String[] args) {

    ProfileApp.logger.info("Starting iFlow Profile application...");
    final SpringApplication springApplication = new SpringApplication(ProfileApp.class);
    springApplication.setAdditionalProfiles(IflowSpringProfiles.SERVICE_APP);
    springApplication.run(args);

  }

  @Override
  public void onApplicationEvent(final ApplicationReadyEvent event) {

  }

}
