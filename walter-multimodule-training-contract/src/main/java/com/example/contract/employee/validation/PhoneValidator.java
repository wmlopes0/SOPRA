package com.example.contract.employee.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<ValidPhone, String> {

  private static final String PHONE_PATTERN = "^\\+\\d{2}\\d{9}$";

  @Override
  public boolean isValid(String phoneField, ConstraintValidatorContext context) {
    if (phoneField == null) {
      return true;
    }
    return phoneField.matches(PHONE_PATTERN);
  }
}
