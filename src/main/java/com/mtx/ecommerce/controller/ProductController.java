package com.mtx.ecommerce.controller;

import com.mtx.ecommerce.dto.request.RegisterProductDto;
import com.mtx.ecommerce.dto.request.UpdateProductDto;
import com.mtx.ecommerce.service.IProductService;
import com.mtx.ecommerce.util.Constants.Endpoints;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<?> save(@Valid @RequestBody RegisterProductDto dto) {
        return new ResponseEntity<>(productService.save(dto), HttpStatus.OK);
    }
    
    @PatchMapping(Endpoints.ID)
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody UpdateProductDto dto) {
        return new ResponseEntity<>(productService.update(id, dto), HttpStatus.OK);
    }
}
