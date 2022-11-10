package com.mtx.ecommerce.mapper;

import com.mtx.ecommerce.dto.request.RegisterSlideDto;
import com.mtx.ecommerce.dto.request.UpdateSlideDto;
import com.mtx.ecommerce.dto.response.RegisteredSlideDto;
import com.mtx.ecommerce.model.Slide;
import java.util.List;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface SlideMapper {

    Slide toSlide(RegisterSlideDto dto);

    RegisteredSlideDto toDto(Slide slide);

    List<RegisteredSlideDto> toDtoList(List<Slide> list);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Slide update(UpdateSlideDto dto, @MappingTarget Slide slide);
}
