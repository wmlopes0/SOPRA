package com.example.contract.employee.dto;

import com.example.contract.employee.validation.ValidGender;
import com.example.contract.employee.validation.ValidPhone;
import com.example.contract.employee.validation.ValidYearOfBirth;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Getter
@Setter
@EqualsAndHashCode
public class EmployeeUpdateDTO {

  @Size(min = 1, message = "Name cannot be empty")
  private String name;

  private String surname;

  @ValidYearOfBirth
  private Integer birthYear;

  @ValidGender(message = "Gender must be either 'Male' or 'Female'")
  private String gender;

  @ValidPhone
  private String personalPhone;

  private String companyPhone;

  @Email(message = "Invalid email format")
  private String email;
}