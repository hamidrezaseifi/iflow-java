package com.pth.iflow.workflow;

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

@SpringBootApplication(scanBasePackageClasses = { IflowSpringProfiles.class, WorkflowApp.class })
public class WorkflowApp implements ApplicationListener<ApplicationReadyEvent> {

  private static final Logger logger = LoggerFactory.getLogger(WorkflowApp.class);

  @Configuration
  @Import(XmlRestConfig.class)
  static class Config {

  }

  public static void main(final String[] args) {

    WorkflowApp.logger.info("Starting iFlow Workflow application...");
    final SpringApplication springApplication = new SpringApplication(WorkflowApp.class);
    springApplication.setAdditionalProfiles(IflowSpringProfiles.SERVICE_APP);
    springApplication.run(args);

  }

  @Override
  public void onApplicationEvent(final ApplicationReadyEvent event) {

  }

}
