package com.pth.iflow.core.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

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
import com.pth.iflow.core.model.WorkflowType;
import com.pth.iflow.core.model.WorkflowTypeStep;
import com.pth.iflow.core.service.IWorkflowTypeService;
import com.pth.iflow.core.service.impl.WorkflowTypeService;
import com.pth.iflow.core.storage.dao.IWorkflowTypeDao;
import com.pth.iflow.core.storage.dao.IWorkflowTypeStepDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowTypeServiceTest extends TestDataProducer {

  private IWorkflowTypeService workflowTypeService;

  @MockBean
  private IWorkflowTypeDao     workflowTypeDao;

  @MockBean
  private IWorkflowTypeStepDao workflowTypeStepDao;

  @Before
  public void setUp() throws Exception {
    this.workflowTypeService = new WorkflowTypeService(this.workflowTypeDao);
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testGetById() throws Exception {

    final WorkflowType workflowType = getTestWorkflowType();
    when(this.workflowTypeDao.getById(any(Long.class))).thenReturn(workflowType);

    final WorkflowType resWorkflowType = this.workflowTypeService.getById(workflowType.getId());

    Assert.assertNotNull("Result workflow-type is not null!", resWorkflowType);
    Assert.assertEquals("Result workflow-type has id 1!", resWorkflowType.getId(), workflowType.getId());
    Assert.assertEquals("Result workflow-type has title '" + workflowType.getTitle() + "'!", resWorkflowType.getTitle(),
        workflowType.getTitle());
    Assert.assertEquals("Result workflow-type has status 1!", resWorkflowType.getStatus(), workflowType.getStatus());

  }

  @Test
  public void testGetListByIdList() throws Exception {

    final Set<String> idList = getTestWorkflowTypeIdSet();
    final Set<WorkflowType> list = getTestWorkflowTypeList();
    when(this.workflowTypeDao.getListByIdentityList(any(Set.class))).thenReturn(list);

    final Set<WorkflowType> resList = this.workflowTypeService.getListByIdentityList(idList);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetListByIdCompanyId() throws Exception {

    final Set<WorkflowType> list = getTestWorkflowTypeList();
    when(this.workflowTypeDao.getListByCompanyId(any(Long.class))).thenReturn(list);

    final Set<WorkflowType> resList = this.workflowTypeService.getListByIdCompanyId(1L);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

  @Test
  public void testGetStepsById() throws Exception {

    final WorkflowType workflowType = getTestWorkflowType();
    final Set<WorkflowTypeStep> list = getTestWorkflowTypeStepList();

    when(this.workflowTypeDao.getById(any(Long.class))).thenReturn(workflowType);
    when(this.workflowTypeStepDao.getListByIdList(any(Set.class))).thenReturn(list);

    final Set<WorkflowTypeStep> resList = this.workflowTypeService.getStepsById(1L);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

}
