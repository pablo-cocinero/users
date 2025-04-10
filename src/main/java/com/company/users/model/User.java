package com.company.users.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "users")
@Getter
@Setter
public class User implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;
  @Column(name = "uuid", nullable = false, unique = true, length = 64)
  private String uuid;
  @Column(name = "created_time", nullable = false, updatable = false)
  private LocalDateTime created;
  @Column(name = "last_login", nullable = false)
  private LocalDateTime lastLogin;
  @Column(name = "is_active", nullable = false)
  private Boolean isActive;
  @Column(name = "name")
  private String name;
  @Column(name = "email", nullable = false)
  private String email;
  @Column(name = "password", nullable = false)
  private String password;
  @OneToMany(mappedBy="user", orphanRemoval = true, cascade = CascadeType.ALL)
  private Set<Phone> phones = new HashSet<>();
}
