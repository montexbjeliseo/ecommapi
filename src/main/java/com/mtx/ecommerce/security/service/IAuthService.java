package com.mtx.ecommerce.security.service;

import com.mtx.ecommerce.security.dto.request.UserRegisterDto;
import com.mtx.ecommerce.security.dto.response.RegisteredUserDto;

public interface IAuthService {
    RegisteredUserDto register(UserRegisterDto dto);
}
