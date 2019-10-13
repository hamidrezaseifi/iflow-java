package com.pth.iflow.gui.authentication;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.pth.iflow.gui.models.CompanyProfile;
import com.pth.iflow.gui.models.User;
import com.pth.iflow.gui.models.ui.SessionUserInfo;

/**
 * A class to manage session-in user in session and Spring SecurityContext
 *
 * @author rezasei
 *
 */
@Service
public class GuiSessionUserService {

  @Autowired
  private SessionUserInfo sessionUserInfo;

  public SessionUserInfo authorizeUser(final GuiAuthenticationToken token, final User user,
      final CompanyProfile companyProfile, final HttpSession session, final boolean setContext) {

    if (setContext) {
      SecurityContext ctx = SecurityContextHolder.getContext();
      if (ctx == null) {
        ctx = SecurityContextHolder.createEmptyContext();
      }
      ctx.setAuthentication(token);
    }
    return this.setLoggedInUserInfo(token, user, companyProfile, session);

  }

  public SessionUserInfo setLoggedInUserInfo(final GuiAuthenticationToken token, final User user,
      final CompanyProfile companyProfile, final HttpSession session) {

    this.reloadSessionData(token, user, companyProfile);

    return this.sessionUserInfo;
  }

  public void reloadSessionData(final GuiAuthenticationToken token, final User user,
      final CompanyProfile companyProfile) {

    this.sessionUserInfo.setCompanyProfile(companyProfile);
    this.sessionUserInfo.setUser(user);
    this.sessionUserInfo.setToken(token.getToken());
    this.sessionUserInfo.setSessionId(token.getSessionId());
    this.sessionUserInfo.update();

  }

  public static void unsetLoggedUserInfo(final HttpSession session) {

    session.invalidate();
  }
}
