package com.pth.iflow.backend.authentication;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.pth.iflow.backend.models.BackendCompanyProfile;
import com.pth.iflow.backend.models.BackendUser;
import com.pth.iflow.backend.models.ui.BackendSessionUserInfo;

/**
 * A class to manage session-in user in session and Spring SecurityContext
 *
 * @author rezasei
 *
 */
@Service
public class BackendSessionUserService {

  @Autowired
  private BackendSessionUserInfo sessionUserInfo;

  public BackendSessionUserInfo authorizeUser(final BackendAuthenticationToken token, final BackendUser user,
      final BackendCompanyProfile companyProfile, final HttpSession session, final boolean setContext) {

    if (setContext) {
      SecurityContext ctx = SecurityContextHolder.getContext();
      if (ctx == null) {
        ctx = SecurityContextHolder.createEmptyContext();
      }
      ctx.setAuthentication(token);
    }
    return this.setLoggedInUserInfo(user, companyProfile, session);

  }

  public BackendSessionUserInfo setLoggedInUserInfo(final BackendUser user, final BackendCompanyProfile companyProfile,
      final HttpSession session) {

    this.reloadSessionData(user, companyProfile);

    return this.sessionUserInfo;
  }

  public void reloadSessionData(final BackendUser user, final BackendCompanyProfile companyProfile) {

    this.sessionUserInfo.setCompanyProfil(companyProfile);
    this.sessionUserInfo.setUser(user);
    this.sessionUserInfo.update();

  }

  public static void unsetLoggedUserInfo(final HttpSession session) {

    session.invalidate();
  }
}
