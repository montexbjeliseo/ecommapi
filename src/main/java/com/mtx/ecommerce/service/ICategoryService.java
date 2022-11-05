package com.mtx.ecommerce.service;

import com.mtx.ecommerce.dto.request.RegisterCategoryDto;
import com.mtx.ecommerce.dto.request.UpdateCategoryDto;
import com.mtx.ecommerce.dto.response.RegisteredCategoryDto;
import java.util.List;

public interface ICategoryService {

    RegisteredCategoryDto save(RegisterCategoryDto dto);

    RegisteredCategoryDto update(Long id, UpdateCategoryDto dto);
    
    List<RegisteredCategoryDto> getAll();
}
