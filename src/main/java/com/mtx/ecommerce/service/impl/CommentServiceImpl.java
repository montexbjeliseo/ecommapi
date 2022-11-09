package com.mtx.ecommerce.service.impl;

import com.mtx.ecommerce.dto.request.RegisterCommentDto;
import com.mtx.ecommerce.dto.response.RegisteredCommentDto;
import com.mtx.ecommerce.exception.ResourceNotFoundException;
import com.mtx.ecommerce.mapper.CommentMapper;
import com.mtx.ecommerce.model.Comment;
import com.mtx.ecommerce.model.Product;
import com.mtx.ecommerce.repository.CommentRepository;
import com.mtx.ecommerce.repository.ProductRepository;
import com.mtx.ecommerce.security.model.User;
import com.mtx.ecommerce.security.repository.UserRepository;
import com.mtx.ecommerce.service.ICommentService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private UserRepository userRepository;

    @Override
    public RegisteredCommentDto save(Long id, RegisterCommentDto dto) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product not found");
        }
        Product product = productRepository.findById(id).get();
        Comment comment = commentMapper.toComment(dto);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByEmail(auth.getName()).get();
        comment.setUser(user);
        comment.setProduct(product);
        Comment saved = commentRepository.save(comment);
        return commentMapper.toDto(saved);
    }
}
