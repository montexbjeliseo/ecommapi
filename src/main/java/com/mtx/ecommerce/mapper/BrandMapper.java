package com.mtx.ecommerce.mapper;

import com.mtx.ecommerce.dto.request.RegisterBrandDto;
import com.mtx.ecommerce.dto.request.UpdateBrandDto;
import com.mtx.ecommerce.dto.response.RegisteredBrandDto;
import com.mtx.ecommerce.model.Brand;
import java.util.List;
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
    
    List<RegisteredBrandDto> toDtoList(List<Brand> brands);
}
