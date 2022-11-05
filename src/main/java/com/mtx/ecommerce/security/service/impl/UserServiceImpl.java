package com.mtx.ecommerce.security.service.impl;

import com.mtx.ecommerce.exception.ParameterNotFoundException;
import com.mtx.ecommerce.security.dto.request.UpdateUserDto;
import com.mtx.ecommerce.security.dto.response.UserInfoDto;
import com.mtx.ecommerce.security.mapper.UserMapper;
import com.mtx.ecommerce.security.model.User;
import com.mtx.ecommerce.security.repository.UserRepository;
import com.mtx.ecommerce.security.service.IUserService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder bcrypt;

    @Override
    public UserInfoDto update(UpdateUserDto dto) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        User user = userRepository.findByEmail(auth.getName()).get();

        if (dto.getFirstName() == null && dto.getLastName() == null && dto.getPassword() == null && dto.getPhoto() == null) {
            throw new ParameterNotFoundException("No parameters were received!");
        }

        user = userMapper.update(dto, user);

        if (dto.getPassword() != null) {
            user.setPassword(bcrypt.encode(dto.getPassword()));
        }

        User saved = userRepository.save(user);

        return userMapper.toInfoDto(saved);

    }
}
