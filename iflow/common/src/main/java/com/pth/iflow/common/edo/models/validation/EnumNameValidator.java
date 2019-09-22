package com.pth.iflow.common.edo.models.validation;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.NotNull;

import com.pth.iflow.common.enums.IEnumNameValidator;

public class EnumNameValidator implements ConstraintValidator<AEnumNameValidator, String> {
	
	  private final Set<@NotNull String> validValues = new HashSet<>();

	  @Override
	  public void initialize(final AEnumNameValidator constraintAnnotation) {

	    final Class<? extends IEnumNameValidator> enumClass = constraintAnnotation.enumClazz();

	    final IEnumNameValidator[] enumValArr = enumClass.getEnumConstants();

	    for (final IEnumNameValidator enumVal : enumValArr) {
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
