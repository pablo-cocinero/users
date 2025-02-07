package com.company.users.constraint;

import com.company.users.validator.PasswordValidator;
import javax.validation.Constraint;

@Constraint(validatedBy = PasswordValidator.class)
public @interface PasswordConstraint {

  String message() default "Invalid Password";
}
