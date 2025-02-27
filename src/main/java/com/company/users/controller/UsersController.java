package com.company.users.controller;

import com.company.users.dto.CreateUserRequestDto;
import com.company.users.dto.CreateUserResponseDto;
import com.company.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController
{
  @Autowired
  private UserService userService;

  @PostMapping("/sign-up")
  public ResponseEntity<CreateUserResponseDto> signUp(@RequestBody @Validated CreateUserRequestDto userRequestDto) {
    return new ResponseEntity<>(userService.signUp(userRequestDto), HttpStatus.CREATED);
  }

  public void logIn() {

  }
}
