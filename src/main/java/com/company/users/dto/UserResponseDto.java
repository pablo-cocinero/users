package com.company.users.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto extends BaseUserDto {
  
  private String uuid;
  private LocalDateTime createdDate;
  private LocalDateTime lastLogin;
  private String accessToken;
  private Boolean isActive;
}
