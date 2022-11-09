package com.mtx.ecommerce.controller;

import com.mtx.ecommerce.dto.request.RegisterCommentDto;
import com.mtx.ecommerce.service.ICommentService;
import com.mtx.ecommerce.util.Constants.Endpoints;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Endpoints.COMMENT)
public class CommentController {

    @Autowired
    private ICommentService commentService;

    @PostMapping
    public ResponseEntity<?> save(@PathVariable Long product_id, @Valid @RequestBody RegisterCommentDto dto) {
        return new ResponseEntity<>(commentService.save(product_id, dto), HttpStatus.OK);
    }

}
