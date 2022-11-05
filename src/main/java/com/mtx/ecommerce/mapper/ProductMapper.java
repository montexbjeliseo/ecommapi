package com.mtx.ecommerce.mapper;

import com.mtx.ecommerce.dto.request.RegisterProductDto;
import com.mtx.ecommerce.dto.request.UpdateProductDto;
import com.mtx.ecommerce.dto.response.RegisteredProductDto;
import com.mtx.ecommerce.model.Product;
import java.util.List;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toProduct(RegisterProductDto dto);

    RegisteredProductDto toRegistered(Product product);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Product update(UpdateProductDto dto, @MappingTarget Product product);

    List<RegisteredProductDto> toDtoList(List<Product> products);
}
