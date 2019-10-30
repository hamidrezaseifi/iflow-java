package com.pth.iflow.profile.service.impl;

import java.nio.charset.Charset;
import java.util.Base64;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pth.iflow.profile.model.UserAuthenticationSession;
import com.pth.iflow.profile.service.ISessionManager;

@Service
public class ProfileSessionManager implements ISessionManager {

  @Value("${iflow.backend.valid-email}")
  private String                         backendValidUserIdentity;

  @Value("${iflow.profile.session-maxage:7200}")
  private int                            sessionMaxAge;

  private UserAuthenticationSession      backendValidSession = null;

  private static final Logger            logger              = LoggerFactory.getLogger(ProfileSessionManager.class);

  Map<String, UserAuthenticationSession> sessions            = new HashMap<>();

  @PostConstruct
  public void init() {
    this.backendValidSession = this.addSession(this.backendValidUserIdentity, "iflow");
    this.backendValidSession.setFixedSession(true);
  }

  @Override
  public UserAuthenticationSession findByUserIdentity(final String userIdentity) {

    logger.debug("Finding session by userIdentity");

    for (final String sessionId : this.sessions.keySet()) {
      final UserAuthenticationSession session = this.sessions.get(sessionId);
      if (session.hasUserIdentity(userIdentity)) {
        return session;
      }
    }

    return null;
  }

  @Override
  public UserAuthenticationSession findBySessionId(final String sessionId) {
    return this.sessions.keySet().contains(sessionId) ? this.sessions.get(sessionId) : null;
  }

  @Override
  public UserAuthenticationSession updateByToken(final String token) {

    final UserAuthenticationSession session = this.findByToken(token);
    if (session != null) {
      session.update();
      return session;
    }

    return null;
  }

  @Override
  public UserAuthenticationSession findByToken(final String token) {
    for (final String sessionId : this.sessions.keySet()) {
      final UserAuthenticationSession session = this.sessions.get(sessionId);
      if (session.getToken().equals(token)) {
        logger.debug("Session {} found for token:{}", sessionId, token);
        return session;
      }
    }

    return null;
  }

  @Override
  public UserAuthenticationSession addSession(final String userIdentity, final String companyIdentity) {
    UserAuthenticationSession session = this.findByUserIdentity(userIdentity);

    if (session != null) {
      return session;
    }

    final String ts = String.valueOf(System.currentTimeMillis());
    final String rand = UUID.randomUUID().toString() + ts;
    final String sessionid = DigestUtils.md5Hex(rand);

    session = new UserAuthenticationSession(userIdentity, companyIdentity, this.sessionMaxAge);
    session.setSessionid(sessionid);
    session.setToken(this.generateToken(userIdentity));
    session.update();

    this.sessions.put(sessionid, session);

    logger.debug("Session add for userIdentity");

    return session;
  }

  @Override
  public UserAuthenticationSession updateUser(final String userIdentity, final String sessionId) {
    this.findBySessionId(sessionId).setUserIdentity(userIdentity).update();

    return this.findBySessionId(sessionId);
  }

  private String generateToken(final String userIdentity) {

    final String token = "PFTKS{" + this.encodeBase64(userIdentity + "-" + System.currentTimeMillis()) + "}PFTKE";

    return token;
  }

  private String encodeBase64(final String text) {
    return Base64.getEncoder().encodeToString(text.getBytes(Charset.forName("UTF-8")));
  }

  @Override
  public UserAuthenticationSession findValidateByUserIdentity(final String userIdentity, final String companyIdentity,
      final boolean removeInvalid) {

    final UserAuthenticationSession session = this.findByUserIdentity(userIdentity);
    if (session != null && session.hasCompanyIdentity(companyIdentity)) {
      if (session.isValid()) {
        return session;
      } else {
        this.sessions.remove(session.getSessionid());
      }
    }

    return null;
  }

  /**
   * @return the backendValidEMail
   */
  @Override
  public String getBackendValidUserIdentity() {
    return this.backendValidUserIdentity;
  }

  /**
   * @return the backendValidSession
   */
  @Override
  public UserAuthenticationSession getBackendValidSession() {
    return this.backendValidSession;
  }

  @Override
  public void removeAllExpiredSessions() {

    final Set<String> expiredSet = new HashSet<>();

    for (final String sessionId : this.sessions.keySet()) {
      final UserAuthenticationSession session = this.sessions.get(sessionId);
      if (session.isValid() == Boolean.FALSE) {
        expiredSet.add(sessionId);
      }
    }

    for (final String sessionId : expiredSet) {
      this.sessions.remove(sessionId);
    }

  }

  @Override
  public void removeExpiredSession(final UserAuthenticationSession session) {
    this.sessions.remove(session.getSessionid());

  }

  @Override
  public void removeExpiredSession(final String sessionId) {
    this.sessions.remove(sessionId);

  }

  /**
   * @return the sessionMaxAge
   */
  @Override
  public int getSessionMaxAge() {
    return this.sessionMaxAge;
  }

  /**
   * @param sessionMaxAge the sessionMaxAge to set
   */
  @Override
  public void setSessionMaxAge(final int sessionMaxAge) {
    this.sessionMaxAge = sessionMaxAge;
  }

}
