package com.mtx.ecommerce.controller;

import com.mtx.ecommerce.dto.request.RegisterSlideDto;
import com.mtx.ecommerce.service.ISlideService;
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
@RequestMapping(Endpoints.SLIDE)
public class SlidesController {

    @Autowired
    private ISlideService slideService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody RegisterSlideDto dto) {
        return new ResponseEntity<>(slideService.save(dto), HttpStatus.OK);
    }
}
