package com.example.contract.company.mapper;

import java.util.ArrayList;
import java.util.List;

import com.example.application.company.cmd.dto.CompanyCreateCmd;
import com.example.application.company.cmd.dto.CompanyDeleteCmd;
import com.example.application.company.cmd.dto.CompanyUpdateCmd;
import com.example.application.company.query.dto.CompanyByIdQuery;
import com.example.contract.company.dto.CompanyRequestDTO;
import com.example.contract.company.dto.CompanyResponseDTO;
import com.example.contract.company.dto.CompanyUpdateDTO;
import com.example.contract.company.dto.EmployeeDTO;
import com.example.domain.entity.Company;
import com.example.domain.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class CompanyContractMapperImpl implements CompanyContractMapper {

  @Override
  public CompanyCreateCmd mapToCompanyCreateCmd(CompanyRequestDTO companyRequestDTO) {
    return new CompanyCreateCmd()
        .setCif(companyRequestDTO.getCif())
        .setName(companyRequestDTO.getName());
  }

  @Override
  public CompanyDeleteCmd mapToCompanyDeleteCmd(String cif) {
    return new CompanyDeleteCmd(cif);
  }

  @Override
  public CompanyUpdateCmd mapToCompanyUpdateCmd(String cif, CompanyUpdateDTO companyUpdateDTO) {
    return new CompanyUpdateCmd()
        .setCif(cif)
        .setName(companyUpdateDTO.getName());
  }

  @Override
  public CompanyByIdQuery mapToCompanyByIdQuery(String cif) {
    return new CompanyByIdQuery(cif);
  }

  @Override
  public CompanyResponseDTO mapToCompanyResponseDTO(Company company) {
    List<EmployeeDTO> employeeDTOs;
    if (company.getEmployees() == null) {
      employeeDTOs = new ArrayList<>();  // Retorna una lista vacía si los empleados son null
    } else {
      employeeDTOs = company.getEmployees().stream()
          .map(this::mapToEmployeeDTO)
          .toList();
    }

    return new CompanyResponseDTO()
        .setCif(company.getCif())
        .setName(company.getName())
        .setEmployees(employeeDTOs);
  }

  @Override
  public EmployeeDTO mapToEmployeeDTO(Employee employee) {
    return new EmployeeDTO()
        .setNif(employee.getNif())
        .setName(employee.getName())
        .setSurname(employee.getSurname())
        .setBirthYear(employee.getBirthYear())
        .setGender(employee.getGender().name())
        .setCompanyPhone(employee.getCompanyPhone())
        .setPersonalPhone(employee.getPersonalPhone())
        .setCompany(employee.getCompany())
        .setEmail(employee.getEmail());
  }

}
