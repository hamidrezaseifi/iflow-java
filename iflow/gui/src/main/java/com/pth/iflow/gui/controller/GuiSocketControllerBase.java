package com.pth.iflow.gui.controller;

import java.security.Principal;

import com.pth.iflow.gui.authentication.GuiAuthenticationToken;

public class GuiSocketControllerBase {

  protected boolean isPrincipalValidAndLoggedIn(final Principal principal) {

    return principal != null && principal instanceof GuiAuthenticationToken;
  }
}
