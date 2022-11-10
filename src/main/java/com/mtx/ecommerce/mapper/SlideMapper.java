package com.mtx.ecommerce.mapper;

import com.mtx.ecommerce.dto.request.RegisterSlideDto;
import com.mtx.ecommerce.dto.response.RegisteredSlideDto;
import com.mtx.ecommerce.model.Slide;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SlideMapper {

    Slide toSlide(RegisterSlideDto dto);

    RegisteredSlideDto toDto(Slide slide);
}
