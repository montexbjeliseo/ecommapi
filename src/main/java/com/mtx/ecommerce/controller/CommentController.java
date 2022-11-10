package com.mtx.ecommerce.controller;

import com.mtx.ecommerce.dto.request.RegisterCommentDto;
import com.mtx.ecommerce.service.ICommentService;
import com.mtx.ecommerce.util.Constants.Endpoints;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping
    public ResponseEntity<?> getAll(@PathVariable Long product_id) {
        return new ResponseEntity<>(commentService.getAll(product_id), HttpStatus.OK);
    }

    @DeleteMapping(Endpoints.ID)
    public ResponseEntity<?> delete(@PathVariable Long product_id, @PathVariable Long id) {
        return new ResponseEntity<>(commentService.delete(product_id, id), HttpStatus.OK);
    }

}
