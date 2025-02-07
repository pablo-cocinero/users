package com.company.users.dto;

import lombok.Data;

@Data
public class PhoneDto {
  private long number;
  private int cityCode;
  private String countryCode;
}
