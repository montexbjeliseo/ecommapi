package com.mtx.ecommerce.service;

import com.mtx.ecommerce.dto.request.ProductRegisterDto;
import com.mtx.ecommerce.dto.response.RegisteredProductDto;

public interface IProductService {

    RegisteredProductDto save(ProductRegisterDto dto);
}
