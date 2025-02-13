package com.company.users.constraint;

import com.company.users.validator.EmailValidator;
import javax.validation.Constraint;

@Constraint(validatedBy = EmailValidator.class)
public @interface EmailConstraint {

  String message() default "Invalid Email";
}
