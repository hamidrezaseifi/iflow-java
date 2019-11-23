package com.pth.iflow.gui.services.invoice;

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
import com.pth.iflow.gui.models.workflow.invoice.InvoiceWorkflow;
import com.pth.iflow.gui.models.workflow.invoice.InvoiceWorkflowSaveRequest;
import com.pth.iflow.gui.services.IUploadFileManager;
import com.pth.iflow.gui.services.IWorkflowAccess;
import com.pth.iflow.gui.services.IWorkflowHandler;
import com.pth.iflow.gui.services.impl.workflow.invoice.InvoiceWorkflowHandler;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class InvoiceWorkflowHandlerTest extends TestDataProducer {

  private IWorkflowHandler<InvoiceWorkflow, InvoiceWorkflowSaveRequest> workflowHandler;

  @MockBean
  private IWorkflowAccess<InvoiceWorkflow, InvoiceWorkflowSaveRequest>  workflowAccess;

  @MockBean
  private SessionUserInfo                                               sessionUserInfo;

  @MockBean
  private IUploadFileManager                                            uploadFileManager;

  @MockBean
  private HttpSession                                                   mockedSession;

  private String                                                        validTocken;

  @Before
  public void setUp() throws Exception {

    this.validTocken = "validTocken";

    when(this.sessionUserInfo.getToken()).thenReturn(this.validTocken);
    when(this.sessionUserInfo.getUserByIdentity(any(String.class))).thenReturn(this.getTestUser());
    when(this.sessionUserInfo.getUser()).thenReturn(this.getTestUser());
    when(this.sessionUserInfo.getWorkflowTypeByIdentity(any(String.class))).thenReturn(this.getTestWorkflowType());

    this.workflowHandler = new InvoiceWorkflowHandler(this.workflowAccess, this.sessionUserInfo, this.uploadFileManager);

  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testReadWorkflow() throws Exception {

    final InvoiceWorkflow workflow = this.getTestInvoiceWorkflow("identity1");

    when(this.workflowAccess.readWorkflow(any(String.class), any(String.class))).thenReturn(workflow);

    final InvoiceWorkflow resWorkflow = this.workflowHandler.readWorkflow(workflow.getIdentity());

    Assert.assertNotNull("Result workflow is not null!", resWorkflow);
    Assert.assertEquals("Result workflow has id 1!", resWorkflow.getIdentity(), workflow.getIdentity());
    Assert.assertEquals("Result workflow has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

  @Test
  public void testCreateWorkflow() throws Exception {

    final InvoiceWorkflowSaveRequest createRequest = this.getTestInvoiceWorkflowSaveRequest();

    final List<InvoiceWorkflow> workflowList = this.getTestInvoiceWorkflowList();

    when(this.workflowAccess.createWorkflow(any(InvoiceWorkflowSaveRequest.class), any(String.class))).thenReturn(workflowList);

    final List<InvoiceWorkflow> resWorkflowList = this.workflowHandler.createWorkflow(createRequest, this.mockedSession);

    Assert.assertNotNull("Result result-list is not null!", resWorkflowList);
    Assert.assertEquals("Result result-list has the same size as expected!", resWorkflowList.size(), workflowList.size());

  }

  @Test
  public void testSaveWorkflow() throws Exception {
    final InvoiceWorkflow workflow = this.getTestInvoiceWorkflow("identity1");

    when(this.workflowAccess.saveWorkflow(any(InvoiceWorkflowSaveRequest.class), any(String.class))).thenReturn(workflow);

    final InvoiceWorkflow resWorkflow = this.workflowHandler.saveWorkflow(workflow, this.mockedSession);

    Assert.assertNotNull("Result workflow is not null!", resWorkflow);
    Assert.assertEquals("Result workflow has id 1!", resWorkflow.getIdentity(), workflow.getIdentity());
    Assert.assertEquals("Result workflow has status 1!", resWorkflow.getStatus(), workflow.getStatus());

  }

}
