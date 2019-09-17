package com.pth.iflow.core.model.exceptions;

public class MessageConversionFailureException extends Exception {

	  private static final long serialVersionUID = 1L;

	  public MessageConversionFailureException(final String message, final Exception cause) {
	    super(message, cause);
	  }

	  public MessageConversionFailureException(final String message) {
	    super(message);
	  }

	  public MessageConversionFailureException(final Throwable cause) {
	    super(cause);
	  }

}