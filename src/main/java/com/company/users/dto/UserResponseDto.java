package com.company.users.dto;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto extends BaseUserDto {
  
  private UUID id;
  private LocalDateTime createdDate;
  private LocalDateTime lastLogin;
  private Jwt accessToken;
  private Boolean isActive;
}
