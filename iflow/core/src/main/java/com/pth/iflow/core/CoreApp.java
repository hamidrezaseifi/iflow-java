package com.pth.iflow.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.pth.iflow.common.rest.XmlRestConfig;
import com.pth.iflow.core.model.Company;

@SpringBootApplication
public class CoreApp implements ApplicationListener<ApplicationReadyEvent> {
  
  private static final Logger logger = LoggerFactory.getLogger(CoreApp.class);
  
  @Configuration
  @Import(XmlRestConfig.class)
  static class Config {
    
  }
  
  public static void main(final String[] args) {

    final String modelId = Company.generateNextModelId("000000000006zzz");
    modelId.trim();

    CoreApp.logger.info("Starting iFlow Core application...");
    final SpringApplication springApplication = new SpringApplication(CoreApp.class);
    springApplication.run(args);

  }
  
  @Override
  public void onApplicationEvent(final ApplicationReadyEvent event) {
    
  }
  
}
