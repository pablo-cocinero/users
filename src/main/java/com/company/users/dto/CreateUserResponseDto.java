package com.company.users.dto;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;

@Getter
@Setter
@AllArgsConstructor
public class CreateUserResponseDto extends CreateUserRequestDto {
  
  private UUID id;
  private LocalDateTime dateTime;
  private LocalDateTime lastLogin;
  private Jwt accessToken;
  private boolean isActive;
}
