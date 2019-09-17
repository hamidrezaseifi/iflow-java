package com.pth.iflow.common.edo.models.validation;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.NotNull;

import com.pth.iflow.common.enums.IValidatorEnum;

public class EnumValidator implements ConstraintValidator<AEnumValidator, String> {
	
	  private final Set<@NotNull String> validValues = new HashSet<>();

	  @Override
	  public void initialize(final AEnumValidator constraintAnnotation) {

	    final Class<? extends IValidatorEnum> enumClass = constraintAnnotation.enumClazz();

	    final IValidatorEnum[] enumValArr = enumClass.getEnumConstants();

	    for (final IValidatorEnum enumVal : enumValArr) {
	      validValues.add(enumVal.getName());
	    }

	  }

	  /*
	   * (non-Javadoc)
	   *
	   * @see javax.validation.ConstraintValidator#isValid(java.lang.Object, javax.validation.ConstraintValidatorContext)
	   */
	  @Override
	  public boolean isValid(final String value, final ConstraintValidatorContext context) {
	    return validValues.contains(value);
	  }

}
