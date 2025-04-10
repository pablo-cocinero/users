package com.company.users.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.company.users.dto.BaseUserDto;
import com.company.users.dto.UserResponseDto;
import com.company.users.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Users", description = "API for signing-in and logging-in")
public class UsersController
{
  @Autowired
  private UserService userService;

  /**
   * SignUp endpoint, meant to create a new User based on the information provided in the http request body.
   * Email and password are mandatory, name and Phones are optional
   * @param userRequestDto
   * @return The User created with an access token for logging in
   */
  @PostMapping(value = "/sign-up", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<UserResponseDto> signUp(@RequestBody @Validated BaseUserDto userRequestDto) {
    return new ResponseEntity<>(userService.signUp(userRequestDto), HttpStatus.CREATED);
  }

  /**
   * logIn endpoint, meant to authenticate an existing User.
   * It requires the User uuid as path param, and a valid JWT token as authorization header
   * @param uuid
   * @return The User information
   */
  @GetMapping(value = "/logIn/{userId}", produces = APPLICATION_JSON_VALUE)
  @SecurityRequirement(name = "api")
  public ResponseEntity<UserResponseDto> logIn(@PathVariable("userId") String uuid) {
      return new ResponseEntity<>(userService.logIn(uuid), HttpStatus.OK);
  }
}
