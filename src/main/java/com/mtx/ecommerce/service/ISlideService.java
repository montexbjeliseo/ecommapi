package com.mtx.ecommerce.service;

import com.mtx.ecommerce.dto.request.RegisterSlideDto;
import com.mtx.ecommerce.dto.request.UpdateSlideDto;
import com.mtx.ecommerce.dto.response.RegisteredSlideDto;
import java.util.List;

public interface ISlideService {

    RegisteredSlideDto save(RegisterSlideDto dto);

    List<RegisteredSlideDto> getAll();

    RegisteredSlideDto update(Long id, UpdateSlideDto dto);
}
