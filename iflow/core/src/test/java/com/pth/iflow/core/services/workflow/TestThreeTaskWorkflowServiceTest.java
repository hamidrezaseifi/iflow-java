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
import com.pth.iflow.core.model.workflow.TestThreeTaskWorkflow;
import com.pth.iflow.core.service.IWorkflowService;
import com.pth.iflow.core.service.impl.workflow.TestThreeTaskWorkflowService;
import com.pth.iflow.core.storage.dao.interfaces.workflow.IWorkflowDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestThreeTaskWorkflowServiceTest extends TestDataProducer {

  private IWorkflowService<TestThreeTaskWorkflow> workflowService;

  @MockBean
  private IWorkflowDao<TestThreeTaskWorkflow> workflowDao;

  @Before
  public void setUp() throws Exception {
    this.workflowService = new TestThreeTaskWorkflowService(this.workflowDao);
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testGetById() throws Exception {

    final TestThreeTaskWorkflow workflow = getTestTestThreeTaskWorkflow(1L);
    when(this.workflowDao.getByIdentity(any(String.class))).thenReturn(workflow);

    final TestThreeTaskWorkflow resWorkflow = this.workflowService.getByIdentity("identity");

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getId(), workflow.getId());
    Assert.assertEquals("Result workflow-type has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test
  public void testGetListByIdList() throws Exception {

    final Set<String> idList = getTestWorkflowIdentityList();
    final List<TestThreeTaskWorkflow> list = getTestTestThreeWorkflowList();
    when(this.workflowDao.getListByIdentityList(any(Set.class))).thenReturn(list);

    final List<TestThreeTaskWorkflow> resList = this.workflowService.getListByIdentityList(idList);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testSave() throws Exception {

    TestThreeTaskWorkflow workflow = getTestTestThreeTaskWorkflow(1L);
    workflow.setId(null);
    workflow.setIdentity(EIdentity.NOT_SET.getIdentity());
    workflow.setVersion(21);

    when(this.workflowDao.create(any(TestThreeTaskWorkflow.class))).thenReturn(workflow);
    when(this.workflowDao.update(any(TestThreeTaskWorkflow.class))).thenReturn(workflow);
    when(this.workflowDao.getByIdentity(any(String.class))).thenReturn(workflow);

    TestThreeTaskWorkflow resWorkflow = this.workflowService.save(workflow);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getId(), workflow.getId());
    Assert.assertEquals("Result workflow-type has status 1!", resWorkflow.getStatus(), workflow.getStatus());
    Assert.assertEquals("Result workflow-type has version 22!", resWorkflow.getVersion().intValue(), 22);

    workflow = getTestTestThreeTaskWorkflow(1L);

    when(this.workflowDao.create(any(TestThreeTaskWorkflow.class))).thenReturn(workflow);
    when(this.workflowDao.update(any(TestThreeTaskWorkflow.class))).thenReturn(workflow);
    when(this.workflowDao.getByIdentity(any(String.class))).thenReturn(workflow);

    resWorkflow = this.workflowService.save(workflow);

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflow);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflow.getId(), workflow.getId());
    Assert.assertEquals("Result workflow-type has status 1!", resWorkflow.getStatus(), workflow.getStatus());
    Assert.assertEquals("Result workflow-type has version 1!", resWorkflow.getVersion(), workflow.getVersion());

  }

}
