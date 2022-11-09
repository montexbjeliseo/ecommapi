package com.mtx.ecommerce.controller;

import com.mtx.ecommerce.dto.request.RegisterCategoryDto;
import com.mtx.ecommerce.dto.request.UpdateCategoryDto;
import com.mtx.ecommerce.service.ICategoryService;
import com.mtx.ecommerce.util.Constants.Endpoints;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<?> save(@Valid @RequestBody RegisterCategoryDto dto) {
        return new ResponseEntity<>(categoryService.save(dto), HttpStatus.OK);
    }

    @PatchMapping(Endpoints.ID)
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody UpdateCategoryDto dto) {
        return new ResponseEntity<>(categoryService.update(id, dto), HttpStatus.OK);
    }
    
    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
    }
    
    @DeleteMapping(Endpoints.ID)
    public ResponseEntity<?> delete(@PathVariable Long id){
        return new ResponseEntity<>(categoryService.delete(id), HttpStatus.OK);
    }
}
