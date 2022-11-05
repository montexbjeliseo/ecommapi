package com.mtx.ecommerce.security.controller;

import com.mtx.ecommerce.security.dto.request.LoginUserDto;
import com.mtx.ecommerce.security.dto.request.RegisterUserDto;
import com.mtx.ecommerce.security.service.IAuthService;
import com.mtx.ecommerce.util.Constants.Endpoints;
import java.io.IOException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Endpoints.AUTH)
public class AuthController {

    @Autowired
    private IAuthService authService;

    @PostMapping(Endpoints.REGISTER)
    public ResponseEntity<?> register(@Valid @RequestBody RegisterUserDto dto) throws IOException {
        return new ResponseEntity<>(authService.register(dto), HttpStatus.OK);
    }

    @PostMapping(Endpoints.LOGIN)
    public ResponseEntity<?> login(@Valid @RequestBody LoginUserDto dto) throws IOException {
        return new ResponseEntity<>(authService.login(dto), HttpStatus.OK);
    }

    @GetMapping(Endpoints.ME)
    public ResponseEntity<?> userInfo() throws IOException {
        return new ResponseEntity<>(authService.userInfo(), HttpStatus.OK);
    }
}
