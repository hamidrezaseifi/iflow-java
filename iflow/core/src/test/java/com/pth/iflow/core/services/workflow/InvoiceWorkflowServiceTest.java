package com.pth.iflow.core.services.workflow;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.util.List;
import java.util.Set;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.pth.iflow.common.enums.EIdentity;
import com.pth.iflow.core.TestDataProducer;
import com.pth.iflow.core.model.workflow.InvoiceWorkflow;
import com.pth.iflow.core.service.impl.workflow.InvoiceWorkflowService;
import com.pth.iflow.core.service.interfaces.workflow.IWorkflowService;
import com.pth.iflow.core.storage.dao.interfaces.workflow.IWorkflowDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class InvoiceWorkflowServiceTest extends TestDataProducer {

  private IWorkflowService<InvoiceWorkflow> invoiceWorkflowService;

  @MockBean
  private IWorkflowDao<InvoiceWorkflow> invoiceWorkflowDao;

  @Before
  public void setUp() throws Exception {
    this.invoiceWorkflowService = new InvoiceWorkflowService(this.invoiceWorkflowDao);
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testGetById() throws Exception {

    final InvoiceWorkflow workflow = getTestInvoiceWorkflow(1L);
    when(this.invoiceWorkflowDao.getByIdentity(any(String.class))).thenReturn(workflow);

    final InvoiceWorkflow resWorkflow = this.invoiceWorkflowService.getByIdentity("identity");

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getId(), workflow.getId());
    Assert.assertEquals("Result workflow-type has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test
  public void testGetListByIdList() throws Exception {

    final Set<String> idList = getTestWorkflowIdentityList();
    final List<InvoiceWorkflow> list = getTestInvoiceWorkflowList();
    when(this.invoiceWorkflowDao.getListByIdentityList(any(Set.class))).thenReturn(list);

    final List<InvoiceWorkflow> resList = this.invoiceWorkflowService.getListByIdentityList(idList);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testSave() throws Exception {

    InvoiceWorkflow workflow = getTestInvoiceWorkflow(1L);
    workflow.setId(null);
    workflow.setIdentity(EIdentity.NOT_SET.getIdentity());
    workflow.setVersion(21);

    when(this.invoiceWorkflowDao.create(any(InvoiceWorkflow.class))).thenReturn(workflow);
    when(this.invoiceWorkflowDao.update(any(InvoiceWorkflow.class))).thenReturn(workflow);
    when(this.invoiceWorkflowDao.getByIdentity(any(String.class))).thenReturn(workflow);

    InvoiceWorkflow resWorkflow = this.invoiceWorkflowService.save(workflow);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getId(), workflow.getId());
    Assert.assertEquals("Result workflow-type has status 1!", resWorkflow.getStatus(), workflow.getStatus());
    Assert.assertEquals("Result workflow-type has version 22!", resWorkflow.getVersion().intValue(), 22);

    workflow = getTestInvoiceWorkflow(1L);

    when(this.invoiceWorkflowDao.create(any(InvoiceWorkflow.class))).thenReturn(workflow);
    when(this.invoiceWorkflowDao.update(any(InvoiceWorkflow.class))).thenReturn(workflow);
    when(this.invoiceWorkflowDao.getByIdentity(any(String.class))).thenReturn(workflow);

    resWorkflow = this.invoiceWorkflowService.save(workflow);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getId(), workflow.getId());
    Assert.assertEquals("Result workflow-type has status 1!", resWorkflow.getStatus(), workflow.getStatus());
    Assert.assertEquals("Result workflow-type has version 1!", resWorkflow.getVersion(), workflow.getVersion());

  }

}
