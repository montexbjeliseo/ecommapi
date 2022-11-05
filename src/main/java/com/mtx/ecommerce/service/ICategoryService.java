package com.mtx.ecommerce.service;

import com.mtx.ecommerce.dto.request.CategoryRegisterDto;
import com.mtx.ecommerce.dto.response.RegisteredCategoryDto;

public interface ICategoryService {

    RegisteredCategoryDto save(CategoryRegisterDto dto);
}
