package com.mtx.ecommerce.service;

import com.mtx.ecommerce.dto.request.RegisterProductDto;
import com.mtx.ecommerce.dto.request.UpdateProductDto;
import com.mtx.ecommerce.dto.response.RegisteredProductDto;

public interface IProductService {

    RegisteredProductDto save(RegisterProductDto dto);

    RegisteredProductDto update(Long id, UpdateProductDto dto);
}
