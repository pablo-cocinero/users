package com.company.users.dto;

import com.company.users.constraint.PasswordConstraint;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequestDto extends BaseUserDto {
  
  @NotBlank
  @PasswordConstraint
  private String password;
}
