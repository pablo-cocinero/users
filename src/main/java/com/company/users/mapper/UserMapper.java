package com.company.users.mapper;

import com.company.users.dto.CreateUserRequestDto;
import com.company.users.dto.UserResponseDto;
import com.company.users.model.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
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
  @Mapping(target = "accessToken", ignore = true)
  UserResponseDto toResponseDto(User user);
}
