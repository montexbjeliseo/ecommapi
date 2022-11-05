package com.mtx.ecommerce.service.impl;

import com.mtx.ecommerce.dto.request.BrandRegisterDto;
import com.mtx.ecommerce.dto.response.RegisteredBrandDto;
import com.mtx.ecommerce.exception.DuplicatedResource;
import com.mtx.ecommerce.mapper.BrandMapper;
import com.mtx.ecommerce.model.Brand;
import com.mtx.ecommerce.repository.BrandRepository;
import com.mtx.ecommerce.service.IBrandService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BrandServiceImpl implements IBrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public RegisteredBrandDto save(BrandRegisterDto dto) {
        if (brandRepository.existsByName(dto.getName())) {
            throw new DuplicatedResource("Already exists brand name");
        }
        Brand brand = brandMapper.toBrand(dto);
        Brand saved = brandRepository.save(brand);
        return brandMapper.toRegisteredDto(saved);

    }
}
