package com.pth.iflow.gui.services.testthree;

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
import com.pth.iflow.gui.models.WorkflowSearchFilter;
import com.pth.iflow.gui.models.ui.SessionUserInfo;
import com.pth.iflow.gui.models.workflow.testthree.TestThreeTaskWorkflow;
import com.pth.iflow.gui.models.workflow.testthree.TestThreeTaskWorkflowSaveRequest;
import com.pth.iflow.gui.services.IUploadFileManager;
import com.pth.iflow.gui.services.IWorkflowAccess;
import com.pth.iflow.gui.services.IWorkflowHandler;
import com.pth.iflow.gui.services.impl.workflow.testthree.TestThreeTaskWorkflowHandler;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestThreeTaskWorkflowHandlerTest extends TestDataProducer {

  private IWorkflowHandler<TestThreeTaskWorkflow, TestThreeTaskWorkflowSaveRequest> workflowHandler;

  @MockBean
  private IWorkflowAccess<TestThreeTaskWorkflow, TestThreeTaskWorkflowSaveRequest>  workflowAccess;

  @MockBean
  private SessionUserInfo                                                           sessionUserInfo;

  @MockBean
  private IUploadFileManager                                                        uploadFileManager;

  @MockBean
  private HttpSession                                                               mockedSession;

  private String                                                                    validTocken;

  @Before
  public void setUp() throws Exception {

    this.validTocken = "validTocken";

    when(this.sessionUserInfo.getToken()).thenReturn(this.validTocken);
    when(this.sessionUserInfo.getUserByIdentity(any(String.class))).thenReturn(this.getTestUser());
    when(this.sessionUserInfo.getUser()).thenReturn(this.getTestUser());
    when(this.sessionUserInfo.getWorkflowTypeByIdentity(any(String.class))).thenReturn(this.getTestWorkflowType());

    this.workflowHandler = new TestThreeTaskWorkflowHandler(this.workflowAccess, this.sessionUserInfo, this.uploadFileManager);

  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testReadWorkflow() throws Exception {

    final TestThreeTaskWorkflow workflow = this.getTestTestThreeTaskWorkflow("identity1");

    when(this.workflowAccess.readWorkflow(any(String.class), any(String.class))).thenReturn(workflow);

    final TestThreeTaskWorkflow resWorkflow = this.workflowHandler.readWorkflow(workflow.getIdentity());

    Assert.assertNotNull("Result workflow is not null!", resWorkflow);
    Assert.assertEquals("Result workflow has id 1!", resWorkflow.getIdentity(), workflow.getIdentity());
    Assert.assertEquals("Result workflow has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test
  public void testCreateWorkflow() throws Exception {

    final TestThreeTaskWorkflowSaveRequest createRequest = this.getTestTestThreeTaskWorkflowSaveRequest();

    final List<TestThreeTaskWorkflow> workflowList = this.getTestTestThreeTaskWorkflowList();

    when(this.workflowAccess.createWorkflow(any(TestThreeTaskWorkflowSaveRequest.class), any(String.class))).thenReturn(workflowList);

    final List<TestThreeTaskWorkflow> resWorkflowList = this.workflowHandler.createWorkflow(createRequest, this.mockedSession);

    Assert.assertNotNull("Result result-list is not null!", resWorkflowList);
    Assert.assertEquals("Result result-list has the same size as expected!", resWorkflowList.size(), workflowList.size());

  }

  @Test
  public void testSaveWorkflow() throws Exception {
    final TestThreeTaskWorkflow workflow = this.getTestTestThreeTaskWorkflow("identity1");

    when(this.workflowAccess.saveWorkflow(any(TestThreeTaskWorkflowSaveRequest.class), any(String.class))).thenReturn(workflow);

    final TestThreeTaskWorkflow resWorkflow = this.workflowHandler.saveWorkflow(workflow, this.mockedSession);

    Assert.assertNotNull("Result workflow is not null!", resWorkflow);
    Assert.assertEquals("Result workflow has id 1!", resWorkflow.getIdentity(), workflow.getIdentity());
    Assert.assertEquals("Result workflow has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test
  public void testSearchWorkflow() throws Exception {
    final WorkflowSearchFilter searchFilter = this.getTestWorkflowSearchFilter();

    final List<TestThreeTaskWorkflow> workflowList = this.getTestTestThreeTaskWorkflowList();

    when(this.workflowAccess.searchWorkflow(any(WorkflowSearchFilter.class), any(String.class))).thenReturn(workflowList);

    final List<TestThreeTaskWorkflow> resWorkflowList = this.workflowHandler.searchWorkflow(searchFilter);

    Assert.assertNotNull("Result result-list is not null!", resWorkflowList);
    Assert.assertEquals("Result result-list has the same size as expected!", resWorkflowList.size(), workflowList.size());

  }

}
