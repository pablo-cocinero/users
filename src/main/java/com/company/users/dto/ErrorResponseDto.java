package com.company.users.dto;

import java.util.List;
import lombok.Data;

@Data
public class ErrorResponseDto {
  private List<ErrorDto> error;
}
