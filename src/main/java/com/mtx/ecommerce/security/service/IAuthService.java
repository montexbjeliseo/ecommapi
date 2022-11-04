package com.mtx.ecommerce.security.service;

import com.mtx.ecommerce.security.dto.request.UserLoginDto;
import com.mtx.ecommerce.security.dto.request.UserRegisterDto;
import com.mtx.ecommerce.security.dto.response.RegisteredUserDto;
import com.mtx.ecommerce.security.dto.response.TokenInfo;

public interface IAuthService {
    RegisteredUserDto register(UserRegisterDto dto);
    TokenInfo login(UserLoginDto dto);
}
