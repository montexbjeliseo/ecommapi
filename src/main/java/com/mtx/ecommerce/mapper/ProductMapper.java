package com.mtx.ecommerce.mapper;

import com.mtx.ecommerce.dto.request.ProductRegisterDto;
import com.mtx.ecommerce.dto.response.RegisteredProductDto;
import com.mtx.ecommerce.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toProduct(ProductRegisterDto dto);

    RegisteredProductDto toRegistered(Product product);
}
