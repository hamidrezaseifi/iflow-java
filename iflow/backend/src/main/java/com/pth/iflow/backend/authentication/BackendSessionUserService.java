package com.pth.iflow.backend.authentication;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.pth.iflow.backend.models.ui.UiSessionUserInfo;
import com.pth.iflow.backend.models.ui.user.UiUser;

/**
 * A class to manage session-in user in session and Spring SecurityContext
 *
 * @author rezasei
 *
 */
@Service
public class BackendSessionUserService {

  @Autowired
  private UiSessionUserInfo sessionUserInfo;

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
  public UiSessionUserInfo authorizeUser(final BackendAuthenticationToken token, final HttpSession session, final boolean setContext) {

    if (setContext) {
      SecurityContext ctx = SecurityContextHolder.getContext();
      if (ctx == null) {
        ctx = SecurityContextHolder.createEmptyContext();
      }
      ctx.setAuthentication(token);
    }
    return this.setLoggedInUserInfo(token.getUser(), session);

  }

  public UiSessionUserInfo setLoggedInUserInfo(final UiUser user, final HttpSession session) {

    this.reloadSessionData(user);

    return this.sessionUserInfo;
  }

  public void reloadSessionData(final UiUser user) {

    this.sessionUserInfo.setUser(user);

  }

  public static void unsetLoggedUserInfo(final HttpSession session) {

    session.invalidate();
  }
}
