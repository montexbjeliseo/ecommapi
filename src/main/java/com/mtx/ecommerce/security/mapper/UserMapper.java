package com.mtx.ecommerce.security.mapper;

import com.mtx.ecommerce.security.dto.request.UserRegisterDto;
import com.mtx.ecommerce.security.dto.response.RegisteredUserDto;
import com.mtx.ecommerce.security.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface UserMapper {
    
    User toUser(UserRegisterDto dto);
    
    RegisteredUserDto toRegisteredDto(User user);
}
