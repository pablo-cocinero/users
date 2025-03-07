package com.company.users.mapper;

import com.company.users.dto.CreateUserRequestDto;
import com.company.users.dto.CreateUserResponseDto;
import com.company.users.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {

  @Mapping(source = "name", target = "name")
  @Mapping(source = "email", target = "email")
  @Mapping(source = "phones", target = "phones")
  @Mapping(source = "password", target = "password")
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "uuid", ignore = true)
  @Mapping(target = "created", ignore = true)
  @Mapping(target = "lastLogin", ignore = true)
  @Mapping(target = "isActive", ignore = true)
  User toEntity(CreateUserRequestDto userRequestDto);

  @Mapping(source = "uuid", target = "id")
  @Mapping(source = "created", target = "createdDate")
  @Mapping(source = "lastLogin", target = "lastLogin")
  @Mapping(source = "isActive", target = "isActive")
  @Mapping(source = "name", target = "name")
  @Mapping(source = "email", target = "email")
  @Mapping(source = "phones", target = "phones")
  @Mapping(target = "token", ignore = true)
  CreateUserResponseDto toResponseDto(User user);
}
