package com.example.infrastructure.entity;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@Document("employees")
public class EmployeeEntity {

  @Id
  private String nif;

  @NotNull(message = "Name cannot be null")
  private String name;

  private String lastName;

  @NotNull(message = "Birth year cannot be null")
  private int birthYear;

  private int gender;

  @NotNull(message = "Phone list cannot be null")
  @Size(min = 1, message = "Phone list cannot be empty")
  private List<PhoneEntity> phones;

  private String company;

  @NotNull(message = "Email cannot be null")
  private String email;
}
