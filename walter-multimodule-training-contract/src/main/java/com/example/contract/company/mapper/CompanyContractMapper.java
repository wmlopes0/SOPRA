package com.example.contract.company.mapper;

import com.example.application.company.cmd.dto.CompanyCreateCmd;
import com.example.application.company.cmd.dto.CompanyDeleteCmd;
import com.example.application.company.cmd.dto.CompanyUpdateCmd;
import com.example.application.company.query.dto.CompanyByIdQuery;
import com.example.domain.entity.Company;
import com.example.domain.entity.Employee;
import org.example.rest.model.CompanyRequestDTO;
import org.example.rest.model.CompanyResponseDTO;
import org.example.rest.model.CompanyUpdateDTO;
import org.example.rest.model.EmployeeDTO;

public interface CompanyContractMapper {

  CompanyCreateCmd mapToCompanyCreateCmd(CompanyRequestDTO companyRequestDTO);

  CompanyDeleteCmd mapToCompanyDeleteCmd(String cif);

  CompanyUpdateCmd mapToCompanyUpdateCmd(String cif, CompanyUpdateDTO companyUpdateDTO);

  CompanyByIdQuery mapToCompanyByIdQuery(String cif);

  CompanyResponseDTO mapToCompanyResponseDTO(Company company);

  EmployeeDTO mapToEmployeeDTO(Employee employee);
}
