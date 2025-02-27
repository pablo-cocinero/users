package com.company.users.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Entity;

@Entity(name = "users")
public class User implements Serializable {
  //TODO add persistence tags
  private UUID id;
  private LocalDateTime created;
  private LocalDateTime lastLogin;
  private Boolean active;
  private String name;
  private String email;
  private String password;
  private Phone[] phones;
}
