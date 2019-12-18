/**
 *
 */
package com.pth.iflow.e2e.basic;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.net.URI;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.pth.iflow.common.models.edo.WorkflowTypeListEdo;
import com.pth.iflow.e2e.E2eConfig;

/**
 *
 */
@RunWith(SpringRunner.class)
@Import(E2eConfig.class)
public class BasicE2eTest {

  @Autowired
  protected RestTemplate                           restTemplate;

  @Autowired
  protected MappingJackson2XmlHttpMessageConverter xmlConverter;

  @Value("${iflow.e2e.core.host:http://localhost:1010}")
  protected String                                 coreUrlHost;

  @Autowired
  public BasicE2eTest() {
  }

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {

  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testBasic_ReadWOrkflowTypes() throws Exception {

    final URI uri = com.pth.iflow.common.rest.IflowRestPaths.CoreModule.READ_WORKFLOWTYPE_LIST_BY_COMPANY("test-company-1");

    final WorkflowTypeListEdo list = this.restTemplate.getForObject(this.coreUrlHost + uri, WorkflowTypeListEdo.class);
    assertNotNull("result edo must not be null", list);
    assertNotNull("result list must not be null", list.getWorkflowTypes());
    assertTrue("result list must have items", list.getWorkflowTypes().size() > 0);
  }

}
