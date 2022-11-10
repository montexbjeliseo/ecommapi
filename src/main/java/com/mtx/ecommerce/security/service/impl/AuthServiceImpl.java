package com.mtx.ecommerce.security.service.impl;

import com.mtx.ecommerce.exception.auth.AlreadyExistsEmailException;
import com.mtx.ecommerce.security.dto.request.LoginUserDto;
import com.mtx.ecommerce.security.dto.request.RegisterUserDto;
import com.mtx.ecommerce.security.dto.response.RegisteredUserDto;
import com.mtx.ecommerce.security.dto.response.TokenInfo;
import com.mtx.ecommerce.security.mapper.UserMapper;
import com.mtx.ecommerce.security.model.User;
import com.mtx.ecommerce.security.repository.UserRepository;
import com.mtx.ecommerce.security.service.IAuthService;
import com.mtx.ecommerce.security.service.IAuthUtilsService;
import com.mtx.ecommerce.security.service.IJwtService;
import com.mtx.ecommerce.service.IEmailService;
import com.mtx.ecommerce.util.Constants.Messages.AuthMessages;
import com.sendgrid.Response;
import java.io.IOException;
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
    private UserMapper userMapper;

    @Autowired
    private IJwtService jwtService;

    @Autowired
    private BCryptPasswordEncoder bcrypt;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IEmailService emailService;

    @Autowired
    private IAuthUtilsService authUtilsService;

    @Override
    public RegisteredUserDto register(RegisterUserDto dto) throws IOException {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new AlreadyExistsEmailException(AuthMessages.ALREADY_EXISTS_EMAIL);
        }
        User user = userMapper.toUser(dto);
        user.setPassword(bcrypt.encode(user.getPassword()));
        user.setRoles(authUtilsService.getDefaultRoles());
        User saved = userRepository.save(user);
        RegisteredUserDto response = userMapper.toRegisteredDto(saved);
        response.setJwtToken(jwtService.generateToken(saved));
        Response mailResponse = emailService.sendWelcome(saved.getEmail());
        return response;

    }

    @Override
    public TokenInfo login(LoginUserDto dto) {
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
}
