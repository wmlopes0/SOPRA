package com.example.application.employee.cmd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class RemoveEmployeeFromCompanyCmd {

  private String nif;

  private String cif;
}
