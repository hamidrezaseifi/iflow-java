package com.pth.iflow.core.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

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
import com.pth.iflow.core.model.WorkflowTypeStep;
import com.pth.iflow.core.service.IWorkflowTypeStepService;
import com.pth.iflow.core.service.impl.WorkflowTypeStepService;
import com.pth.iflow.core.storage.dao.IWorkflowTypeStepDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowTypeStepServiceTest extends TestDataProducer {
  
  private IWorkflowTypeStepService workflowTypeStepService;
  
  @MockBean
  private IWorkflowTypeStepDao workflowTypeStepDao;
  
  @Before
  public void setUp() throws Exception {
    this.workflowTypeStepService = new WorkflowTypeStepService(this.workflowTypeStepDao);
  }
  
  @After
  public void tearDown() throws Exception {
  }
  
  @Test
  public void testGetById() throws Exception {
    
    final WorkflowTypeStep workflowType = getTestWorkflowTypeStep();
    when(this.workflowTypeStepDao.getById(any(Long.class))).thenReturn(workflowType);
    
    final WorkflowTypeStep resWorkflowType = this.workflowTypeStepService.getById(workflowType.getId());
    
    Assert.assertNotNull("Result workflow-type-step is not null!", resWorkflowType);
    Assert.assertEquals("Result workflow-type-step has id 1!", resWorkflowType.getId(), workflowType.getId());
    Assert.assertEquals("Result workflow-type-step has title '" + workflowType.getTitle() + "'!", resWorkflowType.getTitle(),
        workflowType.getTitle());
    Assert.assertEquals("Result workflow-type-step has status 1!", resWorkflowType.getStatus(), workflowType.getStatus());
    
  }
  
  @Test
  public void testGetListByIdList() throws Exception {
    
    final List<Long> idList = getTestWorkflowTypeIdList();
    final List<WorkflowTypeStep> list = getTestWorkflowTypeStepList();
    when(this.workflowTypeStepDao.getListByIdList(any(List.class))).thenReturn(list);
    
    final List<WorkflowTypeStep> resList = this.workflowTypeStepService.getListByIdList(idList);
    
    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());
    
  }

  @Test
  public void testGetListByWorkflowTypeId() throws Exception {
    
    final List<WorkflowTypeStep> list = getTestWorkflowTypeStepList();
    when(this.workflowTypeStepDao.getListByWorkflowTypeId(any(Long.class))).thenReturn(list);
    
    final List<WorkflowTypeStep> resList = this.workflowTypeStepService.getListByWorkflowTypeId(1L);
    
    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());
    
  }
  
}
