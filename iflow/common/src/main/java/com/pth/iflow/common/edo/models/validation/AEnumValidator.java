package com.pth.iflow.common.edo.models.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;

import com.pth.iflow.common.enums.IEnumNameValidator;

@Documented
@Constraint(validatedBy = EnumValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@ReportAsSingleViolation
public @interface AEnumValidator {

	  Class<? extends IEnumNameValidator> enumClazz();

	  String message() default "Enum value is not valid";

	  Class<?>[] groups() default {
	  };

	  Class<? extends Payload>[] payload() default {};

}
