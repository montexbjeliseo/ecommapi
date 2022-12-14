package com.mtx.ecommerce.service.impl;

import com.mtx.ecommerce.dto.request.RegisterCommentDto;
import com.mtx.ecommerce.dto.request.UpdateCommentDto;
import com.mtx.ecommerce.dto.response.RegisteredCommentDto;
import com.mtx.ecommerce.exception.NotOwnResourceException;
import com.mtx.ecommerce.exception.ResourceNotFoundException;
import com.mtx.ecommerce.mapper.CommentMapper;
import com.mtx.ecommerce.model.Comment;
import com.mtx.ecommerce.model.Product;
import com.mtx.ecommerce.repository.CommentRepository;
import com.mtx.ecommerce.repository.ProductRepository;
import com.mtx.ecommerce.security.model.User;
import com.mtx.ecommerce.security.service.IAuthUtilsService;
import com.mtx.ecommerce.service.ICommentService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private IAuthUtilsService authUtilsService;

    @Override
    public RegisteredCommentDto save(Long product_id, RegisterCommentDto dto) {
        if (!productRepository.existsById(product_id)) {
            throw new ResourceNotFoundException("Product not found");
        }
        Product product = productRepository.findById(product_id).get();
        Comment comment = commentMapper.toComment(dto);
        User user = authUtilsService.getCurrentUser();
        comment.setUser(user);
        comment.setProduct(product);
        Comment saved = commentRepository.save(comment);
        if (product.getComments() == null) {
            product.setComments(new HashSet<>());
        }
        product.getComments().add(comment);
        productRepository.save(product);
        return commentMapper.toDto(saved);
    }

    @Override
    public List<RegisteredCommentDto> getAll(Long product_id) {
        if (!productRepository.existsById(product_id)) {
            throw new ResourceNotFoundException("Product not found");
        }
        Product product = productRepository.findById(product_id).get();
        Set<Comment> comments = product.getComments();
        if (comments.size() < 1) {
            throw new ResourceNotFoundException("No comments were found");
        }
        return commentMapper.toDtoList(comments);
    }

    @Override
    public RegisteredCommentDto delete(Long product_id, Long id) {
        if (!productRepository.existsById(product_id)) {
            throw new ResourceNotFoundException("Product not found");
        }
        if (!commentRepository.existsById(id)) {
            throw new ResourceNotFoundException("No comments were found");
        }
        Comment comment = commentRepository.findById(id).get();
        if (comment.getProduct().getId() != product_id) {
            throw new ResourceNotFoundException("Comment with " + id + " does not belong to product with " + product_id);
        }

        User user = authUtilsService.getCurrentUser();

        if (comment.getUser().getId() != user.getId() && !user.isAdmin()) {
            throw new NotOwnResourceException("Not own comment");
        }
        commentRepository.deleteById(id);
        return commentMapper.toDto(comment);
    }

    @Override
    public RegisteredCommentDto update(Long product_id, Long id, UpdateCommentDto dto) {
        if (!productRepository.existsById(product_id)) {
            throw new ResourceNotFoundException("Product not found");
        }
        if (!commentRepository.existsById(id)) {
            throw new ResourceNotFoundException("No comments were found");
        }
        Comment comment = commentRepository.findById(id).get();
        if (comment.getProduct().getId() != product_id) {
            throw new ResourceNotFoundException("Comment with " + id + " does not belong to product with " + product_id);
        }
        User user = authUtilsService.getCurrentUser();
        if (comment.getUser().getId() != user.getId()) {
            throw new NotOwnResourceException("Not own comment");
        }
        comment.setBody(dto.getBody());
        return commentMapper.toDto(comment);
    }

}
