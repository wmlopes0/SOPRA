package com.example.domain.vo;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class EmployeeUpdateVO {

  Long number;

  String name;
}