package com.pth.iflow.core.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pth.iflow.common.edo.models.CompanyEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.core.TestDataProducer;
import com.pth.iflow.core.model.Company;
import com.pth.iflow.core.service.ICompanyService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CompanyControllerTest extends TestDataProducer {

  @Autowired
  private MockMvc mockMvc;
  
  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;
  
  @Autowired
  private ObjectMapper mapper;
  
  @MockBean
  private ICompanyService companyService;
  
  @Before
  public void setUp() throws Exception {
  }
  
  @After
  public void tearDown() throws Exception {
  }
  
  @Test
  public void testReadCompany() throws Exception {

    final Company company = getTestCompany();
    when(this.companyService.getById(any(Long.class))).thenReturn(company);
    
    final CompanyEdo companyEdo = company.toEdo();
    
    final String companyAsString = this.xmlConverter.getObjectMapper().writeValueAsString(companyEdo);

    this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModul.COMPANY_READ_BY_ID, company.getId()))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(content().xml(companyAsString));
    
    verify(this.companyService, times(1)).getById(any(Long.class));

    final String userAsJsonString = this.mapper.writeValueAsString(companyEdo);
    final MvcResult res = this.mockMvc
        .perform(MockMvcRequestBuilders.get(IflowRestPaths.CoreModul.COMPANY_READ_BY_ID + "?produces=json", company.getId()))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(content().json(userAsJsonString))
        .andReturn();

    final String contentAsString = res.getResponse().getContentAsString();

    final ObjectMapper objectMapper = new ObjectMapper();
    final CompanyEdo resCompanyEdo = objectMapper.readValue(contentAsString, CompanyEdo.class);

    Assert.assertNotNull("Result company is not null!", resCompanyEdo);
    Assert.assertEquals("Result company has id 1!", resCompanyEdo.getId(), (Long) 1L);
    Assert.assertEquals("Result company has companyName 'companyName'!", resCompanyEdo.getCompanyName(), "companyName");
    Assert.assertEquals("Result company has identifyid 'identifyid'!", resCompanyEdo.getIdentifyid(), "identifyid");
    Assert.assertEquals("Result company has status 1!", resCompanyEdo.getStatus(), (Integer) 1);

  }
  
}
