package com.company.users.constraint;

import com.company.users.validator.EmailValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = EmailValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailConstraint {

  String message() default "Invalid Email";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
