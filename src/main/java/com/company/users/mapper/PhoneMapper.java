package com.company.users.mapper;

import com.company.users.dto.PhoneDto;
import com.company.users.model.Phone;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PhoneMapper {

  @Mapping(target = "number", source = "number")
  @Mapping(target = "cityCode", source = "cityCode")
  @Mapping(target = "countryCode", source = "countryCode")
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "user", ignore = true)
  Phone toEntity(PhoneDto phoneDto);

  @Mapping(target = "number", source = "number")
  @Mapping(target = "cityCode", source = "cityCode")
  @Mapping(target = "countryCode", source = "countryCode")
  PhoneDto toDto(Phone phone);
}
