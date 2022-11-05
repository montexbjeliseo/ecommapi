package com.mtx.ecommerce.service;

import com.mtx.ecommerce.dto.request.BrandRegisterDto;
import com.mtx.ecommerce.dto.response.RegisteredBrandDto;

public interface IBrandService {
    RegisteredBrandDto save(BrandRegisterDto dto);
}
