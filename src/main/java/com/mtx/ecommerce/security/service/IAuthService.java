package com.mtx.ecommerce.security.service;

import com.mtx.ecommerce.security.dto.request.UserLoginDto;
import com.mtx.ecommerce.security.dto.request.UserRegisterDto;
import com.mtx.ecommerce.security.dto.response.RegisteredUserDto;
import com.mtx.ecommerce.security.dto.response.TokenInfo;
import com.mtx.ecommerce.security.dto.response.UserInfoDto;
import java.io.IOException;

public interface IAuthService {

    RegisteredUserDto register(UserRegisterDto dto) throws IOException ;

    TokenInfo login(UserLoginDto dto);

    UserInfoDto userInfo();
}
