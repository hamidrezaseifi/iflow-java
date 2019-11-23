package com.pth.iflow.workflow.services.invoice;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.pth.iflow.common.edo.models.workflow.invoice.InvoiceWorkflowEdo;
import com.pth.iflow.common.edo.models.workflow.invoice.InvoiceWorkflowListEdo;
import com.pth.iflow.common.enums.EModule;
import com.pth.iflow.common.enums.EWorkflowActionStatus;
import com.pth.iflow.workflow.TestDataProducer;
import com.pth.iflow.workflow.bl.IWorkflowDataService;
import com.pth.iflow.workflow.bl.impl.workflowservice.invoice.InvoiceWorkflowCoreConnectService;
import com.pth.iflow.workflow.config.WorkflowConfiguration;
import com.pth.iflow.workflow.models.mapper.WorkflowModelEdoMapper;
import com.pth.iflow.workflow.models.workflow.invoice.InvoiceWorkflow;
import com.pth.iflow.workflow.services.IRestTemplateCall;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class InvoiceWorkflowDataServiceTest extends TestDataProducer {

  private IWorkflowDataService<InvoiceWorkflow>    workflowDataService;

  @Mock
  private IRestTemplateCall                        restTemplate;

  @MockBean
  private WorkflowConfiguration.ModuleAccessConfig moduleAccessConfig;

  private String                                   validTocken;

  @Before
  public void setUp() throws Exception {
    this.workflowDataService = new InvoiceWorkflowCoreConnectService(this.restTemplate, this.moduleAccessConfig);

    when(this.moduleAccessConfig.generateCoreUrl(any(URI.class))).thenReturn(new URI("http://any-string"));

    when(this.moduleAccessConfig.generateProfileUrl(any(URI.class))).thenReturn(new URI("http://any-string"));

    this.validTocken = "validTocken";
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testGetById() throws Exception {

    final InvoiceWorkflow workflow = this.getInvoiceTestWorkflow("workflow1", EWorkflowActionStatus.OPEN);
    final InvoiceWorkflowEdo workflowEdo = WorkflowModelEdoMapper.toEdo(workflow);

    when(this.restTemplate.callRestGet(any(URI.class), any(String.class), any(EModule.class), any(Class.class), any(boolean.class),
        any())).thenReturn(workflowEdo);

    final InvoiceWorkflow resWorkflow = this.workflowDataService.getByIdentity(workflow.getIdentity(), this.validTocken);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getIdentity(), workflow.getIdentity());
    Assert.assertEquals("Result workflow-type has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test
  public void testSaveWorkflow() throws Exception {

    final InvoiceWorkflow workflow = this.getInvoiceTestWorkflow("workflow1", EWorkflowActionStatus.OPEN);
    final InvoiceWorkflowEdo workflowEdo = WorkflowModelEdoMapper.toEdo(workflow);

    when(this.restTemplate.callRestPost(any(URI.class), any(String.class), any(EModule.class), any(InvoiceWorkflowEdo.class),
        any(Class.class), any(boolean.class))).thenReturn(workflowEdo);

    final InvoiceWorkflow resWorkflow = this.workflowDataService.save(workflow, this.validTocken);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getIdentity(), workflow.getIdentity());
    Assert.assertEquals("Result workflow-type has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test
  public void testGetListByIdList() throws Exception {

    final Set<String> idList = this.getTestWorkflowIdSet();
    final List<InvoiceWorkflow> list = this.getTestInvoiceWorkflowList();
    final InvoiceWorkflowListEdo edoList = new InvoiceWorkflowListEdo(WorkflowModelEdoMapper.toInvoiceWorkflowEdoList(list));

    when(this.restTemplate.callRestPost(any(URI.class), any(String.class), any(EModule.class), any(Set.class),
        eq(InvoiceWorkflowListEdo.class), any(boolean.class))).thenReturn(edoList);

    final List<InvoiceWorkflow> resList = this.workflowDataService.getListByIdentityList(idList, this.validTocken);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

}
