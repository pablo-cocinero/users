package com.company.users.dto;

import com.company.users.constraint.EmailConstraint;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(SnakeCaseStrategy.class)
public class BaseUserDto {

  private String name;

  @NotBlank
  @EmailConstraint
  private String email;

  private PhoneDto[] phones;
}
