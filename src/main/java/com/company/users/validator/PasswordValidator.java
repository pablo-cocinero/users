package com.company.users.validator;

import com.company.users.constraint.PasswordConstraint;
import java.util.Arrays;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.passay.AllowedRegexRule;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.IllegalRegexRule;
import org.passay.LengthRule;
import org.passay.PasswordData;

public class PasswordValidator implements ConstraintValidator<PasswordConstraint, String> {

  @Override
  public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
    org.passay.PasswordValidator passwordValidator = new org.passay.PasswordValidator(Arrays.asList(
        // Length between 8 and 12 characters
        new LengthRule(8, 12),

        // At least one uppercase letter
        new CharacterRule(EnglishCharacterData.UpperCase, 1),

        // Prohibit more than one uppercase letter
        new IllegalRegexRule(".*[A-Z].*[A-Z].*"), // If two or more uppercase letters exist, fail

        // At least two digits
        new CharacterRule(EnglishCharacterData.Digit, 2),

        // Prohibit more than two digits
        new IllegalRegexRule(".*\\d.*\\d.*\\d.*"), // If three or more digits exist, fail

        // Only allows letters and digits (no special characters)
        new AllowedRegexRule("^[A-Za-z0-9]+$")
    ));

    return passwordValidator.validate(new PasswordData(s)).isValid();
  }
}
