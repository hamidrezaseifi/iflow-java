package com.pth.iflow.core.service.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import com.pth.iflow.common.exceptions.IFlowMessageConversionFailureException;

public abstract class CoreModelEdoMapperService<M, E> {

  private final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();

  public abstract M fromEdo(E edo) throws IFlowMessageConversionFailureException;

  public abstract E toEdo(M model);

  public List<E> toEdoList(final List<M> modelList) {
    final List<E> edoList = new ArrayList<>();
    for (final M model : modelList) {
      edoList.add(toEdo(model));
    }

    return edoList;
  }

  public List<M> fromEdoList(final List<E> edoList) throws IFlowMessageConversionFailureException {
    final List<M> modelList = new ArrayList<>();
    for (final E edo : edoList) {
      modelList.add(fromEdo(edo));
    }

    return modelList;
  }

  protected <V> void validateCustomer(final V model) throws IFlowMessageConversionFailureException {
    final Set<ConstraintViolation<V>> violations = VALIDATOR.validate(model);
    if (violations != null && violations.size() > 0) {
      final String validationErrorMessage = createValidationErrorMessage(violations);
      throw new IFlowMessageConversionFailureException(validationErrorMessage);
    }
  }

  protected <V> String createValidationErrorMessage(final Set<ConstraintViolation<V>> violations) {
    final StringBuilder builder = new StringBuilder();
    builder.append("There are errors in the received XML:");
    builder.append(System.lineSeparator());
    for (final ConstraintViolation<V> violation : violations) {
      builder.append("Error " + violation.getRootBean().toString() + ") :");
      builder.append("(");
      builder.append(violation.getMessage());
      builder.append(": ");
      builder.append(violation.getInvalidValue());
      builder.append(System.lineSeparator());
    }
    return builder.toString();
  }
}
