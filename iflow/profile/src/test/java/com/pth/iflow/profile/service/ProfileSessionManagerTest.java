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
import com.pth.iflow.profile.service.handler.ISessionManager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProfileSessionManagerTest extends TestDataProducer {

  @Autowired
  private ISessionManager           sessionManager;

  private final String              validCompanyIdentity = "valid-company";

  private final String              initialEmail         = "valid-email";

  private UserAuthenticationSession initialSession       = null;

  @Before
  public void setUp() throws Exception {

    this.initialSession = this.sessionManager.addSession(this.initialEmail, this.validCompanyIdentity);

  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testCheckBackendSessionExists() throws Exception {

    final UserAuthenticationSession session = this.sessionManager.getBackendValidSession();

    Assert.assertNotNull("Result session is not null!", session);
    Assert.assertEquals("Result session has the same session-id as initial!", session.getUserIdentity(),
        this.sessionManager.getBackendValidUserIdentity());

  }

  @Test
  public void testAddSession() throws Exception {

    UserAuthenticationSession session = this.sessionManager.addSession(this.initialEmail, this.validCompanyIdentity);

    Assert.assertNotNull("Result session is not null!", session);
    Assert.assertEquals("Result session has the same session-id as initial!", session.getSessionid(),
        this.initialSession.getSessionid());
    Assert.assertEquals("Result session has the same token as initial!", session.getToken(), this.initialSession.getToken());

    final String newEmail = "newEmail" + String.valueOf(System.currentTimeMillis());
    session = this.sessionManager.addSession(newEmail, this.validCompanyIdentity);

    Assert.assertNotNull("Result session is not null!", session);
    Assert.assertNotEquals("Result session has not the same session-id as initial!", session.getSessionid(),
        this.initialSession.getSessionid());
    Assert.assertNotEquals("Result session has the same token as initial!", session.getToken(), this.initialSession.getToken());

  }

  @Test
  public void testFindByEmail() throws Exception {

    final String newEmail1 = "newEmail" + String.valueOf(System.currentTimeMillis());
    final UserAuthenticationSession session1 = this.sessionManager.addSession(newEmail1, this.validCompanyIdentity);

    final UserAuthenticationSession session2 = this.sessionManager.findByUserIdentity(newEmail1);

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
    final UserAuthenticationSession session1 = this.sessionManager.addSession(newEmail1, this.validCompanyIdentity);

    final UserAuthenticationSession session2 = this.sessionManager.findBySessionId(session1.getSessionid());

    Assert.assertNotNull("Result session2 is not null!", session1);
    Assert.assertEquals("Result session has the same session-id as session1!", session1.getSessionid(), session2.getSessionid());
    Assert.assertEquals("Result session has the same token as session1!", session1.getToken(), session2.getToken());
  }

  @Test
  public void testFindByToken() throws Exception {
    final String newEmail1 = "newEmail" + String.valueOf(System.currentTimeMillis());
    final UserAuthenticationSession session1 = this.sessionManager.addSession(newEmail1, this.validCompanyIdentity);

    final UserAuthenticationSession session2 = this.sessionManager.findByToken(session1.getToken());

    Assert.assertNotNull("Result session2 is not null!", session1);
    Assert.assertEquals("Result session has the same session-id as session1!", session1.getSessionid(), session2.getSessionid());
    Assert.assertEquals("Result session has the same token as session1!", session1.getToken(), session2.getToken());
  }

  @Test
  public void testUpdateByToken() throws Exception {
    final String newEmail1 = "newEmail" + String.valueOf(System.currentTimeMillis());
    final UserAuthenticationSession session1 = this.sessionManager.addSession(newEmail1, this.validCompanyIdentity);

    final UserAuthenticationSession session2 = this.sessionManager.updateByToken(session1.getToken());

    Assert.assertNotNull("Result session2 is not null!", session1);
    Assert.assertEquals("Result session has the same session-id as session1!", session1.getSessionid(), session2.getSessionid());
    Assert.assertEquals("Result session has the same token as session1!", session1.getToken(), session2.getToken());
    Assert.assertEquals("Result session has the same session-id as session1!", session1.getSessionid(), session2.getSessionid());
  }

  @Test
  public void testRemoveSession() throws Exception {

    String newEmail = "newEmail" + String.valueOf(System.currentTimeMillis());
    UserAuthenticationSession session = this.sessionManager.addSession(newEmail, this.validCompanyIdentity);

    Assert.assertNotNull("Result session is not null!", session);
    Assert.assertNotEquals("Result session has not the same session-id as initial!", session.getSessionid(),
        this.initialSession.getSessionid());
    Assert.assertNotEquals("Result session has the same token as initial!", session.getToken(), this.initialSession.getToken());

    this.sessionManager.removeExpiredSession(session.getSessionid());
    session = this.sessionManager.findByUserIdentity(newEmail);
    Assert.assertNull("Result session is nul means it is deleted!", session);

    newEmail = "newEmail-ses" + String.valueOf(System.currentTimeMillis());
    session = this.sessionManager.addSession(newEmail, this.validCompanyIdentity);

    Assert.assertNotNull("Result session is not null!", session);
    Assert.assertNotEquals("Result session has not the same session-id as initial!", session.getSessionid(),
        this.initialSession.getSessionid());
    Assert.assertNotEquals("Result session has the same token as initial!", session.getToken(), this.initialSession.getToken());

    this.sessionManager.removeExpiredSession(session);
    session = this.sessionManager.findByUserIdentity(newEmail);
    Assert.assertNull("Result session is nul means it is deleted!", session);
  }

  @Test
  public void testRemoveExpiredSession() throws Exception {

    String newEmail = "newEmail" + String.valueOf(System.currentTimeMillis());
    UserAuthenticationSession session = this.sessionManager.addSession(newEmail, this.validCompanyIdentity);

    Assert.assertNotNull("Result session is not null!", session);
    Assert.assertNotEquals("Result session has not the same session-id as initial!", session.getSessionid(),
        this.initialSession.getSessionid());
    Assert.assertNotEquals("Result session has the same token as initial!", session.getToken(), this.initialSession.getToken());

    Thread.sleep(5000);

    session = this.sessionManager.findByUserIdentity(newEmail);

    Assert.assertNotNull("Result session is not null!", session);
    Assert.assertNotEquals("Result session has not the same session-id as initial!", session.getSessionid(),
        this.initialSession.getSessionid());
    Assert.assertNotEquals("Result session has the same token as initial!", session.getToken(), this.initialSession.getToken());

    this.sessionManager.setSessionMaxAge(3);
    newEmail = "newEmail" + String.valueOf(System.currentTimeMillis());
    session = this.sessionManager.addSession(newEmail, this.validCompanyIdentity);

    Assert.assertNotNull("Result session is not null!", session);
    Assert.assertNotEquals("Result session has not the same session-id as initial!", session.getSessionid(),
        this.initialSession.getSessionid());
    Assert.assertNotEquals("Result session has the same token as initial!", session.getToken(), this.initialSession.getToken());

    Thread.sleep(5000);

    this.sessionManager.removeAllExpiredSessions();

    session = this.sessionManager.findByUserIdentity(newEmail);
    Assert.assertNull("Result session is nul means it is deleted!", session);

    this.sessionManager.setSessionMaxAge(7200);
  }

  @Test
  public void testUpdateUser() throws Exception {

  }
}
