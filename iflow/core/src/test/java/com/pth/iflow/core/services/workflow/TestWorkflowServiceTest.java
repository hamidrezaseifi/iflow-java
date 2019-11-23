package com.pth.iflow.core.services.workflow;

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
import com.pth.iflow.core.model.workflow.TestThreeTaskWorkflow;
import com.pth.iflow.core.model.workflow.WorkflowResult;
import com.pth.iflow.core.model.workflow.sub.WorkflowSearchFilter;
import com.pth.iflow.core.service.IWorkflowSearchService;
import com.pth.iflow.core.service.impl.workflow.WorkflowSearchService;
import com.pth.iflow.core.storage.dao.IWorkflowSearchDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestWorkflowServiceTest extends TestDataProducer {

  private IWorkflowSearchService workflowService;

  @MockBean
  private IWorkflowSearchDao     workflowDao;

  @Before
  public void setUp() throws Exception {
    this.workflowService = new WorkflowSearchService(this.workflowDao);
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testSearch() throws Exception {

    final WorkflowSearchFilter searchFilter = this.getTestWorkflowSearchFilter();
    final List<WorkflowResult> modelList = getTestWorkflowResultList();

    final List<TestThreeTaskWorkflow> list = getTestTestThreeWorkflowList();
    when(this.workflowDao.search(any(WorkflowSearchFilter.class))).thenReturn(modelList);

    final List<WorkflowResult> resList = this.workflowService.search(searchFilter);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + list.size() + " items.", resList.size(), list.size());

  }

}
