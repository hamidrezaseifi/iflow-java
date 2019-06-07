package com.pth.iflow.core.storage.dao.exception;

import javax.validation.ValidationException;

public class IFlowStorageException extends ValidationException {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public IFlowStorageException(final String message) {
    super(message);
  }

  public IFlowStorageException(final String message, final Exception causedby) {
    super(message, causedby);
  }
}
