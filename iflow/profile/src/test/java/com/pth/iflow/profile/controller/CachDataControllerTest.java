package com.pth.iflow.profile.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.List;
import java.util.Set;
import org.junit.After;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.pth.iflow.common.edo.models.IdentityListEdo;
import com.pth.iflow.common.edo.models.WorkflowMessageListEdo;
import com.pth.iflow.common.rest.IflowRestPaths;
import com.pth.iflow.common.rest.TokenVerficationHandlerInterceptor;
import com.pth.iflow.profile.TestDataProducer;
import com.pth.iflow.profile.model.WorkflowMessage;
import com.pth.iflow.profile.model.mapper.ProfileModelEdoMapper;
import com.pth.iflow.profile.service.ICompanyCachDataManager;
import com.pth.iflow.profile.service.ITokenUserDataManager;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CachDataControllerTest extends TestDataProducer {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private MappingJackson2XmlHttpMessageConverter xmlConverter;

  @MockBean
  private ITokenUserDataManager tokenUserDataManager;

  @MockBean
  private ICompanyCachDataManager companyCachDataManager;

  String TestToken = "test-roken";

  @Before
  public void setUp() throws Exception {
    when(this.tokenUserDataManager.validateToken(any(String.class))).thenReturn(null);

  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void readUserWorkflowMessageListTest() throws Exception {

    final List<WorkflowMessage> list = this.getTestWorkflowMessageList();

    final WorkflowMessageListEdo edo = new WorkflowMessageListEdo(ProfileModelEdoMapper.toWorkflowMessageEdoList(list));

    when(this.companyCachDataManager.getUserWorkflowMessages(any(String.class), any(String.class))).thenReturn(list);

    final String responseAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edo);

    this.mockMvc
                .perform(MockMvcRequestBuilders.get(IflowRestPaths.ProfileModule.READ_CACHDATA_USER_WORKFLOWMESSAGELIST("companyid",
                                                                                                                        "email"))
                                               .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, this.TestToken))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_XML_VALUE))
                .andExpect(content().xml(responseAsXmlString));

    verify(this.tokenUserDataManager, times(1)).validateToken(any(String.class));
    verify(this.companyCachDataManager, times(1)).getUserWorkflowMessages(any(String.class), any(String.class));
  }

  @Test
  public void resetUserDataTest() throws Exception {

    doNothing().when(this.companyCachDataManager).resetUserData(any(String.class), any(String.class));

    this.mockMvc.perform(MockMvcRequestBuilders.get(IflowRestPaths.ProfileModule.CAL_CACHDATA_USER_DATARESET("companyid", "email"))
                                               .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, this.TestToken))
                .andExpect(status().isOk());

    verify(this.tokenUserDataManager, times(1)).validateToken(any(String.class));
    verify(this.companyCachDataManager, times(1)).resetUserData(any(String.class), any(String.class));

  }

  @Test
  public void resetUserListDataTest() throws Exception {

    final IdentityListEdo edo = new IdentityListEdo(this.getTestUserIdSet());
    final String contentAsXmlString = this.xmlConverter.getObjectMapper().writeValueAsString(edo);

    doNothing().when(this.companyCachDataManager).resetUserListData(any(String.class), any(Set.class));

    this.mockMvc.perform(MockMvcRequestBuilders.post(IflowRestPaths.ProfileModule.CAL_CACHDATA_USERLIST_DATARESET("companyid"))
                                               .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, this.TestToken)
                                               .content(contentAsXmlString)
                                               .contentType(MediaType.APPLICATION_XML_VALUE))
                .andExpect(status().isOk());

    verify(this.tokenUserDataManager, times(1)).validateToken(any(String.class));
    verify(this.companyCachDataManager, times(1)).resetUserListData(any(String.class), any(Set.class));

  }

  @Test
  public void resetWorkflowrDataTest() throws Exception {
    doNothing().when(this.companyCachDataManager).resetWorkflowStepData(any(String.class), any(String.class));

    this.mockMvc
                .perform(MockMvcRequestBuilders.get(IflowRestPaths.ProfileModule.CAL_CACHDATA_WORKFLOW_DATARESET("companyid", "identity"))
                                               .header(TokenVerficationHandlerInterceptor.IFLOW_TOKENID_HEADER_KEY, this.TestToken))
                .andExpect(status().isOk());

    verify(this.tokenUserDataManager, times(1)).validateToken(any(String.class));
    verify(this.companyCachDataManager, times(1)).resetWorkflowStepData(any(String.class), any(String.class));
  }

}
