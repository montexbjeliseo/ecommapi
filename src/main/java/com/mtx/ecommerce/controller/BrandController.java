package com.mtx.ecommerce.controller;

import com.mtx.ecommerce.dto.request.BrandRegisterDto;
import com.mtx.ecommerce.service.IBrandService;
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
@RequestMapping(Endpoints.BRAND)
public class BrandController {

    @Autowired
    private IBrandService brandService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody BrandRegisterDto dto) {
        return new ResponseEntity<>(brandService.save(dto), HttpStatus.OK);
    }
}
