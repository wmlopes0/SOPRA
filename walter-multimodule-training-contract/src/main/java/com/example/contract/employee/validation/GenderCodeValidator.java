package com.example.contract.employee.validation;

import com.example.domain.entity.Gender;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GenderCodeValidator implements ConstraintValidator<ValidGenderCode, Integer> {

  @Override
  public boolean isValid(Integer value, ConstraintValidatorContext context) {
    if (value == null) {
      return true;
    }
    for (Gender g : Gender.values()) {
      if (g.getCode() == value) {
        return true;
      }
    }
    return false;
  }
}
