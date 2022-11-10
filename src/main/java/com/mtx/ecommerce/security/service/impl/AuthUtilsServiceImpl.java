package com.mtx.ecommerce.security.service.impl;

import com.mtx.ecommerce.security.dto.response.UserInfoDto;
import com.mtx.ecommerce.security.mapper.UserMapper;
import com.mtx.ecommerce.security.model.Role;
import com.mtx.ecommerce.security.model.User;
import com.mtx.ecommerce.security.repository.RoleRepository;
import com.mtx.ecommerce.security.repository.UserRepository;
import com.mtx.ecommerce.security.service.IAuthUtilsService;
import com.mtx.ecommerce.util.Constants.Roles;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthUtilsServiceImpl implements IAuthUtilsService {
    
    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Override
    public UserInfoDto userInfo() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByEmail(auth.getName()).get();
        return userMapper.toInfoDto(user);
    }
    
    @Override
    public Set<Role> getDefaultRoles() {
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName(Roles.USER).get());
        return roles;
    }
    
    @Override
    public User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.findByEmail(auth.getName()).get();
    }
}
