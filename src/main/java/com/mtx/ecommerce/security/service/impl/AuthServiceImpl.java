package com.mtx.ecommerce.security.service.impl;

import com.mtx.ecommerce.exception.auth.AlreadyExistsEmailException;
import com.mtx.ecommerce.security.dto.request.UserLoginDto;
import com.mtx.ecommerce.security.dto.request.UserRegisterDto;
import com.mtx.ecommerce.security.dto.response.RegisteredUserDto;
import com.mtx.ecommerce.security.dto.response.TokenInfo;
import com.mtx.ecommerce.security.mapper.UserMapper;
import com.mtx.ecommerce.security.model.Role;
import com.mtx.ecommerce.security.model.User;
import com.mtx.ecommerce.security.repository.RoleRepository;
import com.mtx.ecommerce.security.repository.UserRepository;
import com.mtx.ecommerce.security.service.IAuthService;
import com.mtx.ecommerce.security.service.IJwtService;
import com.mtx.ecommerce.util.Constants.Messages.AuthMessages;
import com.mtx.ecommerce.util.Constants.Roles;
import java.util.HashSet;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IJwtService jwtService;

    @Autowired
    private BCryptPasswordEncoder bcrypt;

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Override
    public RegisteredUserDto register(UserRegisterDto dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new AlreadyExistsEmailException(AuthMessages.ALREADY_EXISTS_EMAIL);
        }
        User user = userMapper.toUser(dto);
        user.setPassword(bcrypt.encode(user.getPassword()));
        user.setRoles(getDefaultRoles());
        User saved = userRepository.save(user);
        RegisteredUserDto response = userMapper.toRegisteredDto(saved);
        response.setJwtToken(jwtService.generateToken(saved));
        return response;

    }

    @Override
    public TokenInfo login(UserLoginDto dto) {
        if (!userRepository.existsByEmail(dto.getUsername())) {
            throw new UsernameNotFoundException(AuthMessages.USERNAME_NOT_FOUND);
        }
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword())
            );
            return new TokenInfo(jwtService.generateToken((UserDetails) auth.getPrincipal()));
        } catch (BadCredentialsException ex) {
            throw ex;
        }
    }

    private Set<Role> getDefaultRoles() {
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName(Roles.ADMIN).get());
        return roles;
    }
}
