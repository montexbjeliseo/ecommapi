package com.mtx.ecommerce.mapper;

import com.mtx.ecommerce.dto.request.RegisterBrandDto;
import com.mtx.ecommerce.dto.request.UpdateBrandDto;
import com.mtx.ecommerce.dto.response.RegisteredBrandDto;
import com.mtx.ecommerce.model.Brand;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface BrandMapper {

    Brand toBrand(RegisterBrandDto dto);

    RegisteredBrandDto toRegisteredDto(Brand brand);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Brand update(UpdateBrandDto dto, @MappingTarget Brand brand);
}
