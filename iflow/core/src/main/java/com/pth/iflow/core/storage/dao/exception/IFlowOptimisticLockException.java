package com.pth.iflow.core.storage.dao.exception;

import javax.validation.ValidationException;

public class IFlowOptimisticLockException extends ValidationException {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public IFlowOptimisticLockException(final String message) {
    super(message);
  }

}
