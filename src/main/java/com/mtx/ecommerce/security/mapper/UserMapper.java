package com.mtx.ecommerce.security.mapper;

import com.mtx.ecommerce.security.dto.request.RegisterUserDto;
import com.mtx.ecommerce.security.dto.request.UpdateUserDto;
import com.mtx.ecommerce.security.dto.response.RegisteredUserDto;
import com.mtx.ecommerce.security.dto.response.UserInfoDto;
import com.mtx.ecommerce.security.model.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(RegisterUserDto dto);

    RegisteredUserDto toRegisteredDto(User user);

    UserInfoDto toInfoDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User update(UpdateUserDto dto, @MappingTarget User user);

}
