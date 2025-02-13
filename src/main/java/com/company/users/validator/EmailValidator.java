package com.company.users.validator;

import com.company.users.constraint.EmailConstraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailConstraint, String> {

  @Override
  public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
    return org.apache.commons.validator.routines.EmailValidator.getInstance().isValid(s);
  }
}
