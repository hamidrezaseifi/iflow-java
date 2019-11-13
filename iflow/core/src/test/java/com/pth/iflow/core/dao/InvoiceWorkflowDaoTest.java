package com.pth.iflow.core.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.pth.iflow.common.enums.EWorkflowIdentity;
import com.pth.iflow.core.TestDataProducer;
import com.pth.iflow.core.model.workflow.InvoiceWorkflow;
import com.pth.iflow.core.storage.dao.IWorkflowDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class InvoiceWorkflowDaoTest extends TestDataProducer {

  @Autowired
  private IWorkflowDao<InvoiceWorkflow> invoiceWorkflowDao;

  private final List<InvoiceWorkflow> createdModels = new ArrayList<>();

  @Before
  public void setUp() throws Exception {

  }

  private void createWorlflowList() throws Exception {
    for (int i = 1; i <= 3; i++) {
      final InvoiceWorkflow workflow = getTestNewInvoiceWorkflow();
      workflow.setId(null);
      workflow.setIdentity(EWorkflowIdentity.NOT_SET.getName());
      final InvoiceWorkflow res = invoiceWorkflowDao.create(workflow);
      createdModels.add(res);
    }
  }

  @After
  public void tearDown() throws Exception {

    for (final InvoiceWorkflow workflow : createdModels) {
      invoiceWorkflowDao.deleteWorkflow(workflow.getId());
    }
  }

  @Test
  public void testGetById() throws Exception {

    createWorlflowList();

    final InvoiceWorkflow workflow = createdModels.get(0);

    final InvoiceWorkflow resWorkflow = this.invoiceWorkflowDao.getById(createdModels.get(0).getId());

    Assert.assertNotNull("Result workflow is not null!", resWorkflow);
    Assert.assertEquals("Result workflow has id 1!", resWorkflow.getId(), workflow.getId());
    Assert.assertEquals("Result workflow has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test
  public void testGetListByIdList() throws Exception {

    createWorlflowList();

    final Set<Long> idList = createdModels.stream().map(w -> w.getId()).collect(Collectors.toSet());

    final List<InvoiceWorkflow> resList = this.invoiceWorkflowDao.getListByIdList(idList);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + createdModels.size() + " items.", resList.size(), createdModels.size());

  }

  @Test
  public void testCreate() throws Exception {

    final InvoiceWorkflow workflow = getTestNewInvoiceWorkflow();
    workflow.setVersion(10);
    final InvoiceWorkflow resWorkflow = invoiceWorkflowDao.create(workflow);
    createdModels.add(resWorkflow);

    Assert.assertNotNull("Result workflow is not null!", resWorkflow);
    Assert.assertEquals("Result workflow has status 1!", resWorkflow.getStatus(), workflow.getStatus());
    Assert.assertEquals("Result workflow has version " + workflow.getVersion() + "!", resWorkflow.getVersion(), workflow.getVersion());

  }

  @Test
  public void testUpdate() throws Exception {

    final InvoiceWorkflow workflow = getTestNewInvoiceWorkflow();
    workflow.setVersion(10);
    final InvoiceWorkflow createdWorkflow = invoiceWorkflowDao.create(workflow);
    createdModels.add(createdWorkflow);

    Assert.assertNotNull("Result created workflow is not null!", createdWorkflow);

    createdWorkflow.setVersion(22);
    createdWorkflow.setStatus(10);

    final InvoiceWorkflow updatedWorkflow = invoiceWorkflowDao.update(createdWorkflow);

    Assert.assertNotNull("Result workflow is not null!", updatedWorkflow);
    Assert.assertEquals("Result workflow has the same id as created!", createdWorkflow.getId(), updatedWorkflow.getId());
    Assert.assertEquals("Result workflow has status 10!", updatedWorkflow.getStatusInt().intValue(), 10);
    Assert.assertEquals("Result workflow has version 22!", updatedWorkflow.getVersion().intValue(), 22);

  }

  @Test
  public void testDelete() throws Exception {

    final InvoiceWorkflow workflow = getTestNewInvoiceWorkflow();
    workflow.setVersion(10);
    final InvoiceWorkflow resWorkflow = invoiceWorkflowDao.create(workflow);

    Assert.assertNotNull("Result workflow is not null!", resWorkflow);

    invoiceWorkflowDao.deleteWorkflow(resWorkflow.getId());

    final InvoiceWorkflow deletedWorkflow = this.invoiceWorkflowDao.getById(resWorkflow.getId());

    Assert.assertNull("Result workflow is null!", deletedWorkflow);

  }

}
