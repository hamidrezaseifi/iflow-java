package com.pth.iflow.gui.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@CrossOrigin
@Configuration
@EnableWebSocketMessageBroker
public class GuiWebSocketConfig implements WebSocketMessageBrokerConfigurer {

  @Override
  public void configureMessageBroker(final MessageBrokerRegistry config) {

    config.enableSimpleBroker("/socket");
    config.setApplicationDestinationPrefixes("/socketapp");
    // config.setUserDestinationPrefix("/socket/user");
  }

  @Override
  public void registerStompEndpoints(final StompEndpointRegistry registry) {

    registry
        .addEndpoint("/iflow-guide-websocket")
        .setAllowedOrigins("*")
        .withSockJS()
        .setClientLibraryUrl("https://cdn.jsdelivr.net/sockjs/1.4.0/sockjs.min.js");
  }

}
