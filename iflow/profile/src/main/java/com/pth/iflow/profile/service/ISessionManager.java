package com.pth.iflow.profile.service;

import com.pth.iflow.profile.model.UserAuthenticationSession;

public interface ISessionManager {
  
  UserAuthenticationSession addSession(String email);

  UserAuthenticationSession findByEmail(String email);
  
  UserAuthenticationSession findValidateByEmail(String email, boolean removeInvalid);
  
  UserAuthenticationSession findBySessionId(String sessionId);
  
  UserAuthenticationSession findByToken(String token);
  
  UserAuthenticationSession updateByToken(String token);
  
  UserAuthenticationSession updateUser(String email, String sessionId);
  
  String getBackendValidEMail();
  
  UserAuthenticationSession getBackendValidSession();

  void removeAllExpiredSessions();

  void removeExpiredSession(UserAuthenticationSession session);

  void removeExpiredSession(String sessionId);
  
}
