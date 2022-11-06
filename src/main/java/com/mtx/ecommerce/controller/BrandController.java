package com.mtx.ecommerce.controller;

import com.mtx.ecommerce.dto.request.RegisterBrandDto;
import com.mtx.ecommerce.dto.request.UpdateBrandDto;
import com.mtx.ecommerce.service.IBrandService;
import com.mtx.ecommerce.util.Constants.Endpoints;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<?> save(@Valid @RequestBody RegisterBrandDto dto) {
        return new ResponseEntity<>(brandService.save(dto), HttpStatus.OK);
    }

    @PatchMapping(Endpoints.ID)
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody UpdateBrandDto dto) {
        return new ResponseEntity<>(brandService.update(id, dto), HttpStatus.OK);
    }
    
    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(brandService.getAll(), HttpStatus.OK);
    }
}
