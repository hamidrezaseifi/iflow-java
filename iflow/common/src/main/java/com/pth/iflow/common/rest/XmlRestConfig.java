package com.pth.iflow.common.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import com.pth.iflow.common.edo.models.xml.CompanyEdo;
import com.pth.iflow.common.edo.models.xml.DepartmentEdo;
import com.pth.iflow.common.edo.models.xml.DepartmentGroupEdo;
import com.pth.iflow.common.edo.models.xml.UserEdo;
import com.pth.iflow.common.edo.models.xml.UserGroupEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowActionEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowFileEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowFileVersionEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowTypeEdo;
import com.pth.iflow.common.edo.models.xml.WorkflowTypeStepEdo;

/**
 * contains configs for XML Rest-Controller
 */
@Configuration
public class XmlRestConfig {

  private final Logger       log                            = LoggerFactory.getLogger(getClass());

  public static final String REQUEST_HEADER_IFLOW_CLIENT_ID = "IFLOW-CLIENT-ID";

  /**
   * needed so that jackson understands the JAXB Annotations.
   *
   * @return the module
   */
  @Bean
  public JaxbAnnotationModule enableJaxbForJackson() {
    this.log.info("JAXB Annotations enabled");
    final JaxbAnnotationModule jaxbAnnotationModule = new JaxbAnnotationModule();
    return jaxbAnnotationModule;
  }

  @Bean
  public MarshallingHttpMessageConverter marshallingMessageConverter() {
    return new MarshallingHttpMessageConverter(jaxb2Marshaller(), jaxb2Marshaller());
  }

  @Bean
  public Jaxb2Marshaller jaxb2Marshaller() {
    final Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

    marshaller.setClassesToBeBound(new Class[] { UserEdo.class, UserGroupEdo.class, CompanyEdo.class, DepartmentEdo.class,
        DepartmentGroupEdo.class, WorkflowEdo.class, WorkflowTypeEdo.class, WorkflowTypeStepEdo.class, WorkflowActionEdo.class,
        WorkflowFileEdo.class, WorkflowFileVersionEdo.class });

    // marshaller.setClassesToBeBound(new Class[] { WorkflowTypeStepEdo.class, });

    return marshaller;
  }

  @Lazy
  @Bean
  public RestTemplate jaxbRestTemplate(final MappingJackson2XmlHttpMessageConverter converter,
      @Value("${iflow.common.rest.api.security.client-id.internal}") final String securityHeaderValue,
      @Autowired final JaxbAnnotationModule module) {
    /*
     * BETTER: there is likely a more spring way of configuring the rest template to
     * use the JAXB stuff...| TM @ 21.07.2018
     */
    final RestTemplate restTemplate = new RestTemplate();
    converter.getObjectMapper().registerModule(enableJaxbForJackson());
    withXmlConverter(restTemplate, converter);

    restTemplate.getInterceptors().add((request, body, execution) -> {
      request.getHeaders().set(REQUEST_HEADER_IFLOW_CLIENT_ID, securityHeaderValue);
      return execution.execute(request, body);
    });

    return restTemplate;
  }

  private void withXmlConverter(final RestTemplate restTemplate, final MappingJackson2XmlHttpMessageConverter converter) {

    /*
     * BETTER: there is likely a more spring way of configuring the rest template to
     * use the JAXB stuff...| TM @ 21.07.2018
     */

    final JaxbAnnotationModule jaxbAnnotationModule = new JaxbAnnotationModule();

    final List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
    messageConverters.add(marshallingMessageConverter());

    for (int i = 0; i < messageConverters.size(); i++) {

      if (messageConverters.get(i) instanceof MappingJackson2XmlHttpMessageConverter) {
        ((MappingJackson2XmlHttpMessageConverter) messageConverters.get(i)).getObjectMapper().registerModule(jaxbAnnotationModule);
      }

      if (messageConverters.get(i).canRead(WorkflowEdo.class, MediaType.APPLICATION_XML)) {
        // need to replace the default MappingJackson2XmlHttpMessageConverter with the
        // one that understands JAXB annotations | CK2-153
        // messageConverters.set(i, converter);
        // return;
      }
    }

  }

}
