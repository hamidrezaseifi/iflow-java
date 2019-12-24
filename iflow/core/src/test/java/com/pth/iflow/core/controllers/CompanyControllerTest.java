package com.pth.iflow.core.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.pth.iflow.common.models.edo.CompanyEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.XmlRestConfig;
import com.pth.iflow.core.TestDataProducer;
import com.pth.iflow.core.model.entity.CompanyEntity;
import com.pth.iflow.core.service.interfaces.ICompanyService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CompanyControllerTest extends TestDataProducer {

  @Autowired
  private MockMvc                                mockMvc;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;

  @MockBean
  private ICompanyService                        companyService;

  @Before
  public void setUp() throws Exception {
  }

  @Value("${iflow.common.rest.api.security.client-id.internal}")
  private String innerModulesRequestHeaderValue;

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testReadCompany() throws Exception {

    final CompanyEntity company = getTestCompany();
    final CompanyEdo companyEdo = getTestCompanyEdo();

    when(this.companyService.getByIdentity(any(String.class))).thenReturn(company);
    when(this.companyService.toEdo(any(CompanyEntity.class))).thenReturn(companyEdo);

    final String companyAsString = this.xmlConverter.getObjectMapper().writeValueAsString(companyEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModule.COMPANY_READ_BY_IDENTITY, company.getIdentity())
            .header(XmlRestConfig.REQUEST_HEADER_IFLOW_CLIENT_ID, this.innerModulesRequestHeaderValue))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(companyAsString));

    verify(this.companyService, times(1)).getByIdentity(any(String.class));

  }

}
