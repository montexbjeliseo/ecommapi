package com.mtx.ecommerce.security.service;

import com.mtx.ecommerce.security.dto.request.LoginUserDto;
import com.mtx.ecommerce.security.dto.request.RegisterUserDto;
import com.mtx.ecommerce.security.dto.response.RegisteredUserDto;
import com.mtx.ecommerce.security.dto.response.TokenInfo;
import com.mtx.ecommerce.security.dto.response.UserInfoDto;
import java.io.IOException;

public interface IAuthService {

    RegisteredUserDto register(RegisterUserDto dto) throws IOException ;

    TokenInfo login(LoginUserDto dto);

    UserInfoDto userInfo();
}
