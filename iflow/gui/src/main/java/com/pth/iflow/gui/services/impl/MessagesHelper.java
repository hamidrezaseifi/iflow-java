package com.pth.iflow.gui.services.impl;

import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

import com.pth.iflow.common.exceptions.EIFlowErrorType;
import com.pth.iflow.gui.services.IMessagesHelper;

/**
 * read message labels from message property file
 *
 * @author rezasei
 *
 */
@Component
public class MessagesHelper implements IMessagesHelper {

  private static final String   ERROR_TYPE_PREFIX = "error-type-";

  @Autowired
  private MessageSource         messageSource;

  private MessageSourceAccessor accessor;

  @PostConstruct
  private void init() {
    this.accessor = new MessageSourceAccessor(this.messageSource, Locale.GERMAN);
  }

  @Override
  public String get(final String code) {
    return this.accessor.getMessage(code);
  }

  @Override
  public String get(final String code, final Object... args) {
    return String.format(this.accessor.getMessage(code), args);
  }

  @Override
  public String getErrorMessage(final EIFlowErrorType errorType) {

    return this.accessor.getMessage(this.getErrorTypeMessageKey(errorType));
  }

  @Override
  public String getErrorMessage(final EIFlowErrorType errorType, final Object... args) {

    return String.format(this.accessor.getMessage(this.getErrorTypeMessageKey(errorType)), args);
  }

  private String getErrorTypeMessageKey(final EIFlowErrorType errorType) {
    return ERROR_TYPE_PREFIX + errorType.toString().toLowerCase();
  }

}
