package com.company.users.service;

import com.company.users.dto.CreateUserRequestDto;
import com.company.users.dto.UserResponseDto;
import com.company.users.mapper.UserMapper;
import com.company.users.model.User;
import com.company.users.repository.UserRepository;
import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  @Autowired
  public UserService(final UserRepository userRepository, final UserMapper userMapper) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
  }

  public UserResponseDto signUp(CreateUserRequestDto userRequestDto) {
    final User newUser = userMapper.toEntity(userRequestDto);
    FillEntityAttributes(newUser);
    final User savedUser = userRepository.save(newUser);
    return userMapper.toResponseDto(savedUser);
  }

  private void FillEntityAttributes(User newUser) {
    newUser.setUuid(UUID.randomUUID());
    newUser.setCreated(LocalDateTime.now());
    newUser.setLastLogin(newUser.getCreated());
    newUser.setIsActive(true);
    //encryptar pass
  }

  public UserResponseDto logIn(UUID uuid) {
      //TODO implement
      return new UserResponseDto();
  }
}
