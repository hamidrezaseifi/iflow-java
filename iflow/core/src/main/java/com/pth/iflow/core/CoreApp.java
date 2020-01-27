package com.pth.iflow.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.pth.iflow.common.controllers.helper.IflowSpringProfiles;
import com.pth.iflow.common.rest.XmlRestConfig;

@SpringBootApplication(
                       scanBasePackageClasses = { IflowSpringProfiles.class, CoreApp.class }, exclude = { DataSourceAutoConfiguration.class,
                           JpaRepositoriesAutoConfiguration.class, HibernateJpaAutoConfiguration.class }
)
public class CoreApp implements ApplicationListener<ApplicationReadyEvent> {

  private static final Logger logger = LoggerFactory.getLogger(CoreApp.class);

  @Configuration
  @Import(XmlRestConfig.class)
  static class Config {

  }

  public static void main(final String[] args) {

    CoreApp.logger.info("Starting iFlow Core application...");
    final SpringApplication springApplication = new SpringApplication(CoreApp.class);
    springApplication.setAdditionalProfiles(IflowSpringProfiles.SERVICE_APP);
    springApplication.run(args);

  }

  @Override
  public void onApplicationEvent(final ApplicationReadyEvent event) {

  }

}
