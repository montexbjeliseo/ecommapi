package com.mtx.ecommerce.controller;

import com.mtx.ecommerce.dto.request.CategoryRegisterDto;
import com.mtx.ecommerce.service.ICategoryService;
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
@RequestMapping(Endpoints.CATEGORY)
public class CategoryController {
    
    @Autowired
    private ICategoryService categoryService;
    
    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody CategoryRegisterDto dto){
        return new ResponseEntity<>(categoryService.save(dto), HttpStatus.OK);
    }
}
