package com.pth.ifow.profile.service.impl;

import java.nio.charset.Charset;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pth.ifow.profile.model.User;
import com.pth.ifow.profile.model.UserAuthenticationSession;
import com.pth.ifow.profile.service.ISessionManager;

@Service
public class ProfileSessionManager implements ISessionManager {

  private static final Logger logger = LoggerFactory.getLogger(ProfileSessionManager.class);

  private static final int SESSION_AGE_LIMIT = 7200;
  Map<String, UserAuthenticationSession> sessions = new HashMap<>();

  @Override
  public UserAuthenticationSession findByEmail(final String email) {

    logger.debug("Finding session by email:{}" , email);

    for(final String sessionId : sessions.keySet()) {
      final UserAuthenticationSession session = sessions.get(sessionId);
      if(session.getUser().getEmail().equals(email)) {
        logger.debug("Session {} found for email:{}" , sessionId, email);
        return session;
      }
    }

    return null;
  }

  @Override
  public UserAuthenticationSession findBySessionId(final String sessionId) {
    return sessions.keySet().contains(sessionId) ? sessions.get(sessionId) : null;
  }

  @Override
  public UserAuthenticationSession updateByToken(final String token) {

    final UserAuthenticationSession session = findByToken(token);
    if(session != null) {
      session.update();
      return session;
    }

    return null;
  }

  @Override
  public UserAuthenticationSession findByToken(final String token) {
    for(final String sessionId : sessions.keySet()) {
      final UserAuthenticationSession session = sessions.get(sessionId);
      if(session.getToken().equals(token)) {
        logger.debug("Session {} found for token:{}" , sessionId, token);
        return session;
      }
    }

    return null;
  }

  @Override
  public UserAuthenticationSession addSession(final User user) {
    final String ts = String.valueOf(System.currentTimeMillis());
    final String rand  = UUID.randomUUID().toString() + ts;
    final String sessionid = DigestUtils.md5Hex(rand);

    final UserAuthenticationSession session = new UserAuthenticationSession(SESSION_AGE_LIMIT);
    session.setSessionid(sessionid);
    session.setToken(generateToken(user));
    session.setUser(user);
    session.update();

    sessions.put(sessionid, session);

    logger.debug("Session {} with token {] add for email:{}" , sessionid, session.getToken(), user.getEmail());

    return session;
  }


  @Override
  public UserAuthenticationSession updateUser(final User user, final String sessionId) {
    findBySessionId(sessionId).setUser(user).update();

    return findBySessionId(sessionId);
  }

  private String generateToken(final User user){

    final String token = "PFTKS{" + encodeBase64(user.getEmail())  + "}PFTKE";

    return token;
  }

  private String encodeBase64(final String text){
    return Base64.getEncoder().encodeToString(text.getBytes(Charset.forName("UTF-8")));
  }

  @Override
  public UserAuthenticationSession findValidateByEmail(final String email, final boolean removeInvalid) {

    final UserAuthenticationSession session = findByEmail(email);
    if(session != null) {
      if(session.isValid()) {
        return session;
      }
      else {
        sessions.remove(session.getSessionid());
      }
    }

    return null;
  }

}
