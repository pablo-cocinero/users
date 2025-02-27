package com.company.users.dto;

import com.company.users.constraint.EmailConstraint;
import com.company.users.constraint.PasswordConstraint;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateUserRequestDto {

  private String name;

  @NotBlank
  @EmailConstraint
  private String email;

  @NotBlank
  @PasswordConstraint
  private String password;

  private PhoneDto[] phones;
}
