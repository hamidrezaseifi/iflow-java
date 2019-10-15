package com.pth.iflow.gui.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.pth.iflow.gui.TestDataProducer;
import com.pth.iflow.gui.models.Workflow;
import com.pth.iflow.gui.models.WorkflowSaveRequest;
import com.pth.iflow.gui.models.WorkflowSearchFilter;
import com.pth.iflow.gui.models.WorkflowType;
import com.pth.iflow.gui.models.ui.SessionUserInfo;
import com.pth.iflow.gui.services.impl.WorkflowHandler;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowHandlerTest extends TestDataProducer {

  private IWorkflowHandler workflowHandler;

  @MockBean
  private IWorkflowAccess workflowAccess;

  @MockBean
  private SessionUserInfo sessionUserInfo;

  @MockBean
  private IUploadFileManager uploadFileManager;

  @MockBean
  private HttpSession mockedSession;

  @MockBean
  private IMessagesHelper messagesHelper;

  private String validTocken;

  @Before
  public void setUp() throws Exception {

    this.validTocken = "validTocken";

    when(this.sessionUserInfo.getToken()).thenReturn(this.validTocken);
    when(this.sessionUserInfo.getUserByIdentity(any(String.class))).thenReturn(this.getTestUser());
    when(this.sessionUserInfo.getUser()).thenReturn(this.getTestUser());
    when(this.sessionUserInfo.getWorkflowTypeById(any(String.class))).thenReturn(this.getTestWorkflowType());
    when(this.messagesHelper.get(any(String.class))).thenReturn("");

    this.workflowHandler = new WorkflowHandler(this.workflowAccess, this.sessionUserInfo, this.uploadFileManager, this.messagesHelper);

  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testReadWorkflow() throws Exception {

    final Workflow workflow = this.getTestWorkflow("identity1");

    when(this.workflowAccess.readWorkflow(any(String.class), any(String.class))).thenReturn(workflow);

    final Workflow resWorkflow = this.workflowHandler.readWorkflow(workflow.getIdentity());

    Assert.assertNotNull("Result workflow is not null!", resWorkflow);
    Assert.assertEquals("Result workflow has id 1!", resWorkflow.getIdentity(), workflow.getIdentity());
    Assert.assertEquals("Result workflow has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test
  public void testCreateWorkflow() throws Exception {

    final WorkflowSaveRequest createRequest = this.getTestWorkflowSaveRequest();

    final List<Workflow> workflowList = this.getTestWorkflowList();

    when(this.workflowAccess.createWorkflow(any(WorkflowSaveRequest.class), any(String.class))).thenReturn(workflowList);

    final List<Workflow> resWorkflowList = this.workflowHandler.createWorkflow(createRequest, this.mockedSession);

    Assert.assertNotNull("Result result-list is not null!", resWorkflowList);
    Assert.assertEquals("Result result-list has the same size as expected!", resWorkflowList.size(), workflowList.size());

  }

  @Test
  public void testSaveWorkflow() throws Exception {
    final Workflow workflow = this.getTestWorkflow("identity1");

    when(this.workflowAccess.saveWorkflow(any(WorkflowSaveRequest.class), any(String.class))).thenReturn(workflow);

    final Workflow resWorkflow = this.workflowHandler.saveWorkflow(workflow, this.mockedSession);

    Assert.assertNotNull("Result workflow is not null!", resWorkflow);
    Assert.assertEquals("Result workflow has id 1!", resWorkflow.getIdentity(), workflow.getIdentity());
    Assert.assertEquals("Result workflow has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test
  public void testReadWorkflowTypeList() throws Exception {

    final List<WorkflowType> workflowTypeList = this.getTestWorkflowTypeList();

    when(this.workflowAccess.readWorkflowTypeList(any(String.class), any(String.class))).thenReturn(workflowTypeList);

    final List<WorkflowType> resWorkflowList = this.workflowHandler.readWorkflowTypeList("test-company");

    Assert.assertNotNull("Result result-list is not null!", resWorkflowList);
    Assert.assertEquals("Result result-list has the same size as expected!", resWorkflowList.size(), workflowTypeList.size());

  }

  @Test
  public void testSearchWorkflow() throws Exception {
    final WorkflowSearchFilter searchFilter = this.getTestWorkflowSearchFilter();

    final List<Workflow> workflowList = this.getTestWorkflowList();

    when(this.workflowAccess.searchWorkflow(any(WorkflowSearchFilter.class), any(String.class))).thenReturn(workflowList);

    final List<Workflow> resWorkflowList = this.workflowHandler.searchWorkflow(searchFilter);

    Assert.assertNotNull("Result result-list is not null!", resWorkflowList);
    Assert.assertEquals("Result result-list has the same size as expected!", resWorkflowList.size(), workflowList.size());

  }

}
