package com.pth.iflow.gui.controller.data;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pth.iflow.gui.controller.GuiSocketControllerBase;

@Controller
@RequestMapping(value = "/")
public class SocketDataController extends GuiSocketControllerBase {

  @Autowired
  SimpMessagingTemplate simpMessagingTemplate;

  @MessageMapping("/start")
  @SendTo("/socket/test")
  public Map<String, Object> greeting(final Map<String, Object> message) throws Exception {

    final Object sentMessage = message.keySet().contains("sentMessage") ? message.get("sentMessage") : "not found!";

    final Map<String, Object> map = new HashMap<>();
    map.put("msg", sentMessage);
    map.put("status", "received");

    Thread.sleep(100);
    return map;
  }

  @MessageMapping("/resetmessage")
  @SendToUser("/socket/messages")
  public Map<String, Object> resetMessageSocket(final Map<String, String> message, final Principal principal,
      final SimpMessageHeaderAccessor headerAccessor) throws Exception {

    final Map<String, Object> map = new HashMap<>();

    map.put("status", "process");

    if (this.isPrincipalValidAndLoggedIn(principal)) {
      // final GuiAuthenticationToken guiAuth = (GuiAuthenticationToken) principal;

      map.put("command", "message-reload");
      map.put("status", "done");
    }

    return map;
  }

}
