package com.mtx.ecommerce.service;

import com.mtx.ecommerce.dto.request.RegisterBrandDto;
import com.mtx.ecommerce.dto.request.UpdateBrandDto;
import com.mtx.ecommerce.dto.response.RegisteredBrandDto;

public interface IBrandService {

    RegisteredBrandDto save(RegisterBrandDto dto);

    RegisteredBrandDto update(Long id, UpdateBrandDto dto);
}
