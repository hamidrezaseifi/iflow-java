package com.pth.iflow.profile.test.service.access;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.models.edo.WorkflowMessageEdo;
import com.pth.iflow.common.models.edo.WorkflowMessageListEdo;
import com.pth.iflow.profile.config.ProfileConfiguration;
import com.pth.iflow.profile.model.WorkflowMessage;
import com.pth.iflow.profile.model.mapper.ProfileModelEdoMapper;
import com.pth.iflow.profile.service.access.IWorkflowMessageAccessService;
import com.pth.iflow.profile.service.access.impl.WorkflowMessageAccessService;
import com.pth.iflow.profile.service.handler.IProfileRestTemplateCall;
import com.pth.iflow.profile.test.TestDataProducer;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class WorkflowMessageAccessServiceTest extends TestDataProducer {

  private IWorkflowMessageAccessService workflowMessageService;

  @Mock
  private IProfileRestTemplateCall restTemplate;

  @MockBean
  private ProfileConfiguration.CoreAccessConfig coreAccessConfig;

  @Before
  public void setUp() throws Exception {

    this.workflowMessageService = new WorkflowMessageAccessService(this.restTemplate, this.coreAccessConfig);

    when(this.coreAccessConfig.prepareCoreUrl(any(URI.class))).thenReturn(new URI("http://any-string"));

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testGetWorkflowMessageListByUser() throws Exception {

    final List<WorkflowMessage> list = this.getTestWorkflowMessageList();
    final List<WorkflowMessageEdo> edoList = ProfileModelEdoMapper.toWorkflowMessageEdoList(list);

    when(this.restTemplate.callRestGet(any(URI.class), any(EModule.class), any(Class.class), any(boolean.class)))
        .thenReturn(new WorkflowMessageListEdo(edoList));

    final List<WorkflowMessage> resultList = this.workflowMessageService.getWorkflowMessageListByUser("userIdentity");

    Assert.assertNotNull("Result message list is not null!", resultList);
    Assert.assertEquals("Result message list has the same item count as expected!", list.size(), resultList.size());
    Assert
        .assertEquals("First item of result message list has the same message as expected!", list.get(0).getMessage(),
            resultList.get(0).getMessage());

  }

  @Test
  public void testGetWorkflowMessageListByWorkflow() throws Exception {

    final List<WorkflowMessage> list = this.getTestWorkflowMessageList();
    final List<WorkflowMessageEdo> edoList = ProfileModelEdoMapper.toWorkflowMessageEdoList(list);

    when(this.restTemplate.callRestGet(any(URI.class), any(EModule.class), any(Class.class), any(boolean.class)))
        .thenReturn(new WorkflowMessageListEdo(edoList));

    final List<WorkflowMessage> resultList = this.workflowMessageService.getWorkflowMessageListByWorkflow("workflowIdentity");

    Assert.assertNotNull("Result message list is not null!", resultList);
    Assert.assertEquals("Result message list has the same item count as expected!", list.size(), resultList.size());
    Assert
        .assertEquals("First item of result message list has the same message as expected!", list.get(0).getMessage(),
            resultList.get(0).getMessage());

  }

}
