package com.mtx.ecommerce.mapper;

import com.mtx.ecommerce.dto.request.CategoryRegisterDto;
import com.mtx.ecommerce.dto.response.RegisteredCategoryDto;
import com.mtx.ecommerce.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toCategory(CategoryRegisterDto dto);

    RegisteredCategoryDto toRegistered(Category category);
}
