package com.mtx.ecommerce.controller;

import com.mtx.ecommerce.dto.request.ProductRegisterDto;
import com.mtx.ecommerce.service.IProductService;
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
@RequestMapping(Endpoints.PRODUCT)
public class ProductController {

    @Autowired
    private IProductService productService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody ProductRegisterDto dto) {
        return new ResponseEntity<>(productService.save(dto), HttpStatus.OK);
    }
}
