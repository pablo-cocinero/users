package com.company.users.dto;

import lombok.Data;

@Data
public class ErrorDto {
  private String timeStamp;
  private Integer code;
  private String detail;
}
