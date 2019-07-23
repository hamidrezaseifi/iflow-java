package com.pth.iflow.profile.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pth.iflow.profile.TestDataProducer;
import com.pth.iflow.profile.model.UserAuthenticationSession;
import com.pth.iflow.profile.service.ISessionManager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProfileSessionManagerTest extends TestDataProducer {

  @Autowired
  private ISessionManager           sessionManager;

  private final String              initialEmail   = "valid-email";

  private UserAuthenticationSession initialSession = null;

  @Before
  public void setUp() throws Exception {

    initialSession = sessionManager.addSession(initialEmail);

  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testAddSession() throws Exception {

    UserAuthenticationSession session = sessionManager.addSession(initialEmail);

    Assert.assertNotNull("Result session is not null!", session);
    Assert.assertEquals("Result session has the same session-id as initial!", session.getSessionid(), initialSession.getSessionid());
    Assert.assertEquals("Result session has the same token as initial!", session.getToken(), initialSession.getToken());

    final String newEmail = "newEmail" + String.valueOf(System.currentTimeMillis());
    session = sessionManager.addSession(newEmail);

    Assert.assertNotNull("Result session is not null!", session);
    Assert.assertNotEquals("Result session has not the same session-id as initial!", session.getSessionid(),
        initialSession.getSessionid());
    Assert.assertNotEquals("Result session has the same token as initial!", session.getToken(), initialSession.getToken());

  }

  @Test
  public void testFindByEmail() throws Exception {

    final String newEmail1 = "newEmail" + String.valueOf(System.currentTimeMillis());
    final UserAuthenticationSession session1 = sessionManager.addSession(newEmail1);

    final UserAuthenticationSession session2 = sessionManager.findByEmail(newEmail1);

    Assert.assertNotNull("Result session2 is not null!", session1);
    Assert.assertEquals("Result session has the same session-id as session1!", session1.getSessionid(), session2.getSessionid());
    Assert.assertEquals("Result session has the same token as session1!", session1.getToken(), session2.getToken());

  }

  @Test
  public void testFindValidateByEmail() throws Exception {

  }

  @Test
  public void testFindBySessionId() throws Exception {
    final String newEmail1 = "newEmail" + String.valueOf(System.currentTimeMillis());
    final UserAuthenticationSession session1 = sessionManager.addSession(newEmail1);

    final UserAuthenticationSession session2 = sessionManager.findBySessionId(session1.getSessionid());

    Assert.assertNotNull("Result session2 is not null!", session1);
    Assert.assertEquals("Result session has the same session-id as session1!", session1.getSessionid(), session2.getSessionid());
    Assert.assertEquals("Result session has the same token as session1!", session1.getToken(), session2.getToken());
  }

  @Test
  public void testFindByToken() throws Exception {
    final String newEmail1 = "newEmail" + String.valueOf(System.currentTimeMillis());
    final UserAuthenticationSession session1 = sessionManager.addSession(newEmail1);

    final UserAuthenticationSession session2 = sessionManager.findByToken(session1.getToken());

    Assert.assertNotNull("Result session2 is not null!", session1);
    Assert.assertEquals("Result session has the same session-id as session1!", session1.getSessionid(), session2.getSessionid());
    Assert.assertEquals("Result session has the same token as session1!", session1.getToken(), session2.getToken());
  }

  @Test
  public void testUpdateByToken() throws Exception {
    final String newEmail1 = "newEmail" + String.valueOf(System.currentTimeMillis());
    final UserAuthenticationSession session1 = sessionManager.addSession(newEmail1);

    final UserAuthenticationSession session2 = sessionManager.updateByToken(session1.getToken());

    Assert.assertNotNull("Result session2 is not null!", session1);
    Assert.assertEquals("Result session has the same session-id as session1!", session1.getSessionid(), session2.getSessionid());
    Assert.assertEquals("Result session has the same token as session1!", session1.getToken(), session2.getToken());
    Assert.assertEquals("Result session has the same session-id as session1!", session1.getSessionid(), session2.getSessionid());
  }

  @Test
  public void testUpdateUser() throws Exception {

  }
}
