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
import com.pth.iflow.gui.models.GuiWorkflow;
import com.pth.iflow.gui.models.GuiWorkflowSaveRequest;
import com.pth.iflow.gui.models.GuiWorkflowSearchFilter;
import com.pth.iflow.gui.models.GuiWorkflowType;
import com.pth.iflow.gui.models.ui.GuiSessionUserInfo;
import com.pth.iflow.gui.services.impl.WorkflowHandler;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WorkflowHandlerTest extends TestDataProducer {

  private IWorkflowHandler   workflowHandler;

  @MockBean
  private IWorkflowAccess    workflowAccess;

  @MockBean
  private GuiSessionUserInfo sessionUserInfo;

  @MockBean
  private IUploadFileManager uploadFileManager;

  @MockBean
  private HttpSession        mockedSession;

  private String             validTocken;

  @Before
  public void setUp() throws Exception {

    this.validTocken = "validTocken";

    when(this.sessionUserInfo.getToken()).thenReturn(this.validTocken);
    when(this.sessionUserInfo.getUserById(any(Long.class))).thenReturn(this.getTestUser());
    when(this.sessionUserInfo.getWorkflowTypeById(any(Long.class))).thenReturn(this.getTestGuiWorkflowType());

    this.workflowHandler = new WorkflowHandler(this.workflowAccess, this.sessionUserInfo, this.uploadFileManager);

  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testReadWorkflow() throws Exception {

    final GuiWorkflow workflow = this.getTestGuiWorkflow(1L);

    when(this.workflowAccess.readWorkflow(any(Long.class), any(String.class))).thenReturn(workflow);

    final GuiWorkflow resWorkflow = this.workflowHandler.readWorkflow(workflow.getId());

    Assert.assertNotNull("Result workflow is not null!", resWorkflow);
    Assert.assertEquals("Result workflow has id 1!", resWorkflow.getId(), workflow.getId());
    Assert.assertEquals("Result workflow has title '" + workflow.getTitle() + "'!", resWorkflow.getTitle(), workflow.getTitle());
    Assert.assertEquals("Result workflow has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test
  public void testCreateWorkflow() throws Exception {

    final GuiWorkflowSaveRequest createRequest = this.getTestGuiWorkflowSaveRequest();

    final List<GuiWorkflow> workflowList = this.getTestGuiWorkflowList();

    when(this.workflowAccess.createWorkflow(any(GuiWorkflowSaveRequest.class), any(String.class))).thenReturn(workflowList);

    final List<GuiWorkflow> resWorkflowList = this.workflowHandler.createWorkflow(createRequest, this.mockedSession);

    Assert.assertNotNull("Result result-list is not null!", resWorkflowList);
    Assert.assertEquals("Result result-list has the same size as expected!", resWorkflowList.size(), workflowList.size());

  }

  @Test
  public void testSaveWorkflow() throws Exception {
    final GuiWorkflow workflow = this.getTestGuiWorkflow(1L);

    when(this.workflowAccess.saveWorkflow(any(GuiWorkflowSaveRequest.class), any(String.class))).thenReturn(workflow);

    final GuiWorkflow resWorkflow = this.workflowHandler.saveWorkflow(workflow, this.mockedSession);

    Assert.assertNotNull("Result workflow is not null!", resWorkflow);
    Assert.assertEquals("Result workflow has id 1!", resWorkflow.getId(), workflow.getId());
    Assert.assertEquals("Result workflow has title '" + workflow.getTitle() + "'!", resWorkflow.getTitle(), workflow.getTitle());
    Assert.assertEquals("Result workflow has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test
  public void testReadWorkflowTypeList() throws Exception {

    final List<GuiWorkflowType> workflowTypeList = this.getTestGuiWorkflowTypeList();

    when(this.workflowAccess.readWorkflowTypeList(any(Long.class), any(String.class))).thenReturn(workflowTypeList);

    final List<GuiWorkflowType> resWorkflowList = this.workflowHandler.readWorkflowTypeList(1L);

    Assert.assertNotNull("Result result-list is not null!", resWorkflowList);
    Assert.assertEquals("Result result-list has the same size as expected!", resWorkflowList.size(), workflowTypeList.size());

  }

  @Test
  public void testSearchWorkflow() throws Exception {
    final GuiWorkflowSearchFilter searchFilter = this.getTestGuiWorkflowSearchFilter();

    final List<GuiWorkflow> workflowList = this.getTestGuiWorkflowList();

    when(this.workflowAccess.searchWorkflow(any(GuiWorkflowSearchFilter.class), any(String.class))).thenReturn(workflowList);

    final List<GuiWorkflow> resWorkflowList = this.workflowHandler.searchWorkflow(searchFilter);

    Assert.assertNotNull("Result result-list is not null!", resWorkflowList);
    Assert.assertEquals("Result result-list has the same size as expected!", resWorkflowList.size(), workflowList.size());

  }

}
