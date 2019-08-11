package com.pth.iflow.backend.authentication;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.pth.iflow.backend.models.BackendCompany;
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

  /**
   * this function check the from remote server authenticated user if it has
   * access to mdm or not and if has, it will set in session and if setContext is
   * set it create the security context too
   *
   * @param username
   * @param session
   * @param setContext
   * @return the new UiSessionUserInfo or null
   */
  public BackendSessionUserInfo authorizeUser(final BackendAuthenticationToken token, final HttpSession session,
      final boolean setContext) {

    if (setContext) {
      SecurityContext ctx = SecurityContextHolder.getContext();
      if (ctx == null) {
        ctx = SecurityContextHolder.createEmptyContext();
      }
      ctx.setAuthentication(token);
    }
    return this.setLoggedInUserInfo(token.getUser(), token.getCompany(), session);

  }

  public BackendSessionUserInfo setLoggedInUserInfo(final BackendUser user, final BackendCompany company, final HttpSession session) {

    this.reloadSessionData(user, company);

    return this.sessionUserInfo;
  }

  public void reloadSessionData(final BackendUser user, final BackendCompany company) {

    this.sessionUserInfo.setCompany(company);
    this.sessionUserInfo.setUser(user);

  }

  public static void unsetLoggedUserInfo(final HttpSession session) {

    session.invalidate();
  }
}
