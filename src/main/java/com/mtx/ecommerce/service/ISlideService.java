package com.mtx.ecommerce.service;

import com.mtx.ecommerce.dto.request.RegisterSlideDto;
import com.mtx.ecommerce.dto.response.RegisteredSlideDto;

public interface ISlideService {

    RegisteredSlideDto save(RegisterSlideDto dto);
}
