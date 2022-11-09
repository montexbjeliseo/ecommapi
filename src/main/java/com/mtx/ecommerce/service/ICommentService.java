package com.mtx.ecommerce.service;

import com.mtx.ecommerce.dto.request.RegisterCommentDto;
import com.mtx.ecommerce.dto.response.RegisteredCommentDto;
import java.util.List;

public interface ICommentService {

    RegisteredCommentDto save(Long product_id, RegisterCommentDto dto);

    List<RegisteredCommentDto> getAll(Long product_id);
}
