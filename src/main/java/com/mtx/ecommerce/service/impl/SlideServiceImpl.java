package com.mtx.ecommerce.service.impl;

import com.mtx.ecommerce.dto.request.RegisterSlideDto;
import com.mtx.ecommerce.dto.response.RegisteredSlideDto;
import com.mtx.ecommerce.mapper.SlideMapper;
import com.mtx.ecommerce.model.Slide;
import com.mtx.ecommerce.repository.SlideRepository;
import com.mtx.ecommerce.service.ISlideService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SlideServiceImpl implements ISlideService {

    @Autowired
    private SlideRepository slideRepository;

    @Autowired
    private SlideMapper slideMapper;

    @Override
    public RegisteredSlideDto save(RegisterSlideDto dto) {
        Slide saved = slideRepository.save(slideMapper.toSlide(dto));
        return slideMapper.toDto(saved);
    }

    @Override
    public List<RegisteredSlideDto> getAll() {
        return slideMapper.toDtoList(slideRepository.findAll());
    }

}
