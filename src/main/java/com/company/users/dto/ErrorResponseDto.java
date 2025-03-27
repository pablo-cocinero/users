package com.company.users.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class ErrorResponseDto {
  private List<ErrorDto> error = new ArrayList<>();
}
