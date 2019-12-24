package com.pth.iflow.gui.services.singletask;

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
import com.pth.iflow.gui.models.ui.SessionUserInfo;
import com.pth.iflow.gui.models.workflow.singletask.SingleTaskWorkflow;
import com.pth.iflow.gui.models.workflow.singletask.SingleTaskWorkflowSaveRequest;
import com.pth.iflow.gui.services.IUploadFileManager;
import com.pth.iflow.gui.services.IWorkflowAccess;
import com.pth.iflow.gui.services.IWorkflowHandler;
import com.pth.iflow.gui.services.impl.workflow.singletask.SingleTaskWorkflowHandler;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SingleTaskWorkflowHandlerTest extends TestDataProducer {

  private IWorkflowHandler<SingleTaskWorkflow, SingleTaskWorkflowSaveRequest> workflowHandler;

  @MockBean
  private IWorkflowAccess<SingleTaskWorkflow, SingleTaskWorkflowSaveRequest>  workflowAccess;

  @MockBean
  private SessionUserInfo                                                     sessionUserInfo;

  @MockBean
  private IUploadFileManager                                                  uploadFileManager;

  @MockBean
  private HttpSession                                                         mockedSession;

  private String                                                              validTocken;

  @Before
  public void setUp() throws Exception {

    this.validTocken = "validTocken";

    when(this.sessionUserInfo.getToken()).thenReturn(this.validTocken);
    when(this.sessionUserInfo.getUserByIdentity(any(String.class))).thenReturn(this.getTestUser());
    when(this.sessionUserInfo.getUser()).thenReturn(this.getTestUser());
    when(this.sessionUserInfo.getWorkflowTypeByIdentity(any(String.class))).thenReturn(this.getTestWorkflowType());

    this.workflowHandler = new SingleTaskWorkflowHandler(this.workflowAccess, this.sessionUserInfo, this.uploadFileManager);

  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testReadWorkflow() throws Exception {

    final SingleTaskWorkflow workflow = this.getTestSingleTaskWorkflow("identity1");

    when(this.workflowAccess.readWorkflow(any(String.class), any(String.class))).thenReturn(workflow);

    final SingleTaskWorkflow resWorkflow = this.workflowHandler.readWorkflow(workflow.getIdentity());

    Assert.assertNotNull("Result workflow is not null!", resWorkflow);
    Assert.assertEquals("Result workflow has id 1!", resWorkflow.getIdentity(), workflow.getIdentity());
    Assert.assertEquals("Result workflow has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test
  public void testCreateWorkflow() throws Exception {

    final SingleTaskWorkflowSaveRequest createRequest = this.getTestSingleTaskWorkflowSaveRequest();

    final List<SingleTaskWorkflow> workflowList = this.getTestSingleTaskWorkflowList();

    when(this.workflowAccess.createWorkflow(any(SingleTaskWorkflowSaveRequest.class), any(String.class))).thenReturn(workflowList);

    final List<SingleTaskWorkflow> resWorkflowList = this.workflowHandler.createWorkflow(createRequest, this.mockedSession);

    Assert.assertNotNull("Result result-list is not null!", resWorkflowList);
    Assert.assertEquals("Result result-list has the same size as expected!", resWorkflowList.size(), workflowList.size());

  }

  @Test
  public void testSaveWorkflow() throws Exception {
    final SingleTaskWorkflow workflow = this.getTestSingleTaskWorkflow("identity1");

    when(this.workflowAccess.saveWorkflow(any(SingleTaskWorkflowSaveRequest.class), any(String.class))).thenReturn(workflow);

    final SingleTaskWorkflow resWorkflow = this.workflowHandler.saveWorkflow(workflow, this.mockedSession);

    Assert.assertNotNull("Result workflow is not null!", resWorkflow);
    Assert.assertEquals("Result workflow has id 1!", resWorkflow.getIdentity(), workflow.getIdentity());
    Assert.assertEquals("Result workflow has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

}
