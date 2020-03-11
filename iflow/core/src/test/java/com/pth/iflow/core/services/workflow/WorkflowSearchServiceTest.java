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
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.pth.iflow.core.TestDataProducer;
import com.pth.iflow.core.model.WorkflowSearchFilter;
import com.pth.iflow.core.model.entity.workflow.WorkflowEntity;
import com.pth.iflow.core.service.impl.workflow.WorkflowSearchService;
import com.pth.iflow.core.service.interfaces.IWorkflowSearchService;
import com.pth.iflow.core.service.interfaces.workflow.IWorkflowService;
import com.pth.iflow.core.storage.dao.interfaces.IWorkflowSearchDao;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class WorkflowSearchServiceTest extends TestDataProducer {

  private IWorkflowSearchService workflowSearchService;

  @MockBean
  private IWorkflowSearchDao workflowDao;

  @MockBean
  private IWorkflowService workflowService;

  @Before
  public void setUp() throws Exception {

    this.workflowSearchService = new WorkflowSearchService(this.workflowDao, this.workflowService);
  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testSearch() throws Exception {

    final WorkflowSearchFilter searchFilter = this.getTestWorkflowSearchFilter();
    final List<WorkflowEntity> modelList = getTestWorkflowList();

    when(this.workflowDao.search(any(WorkflowSearchFilter.class))).thenReturn(modelList);

    final List<WorkflowEntity> resList = this.workflowSearchService.search(searchFilter);

    Assert.assertNotNull("Result list is not null!", resList);
    Assert.assertEquals("Result list has " + modelList.size() + " items.", resList.size(), modelList.size());

  }

}
