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
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import com.pth.iflow.common.edo.models.AssignItemEdo;
import com.pth.iflow.common.edo.models.AuthenticatedProfileRequestEdo;
import com.pth.iflow.common.edo.models.CompanyEdo;
import com.pth.iflow.common.edo.models.CompanyProfileEdo;
import com.pth.iflow.common.edo.models.DepartmentEdo;
import com.pth.iflow.common.edo.models.DepartmentGroupEdo;
import com.pth.iflow.common.edo.models.DepartmentGroupListEdo;
import com.pth.iflow.common.edo.models.DepartmentListEdo;
import com.pth.iflow.common.edo.models.IdentityListEdo;
import com.pth.iflow.common.edo.models.InvoiceWorkflowEdo;
import com.pth.iflow.common.edo.models.InvoiceWorkflowListEdo;
import com.pth.iflow.common.edo.models.InvoiceWorkflowSaveRequestEdo;
import com.pth.iflow.common.edo.models.ProfileResponseEdo;
import com.pth.iflow.common.edo.models.TokenProfileRequestEdo;
import com.pth.iflow.common.edo.models.UserAuthenticationRequestEdo;
import com.pth.iflow.common.edo.models.UserAuthenticationResponseEdo;
import com.pth.iflow.common.edo.models.UserEdo;
import com.pth.iflow.common.edo.models.UserGroupEdo;
import com.pth.iflow.common.edo.models.UserGroupListEdo;
import com.pth.iflow.common.edo.models.UserListEdo;
import com.pth.iflow.common.edo.models.WorkflowActionEdo;
import com.pth.iflow.common.edo.models.WorkflowActionListEdo;
import com.pth.iflow.common.edo.models.WorkflowEdo;
import com.pth.iflow.common.edo.models.WorkflowFileEdo;
import com.pth.iflow.common.edo.models.WorkflowFileListEdo;
import com.pth.iflow.common.edo.models.WorkflowFileVersionEdo;
import com.pth.iflow.common.edo.models.WorkflowListEdo;
import com.pth.iflow.common.edo.models.WorkflowMessageEdo;
import com.pth.iflow.common.edo.models.WorkflowMessageListEdo;
import com.pth.iflow.common.edo.models.WorkflowSearchFilterEdo;
import com.pth.iflow.common.edo.models.WorkflowTypeEdo;
import com.pth.iflow.common.edo.models.WorkflowTypeListEdo;
import com.pth.iflow.common.edo.models.WorkflowTypeStepEdo;
import com.pth.iflow.common.edo.models.WorkflowTypeStepListEdo;

/**
 * contains configs for XML Rest-Controller
 */
@Configuration
public class XmlRestConfig {

  private final Logger log = LoggerFactory.getLogger(this.getClass());

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
    return new MarshallingHttpMessageConverter(this.jaxb2Marshaller(), this.jaxb2Marshaller());
  }

  @Bean
  public Jaxb2Marshaller jaxb2Marshaller() {
    final Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

    marshaller.setClassesToBeBound(new Class[] { AssignItemEdo.class,
                                                 AuthenticatedProfileRequestEdo.class,
                                                 CompanyEdo.class,
                                                 CompanyProfileEdo.class,
                                                 DepartmentEdo.class,
                                                 DepartmentGroupEdo.class,
                                                 DepartmentGroupListEdo.class,
                                                 DepartmentListEdo.class,
                                                 IdentityListEdo.class,
                                                 InvoiceWorkflowEdo.class,
                                                 InvoiceWorkflowListEdo.class,
                                                 InvoiceWorkflowSaveRequestEdo.class,
                                                 ProfileResponseEdo.class,
                                                 TokenProfileRequestEdo.class,
                                                 UserAuthenticationRequestEdo.class,
                                                 UserAuthenticationResponseEdo.class,
                                                 UserEdo.class,
                                                 UserGroupEdo.class,
                                                 UserGroupListEdo.class,
                                                 UserListEdo.class,
                                                 WorkflowActionEdo.class,
                                                 WorkflowActionListEdo.class,
                                                 WorkflowEdo.class,
                                                 WorkflowFileEdo.class,
                                                 WorkflowFileListEdo.class,
                                                 WorkflowFileVersionEdo.class,
                                                 WorkflowListEdo.class,
                                                 WorkflowMessageEdo.class,
                                                 WorkflowMessageListEdo.class,
                                                 WorkflowSearchFilterEdo.class,
                                                 WorkflowTypeEdo.class,
                                                 WorkflowTypeListEdo.class,
                                                 WorkflowTypeStepEdo.class,
                                                 WorkflowTypeStepListEdo.class });

    // marshaller.setClassesToBeBound(new Class[] { WorkflowTypeStepEdo.class, });

    return marshaller;
  }

  @Lazy
  @Bean
  public RestTemplate jaxbRestTemplate(final MappingJackson2XmlHttpMessageConverter converter, @Value("${iflow.common.rest.api.security.client-id.internal}") final String securityHeaderValue, @Autowired final JaxbAnnotationModule module) {
    /*
     * BETTER: there is likely a more spring way of configuring the rest template to use the JAXB stuff...| TM @ 21.07.2018
     */
    final RestTemplate restTemplate = new RestTemplate();
    converter.getObjectMapper().registerModule(this.enableJaxbForJackson());
    this.withXmlConverter(restTemplate, converter);

    restTemplate.getInterceptors().add((request, body, execution) -> {
      request.getHeaders().set(REQUEST_HEADER_IFLOW_CLIENT_ID, securityHeaderValue);
      return execution.execute(request, body);
    });

    return restTemplate;
  }

  private void withXmlConverter(final RestTemplate restTemplate, final MappingJackson2XmlHttpMessageConverter converter) {

    /*
     * BETTER: there is likely a more spring way of configuring the rest template to use the JAXB stuff...| TM @ 21.07.2018
     */

    final JaxbAnnotationModule jaxbAnnotationModule = new JaxbAnnotationModule();

    final List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
    messageConverters.add(this.marshallingMessageConverter());

    for (int i = 0; i < messageConverters.size(); i++) {

      if (messageConverters.get(i) instanceof MappingJackson2XmlHttpMessageConverter) {
        final MappingJackson2XmlHttpMessageConverter xmlConverter = (MappingJackson2XmlHttpMessageConverter) messageConverters.get(i);
        final XmlMapper xmlMapper = (XmlMapper) xmlConverter.getObjectMapper();

        xmlMapper.registerModule(jaxbAnnotationModule);
        xmlMapper.disable(FromXmlParser.Feature.EMPTY_ELEMENT_AS_NULL);

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
