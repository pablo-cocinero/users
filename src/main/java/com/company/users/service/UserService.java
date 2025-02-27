package com.company.users.service;

import com.company.users.dto.CreateUserRequestDto;
import com.company.users.dto.CreateUserResponseDto;
import com.company.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public CreateUserResponseDto signUp(CreateUserRequestDto userRequestDto) {
    /*
    TODO
    * Transform request into entity
    * save entity
    * generate response
    * */


    CreateUserResponseDto responseDto = new CreateUserResponseDto();
    return responseDto;
  }
}
