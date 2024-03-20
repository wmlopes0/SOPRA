package com.example.controller;

import com.example.model.Employee;
import com.example.model.EmployeeDTO;
import com.example.model.EmployeeNameDetailsDTO;
import com.example.repository.EmployeeRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@OpenAPIDefinition(info = @Info(title = "Employees API", version = "1.0", description = "This is my first API with Spring Boot, a simple example with crud operations and documentation with Swagger"))
@AllArgsConstructor
@RestController
@RequestMapping("/employees")
public class EmployeeRestController {

    private final EmployeeRepository employeeRepository;

    @Operation(summary = "More information...", description = "This endpoint lists all employees in the database")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @GetMapping("/")
    public ResponseEntity<List<EmployeeNameDetailsDTO>> listEmployees() {
        List<EmployeeNameDetailsDTO> result = employeeRepository.findAll().stream()
                .map(e -> new EmployeeNameDetailsDTO(e.getNumber(), e.getName().toUpperCase(),e.getName().length()))
                .toList();
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "More information...", description = "This endpoint obtains information about an employee by their ID")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @ApiResponse(responseCode = "404", description = "Bad request due to id not found")
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeNameDetailsDTO> getEmployeeById(@PathVariable("id") Long id) {
        return employeeRepository.findById(id)
                .map(e -> new EmployeeNameDetailsDTO(e.getNumber(), e.getName().toUpperCase(),e.getName().length()))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "More information...", description = "This endpoint gets information about an employee that contains that string in their name")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @ApiResponse(responseCode = "404", description = "Bad request due to no match found")
    @GetMapping("/name/{name}")
    public ResponseEntity<EmployeeNameDetailsDTO> getEmployeeByName(@PathVariable("name") String name) {
        return employeeRepository.findFirstByNameContainingIgnoreCase(name)
                .map(e -> new EmployeeNameDetailsDTO(e.getNumber(), e.getName().toUpperCase(),e.getName().length()))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "More information...", description = "This endpoint gets adds an employee to the database")
    @ApiResponse(responseCode = "201", description = "Successful operation")
    @PostMapping("/")
    public ResponseEntity<Employee> newEmployee(@RequestBody EmployeeDTO employeeRequest) {
        Employee newEmployee = new Employee();
        newEmployee.setName(employeeRequest.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeRepository.save(newEmployee));
    }

    @Operation(summary = "More information...", description = "This endpoint updates information for a given employee")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @ApiResponse(responseCode = "404", description = "Bad request due to id not found")
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable("id") Long id, @RequestBody EmployeeDTO employeeUpdate) {
        Employee employee = employeeRepository.findById(id)
                .map(emp -> {
                            emp.setName(employeeUpdate.getName());
                            return employeeRepository.save(emp);
                        }
                ).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empleado no encontrado con ID: " + id));
        return ResponseEntity.ok(employee);
    }

    @Operation(summary = "More information...", description = "This endpoint removes a given employee from the database by their id")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @ApiResponse(responseCode = "404", description = "Bad request due to id not found")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletedEmployeeById(@PathVariable("id") Long id) {
        return employeeRepository.findById(id)
                .map(emp -> {
                    employeeRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
