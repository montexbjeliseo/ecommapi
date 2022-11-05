package com.mtx.ecommerce.mapper;

import com.mtx.ecommerce.dto.request.RegisterCategoryDto;
import com.mtx.ecommerce.dto.request.UpdateCategoryDto;
import com.mtx.ecommerce.dto.response.RegisteredCategoryDto;
import com.mtx.ecommerce.model.Category;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toCategory(RegisterCategoryDto dto);

    RegisteredCategoryDto toRegisteredDto(Category category);
    
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Category update(UpdateCategoryDto dto, @MappingTarget Category category);
}
