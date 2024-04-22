package com.example.application.employee.mapper;

import java.util.stream.Stream;

import com.example.application.employee.cmd.dto.EmployeeCreateCmd;
import com.example.application.employee.cmd.dto.EmployeeDeleteCmd;
import com.example.application.employee.cmd.dto.EmployeeUpdateCmd;
import com.example.application.employee.query.dto.EmployeeByIdQuery;
import com.example.application.employee.query.dto.EmployeeByNameQuery;
import com.example.domain.entity.Gender;
import com.example.domain.vo.EmployeeNameVO;
import com.example.domain.vo.EmployeeNifVO;
import com.example.domain.vo.EmployeeVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class EmployeeApplicationMapperImplTest {

  private final EmployeeApplicationMapper mapper = new EmployeeApplicationMapperImpl();

  @ParameterizedTest
  @MethodSource("createCmdToVOParameters")
  @DisplayName("Mapping EmployeeCreateCmd to EmployeeVO correctly")
  void mapCreateCmdToEmployeeVOTest(EmployeeVO expected, EmployeeCreateCmd employeeCreateCmd) {
    EmployeeVO result = mapper.mapToEmployeeVO(employeeCreateCmd);
    Assertions.assertEquals(expected, result);
  }

  private static Stream<Arguments> createCmdToVOParameters() {
    return Stream.of(
        Arguments.of(
            EmployeeVO.builder()
                .nif("45134320V")
                .name("Walter")
                .birthYear(1998)
                .gender(Gender.MALE)
                .personalPhone("+34722748406")
                .email("wmlopes0@gmail.com")
                .build(),
            new EmployeeCreateCmd()
                .setNif("45134320V")
                .setName("Walter")
                .setBirthYear(1998)
                .setGender("male")
                .setPersonalPhone("+34722748406")
                .setEmail("wmlopes0@gmail.com")
        )
    );
  }

  @ParameterizedTest
  @MethodSource("updateCmdToVOParameters")
  @DisplayName("Mapping EmployeeUpdateCmd to EmployeeVO correctly")
  void mapUpdateCmdToEmployeeVOTest(EmployeeVO expected, EmployeeUpdateCmd employeeUpdateCmd) {
    EmployeeVO result = mapper.mapToEmployeeVO(employeeUpdateCmd);
    Assertions.assertEquals(expected, result);
  }

  private static Stream<Arguments> updateCmdToVOParameters() {
    return Stream.of(
        Arguments.of(
            EmployeeVO.builder()
                .nif("45134320V")
                .name("Walter")
                .birthYear(1998)
                .gender(Gender.MALE)
                .personalPhone("+34722748406")
                .email("wmlopes0@gmail.com")
                .build(),
            new EmployeeUpdateCmd()
                .setNif("45134320V")
                .setName("Walter")
                .setBirthYear(1998)
                .setGender("male")
                .setPersonalPhone("+34722748406")
                .setEmail("wmlopes0@gmail.com")
        )
    );
  }

  @ParameterizedTest
  @MethodSource("deleteCmdToNifVOParameters")
  @DisplayName("Mapping EmployeeDeleteCmd to EmployeeNifVO correctly")
  void mapDeleteCmdToEmployeeNifVOTest(EmployeeNifVO expected, EmployeeDeleteCmd employeeDeleteCmd) {
    EmployeeNifVO result = mapper.mapToEmployeeNifVO(employeeDeleteCmd);
    Assertions.assertEquals(expected, result);
  }

  private static Stream<Arguments> deleteCmdToNifVOParameters() {
    return Stream.of(
        Arguments.of(
            EmployeeNifVO.builder()
                .nif("45134320V")
                .build(),
            new EmployeeDeleteCmd()
                .setNif("45134320V")
        )
    );
  }

  @ParameterizedTest
  @MethodSource("byIdQueryToNifVOParameters")
  @DisplayName("Mapping EmployeeByIdQuery to EmployeeNifVO correctly")
  void mapByIdQueryToEmployeeNifVOTest(EmployeeNifVO expected, EmployeeByIdQuery employeeByIdQuery) {
    EmployeeNifVO result = mapper.mapToEmployeeNifVO(employeeByIdQuery);
    Assertions.assertEquals(expected, result);
  }

  private static Stream<Arguments> byIdQueryToNifVOParameters() {
    return Stream.of(
        Arguments.of(
            EmployeeNifVO.builder()
                .nif("45134320V")
                .build(),
            new EmployeeByIdQuery()
                .setNif("45134320V")
        )
    );
  }

  @ParameterizedTest
  @MethodSource("byNameQueryToVOParameters")
  @DisplayName("Mapping EmployeeByNameQuery to EmployeeNameVO correctly")
  void mapByNameQueryToEmployeeNameVOTest(EmployeeNameVO expected, EmployeeByNameQuery employeeByNameQuery) {
    EmployeeNameVO result = mapper.mapToEmployeeNameVO(employeeByNameQuery);
    Assertions.assertEquals(expected, result);
  }

  private static Stream<Arguments> byNameQueryToVOParameters() {
    return Stream.of(
        Arguments.of(
            EmployeeNameVO.builder().name("Walter").build(),
            new EmployeeByNameQuery("Walter")
        )
    );
  }

}