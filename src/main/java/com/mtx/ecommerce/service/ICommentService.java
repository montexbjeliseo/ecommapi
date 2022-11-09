package com.mtx.ecommerce.service;

import com.mtx.ecommerce.dto.request.RegisterCommentDto;
import com.mtx.ecommerce.dto.response.RegisteredCommentDto;

public interface ICommentService {

    RegisteredCommentDto save(Long product_id, RegisterCommentDto dto);
}
