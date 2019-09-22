package com.pth.iflow.common.edo.models.validation;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.NotNull;

import com.pth.iflow.common.enums.base.IValueList;

public class EnumValueValidator implements ConstraintValidator<AEnumValueValidator, String> {

  private final Set<@NotNull String> validValues = new HashSet<>();

  @Override
  public void initialize(final AEnumValueValidator constraintAnnotation) {

    final Class<? extends IValueList> enumClass = constraintAnnotation.enumClazz();

    final IValueList[] enumValArr = enumClass.getEnumConstants();

    for (final IValueList enumVal : enumValArr) {
      this.validValues.add(enumVal.getValue().toString());
    }

  }

  @Override
  public boolean isValid(final String value, final ConstraintValidatorContext context) {
    return this.validValues.contains(value);
  }

}
