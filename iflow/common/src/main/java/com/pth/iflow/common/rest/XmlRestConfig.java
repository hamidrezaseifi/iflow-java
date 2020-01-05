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
import com.pth.iflow.common.models.edo.AssignItemEdo;
import com.pth.iflow.common.models.edo.AuthenticatedProfileRequestEdo;
import com.pth.iflow.common.models.edo.CompanyEdo;
import com.pth.iflow.common.models.edo.CompanyProfileEdo;
import com.pth.iflow.common.models.edo.DepartmentEdo;
import com.pth.iflow.common.models.edo.DepartmentGroupEdo;
import com.pth.iflow.common.models.edo.DepartmentGroupListEdo;
import com.pth.iflow.common.models.edo.DepartmentListEdo;
import com.pth.iflow.common.models.edo.IdentityListEdo;
import com.pth.iflow.common.models.edo.ProfileResponseEdo;
import com.pth.iflow.common.models.edo.TokenProfileRequestEdo;
import com.pth.iflow.common.models.edo.UserAuthenticationRequestEdo;
import com.pth.iflow.common.models.edo.UserAuthenticationResponseEdo;
import com.pth.iflow.common.models.edo.UserEdo;
import com.pth.iflow.common.models.edo.UserGroupEdo;
import com.pth.iflow.common.models.edo.UserGroupListEdo;
import com.pth.iflow.common.models.edo.UserListEdo;
import com.pth.iflow.common.models.edo.WorkflowActionEdo;
import com.pth.iflow.common.models.edo.WorkflowActionListEdo;
import com.pth.iflow.common.models.edo.WorkflowFileEdo;
import com.pth.iflow.common.models.edo.WorkflowFileListEdo;
import com.pth.iflow.common.models.edo.WorkflowFileVersionEdo;
import com.pth.iflow.common.models.edo.WorkflowMessageEdo;
import com.pth.iflow.common.models.edo.WorkflowMessageListEdo;
import com.pth.iflow.common.models.edo.WorkflowSearchFilterEdo;
import com.pth.iflow.common.models.edo.WorkflowTypeEdo;
import com.pth.iflow.common.models.edo.WorkflowTypeListEdo;
import com.pth.iflow.common.models.edo.WorkflowTypeStepEdo;
import com.pth.iflow.common.models.edo.WorkflowTypeStepListEdo;
import com.pth.iflow.common.models.edo.workflow.invoice.InvoiceWorkflowEdo;
import com.pth.iflow.common.models.edo.workflow.invoice.InvoiceWorkflowListEdo;
import com.pth.iflow.common.models.edo.workflow.invoice.InvoiceWorkflowSaveRequestEdo;
import com.pth.iflow.common.models.edo.workflow.singletask.SingleTaskWorkflowEdo;
import com.pth.iflow.common.models.edo.workflow.singletask.SingleTaskWorkflowListEdo;
import com.pth.iflow.common.models.edo.workflow.singletask.SingleTaskWorkflowSaveRequestEdo;
import com.pth.iflow.common.models.edo.workflow.testthreetask.TestThreeTaskWorkflowEdo;
import com.pth.iflow.common.models.edo.workflow.testthreetask.TestThreeTaskWorkflowListEdo;
import com.pth.iflow.common.models.edo.workflow.testthreetask.TestThreeTaskWorkflowSaveRequestEdo;

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
                                                 WorkflowFileEdo.class,
                                                 WorkflowFileListEdo.class,
                                                 WorkflowFileVersionEdo.class,
                                                 WorkflowMessageEdo.class,
                                                 WorkflowMessageListEdo.class,
                                                 WorkflowSearchFilterEdo.class,
                                                 WorkflowTypeEdo.class,
                                                 WorkflowTypeListEdo.class,
                                                 WorkflowTypeStepEdo.class,
                                                 WorkflowTypeStepListEdo.class,
                                                 SingleTaskWorkflowEdo.class,
                                                 SingleTaskWorkflowListEdo.class,
                                                 SingleTaskWorkflowSaveRequestEdo.class,
                                                 TestThreeTaskWorkflowEdo.class,
                                                 TestThreeTaskWorkflowListEdo.class,
                                                 TestThreeTaskWorkflowSaveRequestEdo.class });

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

      if (messageConverters.get(i).canRead(InvoiceWorkflowEdo.class, MediaType.APPLICATION_XML)) {
        // need to replace the default MappingJackson2XmlHttpMessageConverter with the
        // one that understands JAXB annotations | CK2-153
        // messageConverters.set(i, converter);
        // return;
      }
    }

  }

}
