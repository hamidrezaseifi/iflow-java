package com.pth.iflow.gui.authentication;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import com.pth.iflow.gui.configurations.GuiSecurityConfigurations;

public class GuiAuthenticationErrorUrlCreator {

  public static String getErrorUrl(final String error, final String username, final String password, final String companyid) {

    final String url = "err=" + error + "&u=" + username + "&c=" + companyid; // no password in error url + "&p=" + password;

    final String encodedString = GuiSecurityConfigurations.LOGIN_URL + "?error="
        + Base64.getEncoder().encodeToString(url.getBytes());

    return encodedString;
  }

  public static Map<String, String> decodeErrorUrl(final String encodedString) throws UnsupportedEncodingException {

    final byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
    final String decodedString = new String(decodedBytes);

    final Map<String, String> queryPairs = new HashMap<>();

    final String[] pairs = decodedString.split("&");
    for (final String pair : pairs) {
      final int idx = pair.indexOf("=");
      queryPairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
    }
    return queryPairs;
  }

}
