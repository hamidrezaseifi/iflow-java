package com.pth.iflow.gui.services.impl;

import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

import com.pth.iflow.gui.services.IMessagesHelper;

/**
 * read message labels from message property file
 *
 * @author rezasei
 *
 */
@Component
public class MessagesHelper implements IMessagesHelper {
  
  @Autowired
  private MessageSource messageSource;
  
  private MessageSourceAccessor accessor;
  
  @PostConstruct
  private void init() {
    this.accessor = new MessageSourceAccessor(this.messageSource, Locale.GERMAN);
  }
  
  /*
   * (non-Javadoc)
   * @see de.tui.cssi.mdm.ui.helpers.IMessagesHelper#get(java.lang.String)
   */
  @Override
  public String get(final String code) {
    return this.accessor.getMessage(code);
  }
  
  /*
   * (non-Javadoc)
   * @see de.tui.cssi.mdm.ui.helpers.IMessagesHelper#get(java.lang.String, java.lang.Object)
   */
  @Override
  public String get(final String code, final Object... args) {
    return String.format(this.accessor.getMessage(code), args);
  }
  
}
