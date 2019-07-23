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
  private String backendValidEMail;
  
  private UserAuthenticationSession backendValidSession = null;
  
  private static final Logger logger = LoggerFactory.getLogger(ProfileSessionManager.class);

  private static final int               SESSION_AGE_LIMIT = 7200;
  Map<String, UserAuthenticationSession> sessions          = new HashMap<>();

  @PostConstruct
  public void init() {
    this.backendValidSession = addSession(this.backendValidEMail);
  }
  
  @Override
  public UserAuthenticationSession findByEmail(final String email) {

    logger.debug("Finding session by email:{}", email);

    for (final String sessionId : this.sessions.keySet()) {
      final UserAuthenticationSession session = this.sessions.get(sessionId);
      if (session.getEmail().equals(email)) {
        logger.debug("Session {} found for email:{}", sessionId, email);
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

    final UserAuthenticationSession session = findByToken(token);
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
  public UserAuthenticationSession addSession(final String email) {
    UserAuthenticationSession session = findByEmail(email);

    if (session != null) {
      return session;
    }

    final String ts = String.valueOf(System.currentTimeMillis());
    final String rand = UUID.randomUUID().toString() + ts;
    final String sessionid = DigestUtils.md5Hex(rand);

    session = new UserAuthenticationSession(SESSION_AGE_LIMIT);
    session.setSessionid(sessionid);
    session.setToken(generateToken(email));
    session.setEmail(email);
    session.update();

    this.sessions.put(sessionid, session);

    logger.debug("Session {} with token {] add for email:{}", sessionid, session.getToken(), email);

    return session;
  }

  @Override
  public UserAuthenticationSession updateUser(final String email, final String sessionId) {
    findBySessionId(sessionId).setEmail(email).update();

    return findBySessionId(sessionId);
  }

  private String generateToken(final String email) {

    final String token = "PFTKS{" + encodeBase64(email + "-" + System.currentTimeMillis()) + "}PFTKE";

    return token;
  }

  private String encodeBase64(final String text) {
    return Base64.getEncoder().encodeToString(text.getBytes(Charset.forName("UTF-8")));
  }

  @Override
  public UserAuthenticationSession findValidateByEmail(final String email, final boolean removeInvalid) {

    final UserAuthenticationSession session = findByEmail(email);
    if (session != null) {
      if (session.isValid()) {
        return session;
      }
      else {
        this.sessions.remove(session.getSessionid());
      }
    }

    return null;
  }
  
  /**
   * @return the backendValidEMail
   */
  @Override
  public String getBackendValidEMail() {
    return this.backendValidEMail;
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

}
