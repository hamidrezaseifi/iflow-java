package com.pth.iflow.core.services.workflow;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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

import com.pth.iflow.core.TestDataProducer;
import com.pth.iflow.core.model.entity.workflow.InvoiceWorkflowEntity;
import com.pth.iflow.core.service.impl.workflow.InvoiceWorkflowService;
import com.pth.iflow.core.service.interfaces.workflow.IInvoiceWorkflowService;
import com.pth.iflow.core.service.interfaces.workflow.IWorkflowService;
import com.pth.iflow.core.storage.dao.interfaces.workflow.IInvoiceWorkflowDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class InvoiceWorkflowServiceTest extends TestDataProducer {

  private IInvoiceWorkflowService invoiceWorkflowService;

  @MockBean
  private IInvoiceWorkflowDao     workflowDao;

  @MockBean
  private IWorkflowService        workflowService;

  @Before
  public void setUp() throws Exception {
    this.invoiceWorkflowService = new InvoiceWorkflowService(this.workflowDao, this.workflowService);
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testSaveCreate() {
    final InvoiceWorkflowEntity model = getTestNewInvoiceWorkflow();

    final InvoiceWorkflowEntity savedModel = getTestInvoiceWorkflow(1L);

    when(this.workflowDao.create(any(InvoiceWorkflowEntity.class))).thenReturn(savedModel);
    when(this.workflowDao.getById(any(Long.class))).thenReturn(savedModel);

    final InvoiceWorkflowEntity result = invoiceWorkflowService.save(model);

    assetWorkflow(savedModel, result);

    verify(this.workflowDao, times(1)).create(any(InvoiceWorkflowEntity.class));
    verify(this.workflowDao, times(0)).getById(any(long.class));

  }

  @Test
  public void testSaveUpdate() {
    final InvoiceWorkflowEntity model = getTestInvoiceWorkflow(1L);

    final InvoiceWorkflowEntity savedModel = getTestInvoiceWorkflow(1L);

    when(this.workflowDao.update(any(InvoiceWorkflowEntity.class))).thenReturn(savedModel);
    when(this.workflowDao.getById(any(Long.class))).thenReturn(savedModel);

    final InvoiceWorkflowEntity result = invoiceWorkflowService.save(model);

    assetWorkflow(savedModel, result);

    verify(this.workflowDao, times(1)).update(any(InvoiceWorkflowEntity.class));
    verify(this.workflowDao, times(1)).getById(any(long.class));

  }

  @Test
  public void testGetByIdentity() {
    final InvoiceWorkflowEntity model = getTestInvoiceWorkflow(1L);

    when(this.workflowDao.getByIdentity(any(String.class))).thenReturn(model);

    final InvoiceWorkflowEntity result = invoiceWorkflowService.getByIdentity("test-identity");

    assetWorkflow(model, result);

    verify(this.workflowDao, times(1)).getByIdentity(any(String.class));

  }

  @Test
  public void testGetListForUser() {
    final List<InvoiceWorkflowEntity> modelList = getTestInvoiceWorkflowList();

    when(this.workflowDao.getListForUserIdentity(any(String.class), any(Integer.class))).thenReturn(modelList);

    final List<InvoiceWorkflowEntity> resultList = invoiceWorkflowService.getListForUser("test-identity", 1);

    Assert.assertNotNull("Result list is not null!", resultList);
    Assert.assertEquals("Result list has " + modelList.size() + " items.", resultList.size(), modelList.size());

    verify(this.workflowDao, times(1)).getListForUserIdentity(any(String.class), any(Integer.class));
  }

  @Test
  public void testGetListByIdentityList() {
    final Set<String> idList = getTestWorkflowIdentityList();
    final List<InvoiceWorkflowEntity> modelList = getTestInvoiceWorkflowList();

    when(this.workflowDao.getListByIdentityList(any(Set.class))).thenReturn(modelList);

    final List<InvoiceWorkflowEntity> resultList = invoiceWorkflowService.getListByIdentityList(idList);

    Assert.assertNotNull("Result list is not null!", resultList);
    Assert.assertEquals("Result list has " + modelList.size() + " items.", resultList.size(), modelList.size());

    verify(this.workflowDao, times(1)).getListByIdentityList(any(Set.class));
  }

  private void assetWorkflow(final InvoiceWorkflowEntity savedModel, final InvoiceWorkflowEntity result) {
    Assert.assertNotNull("Result is not null!", result);
    Assert.assertEquals("Result has " + result.getWorkflow().getIdentity() + " identity.", result.getWorkflow().getIdentity(),
        savedModel.getWorkflow().getIdentity());
    Assert.assertEquals("Result has " + result.getWorkflow().getControllerId() + " controller.", result.getWorkflow().getControllerId(),
        savedModel.getWorkflow().getControllerId());
    Assert.assertEquals("Result has " + result.getWorkflow().getCurrentStepId() + " step.", result.getWorkflow().getCurrentStepId(),
        savedModel.getWorkflow().getCurrentStepId());
    Assert.assertEquals("Result has " + result.getWorkflow().getWorkflowTypeId() + " workflow-type.",
        result.getWorkflow().getWorkflowTypeId(), savedModel.getWorkflow().getWorkflowTypeId());
  }
}
