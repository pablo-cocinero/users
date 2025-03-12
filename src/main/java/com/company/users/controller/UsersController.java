package com.company.users.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.company.users.dto.CreateUserRequestDto;
import com.company.users.dto.UserResponseDto;
import com.company.users.service.UserService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController
{
  @Autowired
  private UserService userService;

  @PostMapping(value = "/sign-up", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<UserResponseDto> signUp(@RequestBody @Validated CreateUserRequestDto userRequestDto) {
    return new ResponseEntity<>(userService.signUp(userRequestDto), HttpStatus.CREATED);
  }

  @GetMapping(value = "logIn/{userId}", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<UserResponseDto> logIn(@PathVariable("userId") UUID uuid) {
      return new ResponseEntity<>(userService.logIn(uuid), HttpStatus.ACCEPTED);
  }
}
