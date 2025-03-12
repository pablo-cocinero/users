package com.company.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "phones")
@Getter
@Setter
public class Phone {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;
  @Column(name = "number")
  private Long number;
  @Column(name = "city_code")
  private Integer cityCode;
  @Column(name = "country_code")
  private String countryCode;
}
