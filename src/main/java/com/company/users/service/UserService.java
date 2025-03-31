package com.company.users.service;

import com.company.users.dto.BaseUserDto;
import com.company.users.dto.UserResponseDto;
import com.company.users.exception.UserNotFoundException;
import com.company.users.mapper.UserMapper;
import com.company.users.model.User;
import com.company.users.repository.UserRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;

  @Autowired
  public UserService(final UserRepository userRepository, final UserMapper userMapper, final PasswordEncoder passwordEncoder, JwtService jwtService) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
    this.passwordEncoder = passwordEncoder;
    this.jwtService = jwtService;
  }

  public UserResponseDto signUp(BaseUserDto userRequestDto) {
    final User newUser = userMapper.toEntity(userRequestDto);
    FillEntityAttributes(newUser, userRequestDto);
    final User savedUser = userRepository.save(newUser);
    UserResponseDto responseDto = userMapper.toResponseDto(savedUser);
    responseDto.setAccessToken(jwtService.generateToken(savedUser.getEmail()));
    return responseDto;
  }

  private void FillEntityAttributes(User newUser, BaseUserDto userRequestDto) {
    newUser.setUuid(UUID.randomUUID().toString());
    newUser.setCreated(LocalDateTime.now());
    newUser.setLastLogin(newUser.getCreated());
    newUser.setIsActive(true);
    newUser.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
  }

  public UserResponseDto logIn(String uuid) {
      Optional<User> user = userRepository.findByUuid(uuid);
      if(user.isPresent()) {
        UserResponseDto responseDto = userMapper.toResponseDto(user.get());
        responseDto.setAccessToken(jwtService.generateToken(user.get().getEmail()));
        return responseDto;
      }else {
      throw new UserNotFoundException();
      }
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    User user = userRepository.findByEmail(email)
        .orElseThrow(UserNotFoundException::new);
    return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
  }
}
