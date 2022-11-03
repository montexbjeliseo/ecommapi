package com.mtx.ecommerce.security.controller;

import com.mtx.ecommerce.security.dto.request.UserRegisterDto;
import com.mtx.ecommerce.security.service.IAuthService;
import com.mtx.ecommerce.util.Constants.Endpoints;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> register(@Valid @RequestBody UserRegisterDto dto){
        return new ResponseEntity<>(authService.register(dto), HttpStatus.OK);
    }
}
