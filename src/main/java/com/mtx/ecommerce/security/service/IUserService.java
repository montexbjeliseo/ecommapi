package com.mtx.ecommerce.security.service;

import com.mtx.ecommerce.security.dto.request.UpdateUserDto;
import com.mtx.ecommerce.security.dto.response.UserInfoDto;

public interface IUserService {

    UserInfoDto update(UpdateUserDto dto);
}
