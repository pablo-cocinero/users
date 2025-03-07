package com.company.users.service;

import com.company.users.dto.CreateUserRequestDto;
import com.company.users.dto.CreateUserResponseDto;
import com.company.users.mapper.UserMapper;
import com.company.users.model.User;
import com.company.users.repository.UserRepository;
import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private UserMapper mapper;

  public CreateUserResponseDto signUp(CreateUserRequestDto userRequestDto) {
    final User newUser = mapper.toEntity(userRequestDto);
    //Fill other attributes
    FillEntityAttributes(newUser);
    final User savedUser = userRepository.save(newUser);
    return mapper.toResponseDto(savedUser);
  }

  private void FillEntityAttributes(User newUser) {
    newUser.setUuid(UUID.randomUUID());
    newUser.setCreated(LocalDateTime.now());
    newUser.setLastLogin(newUser.getCreated());
    newUser.setIsActive(true);
    //encryptar pass
  }
}
