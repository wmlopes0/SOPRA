package com.example.application.employee.query.handler;

import com.example.application.employee.query.dto.EmployeeByIdQuery;
import com.example.domain.entity.Employee;

public interface EmployeeGetByIdHandler {

  Employee getEmployeeById(EmployeeByIdQuery employeeByIdQuery);

}
