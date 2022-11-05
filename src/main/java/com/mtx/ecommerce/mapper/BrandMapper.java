package com.mtx.ecommerce.mapper;

import com.mtx.ecommerce.dto.request.BrandRegisterDto;
import com.mtx.ecommerce.dto.response.RegisteredBrandDto;
import com.mtx.ecommerce.model.Brand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapper {

    Brand toBrand(BrandRegisterDto dto);

    RegisteredBrandDto toRegisteredDto(Brand brand);
}
