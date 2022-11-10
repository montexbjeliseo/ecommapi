package com.mtx.ecommerce.security.service;

import com.mtx.ecommerce.security.dto.response.UserInfoDto;
import com.mtx.ecommerce.security.model.Role;
import com.mtx.ecommerce.security.model.User;
import java.util.Set;

public interface IAuthUtilsService {

    UserInfoDto userInfo();

    Set<Role> getDefaultRoles();

    User getCurrentUser();
}
