package com.company.users.controller;

import com.company.users.dto.CreateUserRequestDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController
{
  @PostMapping("/sign-up")
  public void signUp(@RequestBody @Validated CreateUserRequestDto userRequestDto) {

  }

  public void logIn() {

  }
}
