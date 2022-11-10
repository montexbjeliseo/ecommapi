package com.mtx.ecommerce.service.impl;

import com.mtx.ecommerce.dto.request.RegisterBrandDto;
import com.mtx.ecommerce.dto.request.UpdateBrandDto;
import com.mtx.ecommerce.dto.response.RegisteredBrandDto;
import com.mtx.ecommerce.exception.DuplicatedResourceException;
import com.mtx.ecommerce.exception.ParameterNotFoundException;
import com.mtx.ecommerce.exception.ResourceNotFoundException;
import com.mtx.ecommerce.mapper.BrandMapper;
import com.mtx.ecommerce.model.Brand;
import com.mtx.ecommerce.repository.BrandRepository;
import com.mtx.ecommerce.service.IBrandService;
import java.util.List;
import java.util.Objects;
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
    public RegisteredBrandDto save(RegisterBrandDto dto) {
        if (brandRepository.existsByName(dto.getName())) {
            throw new DuplicatedResourceException("Already exists brand name");
        }
        Brand brand = brandMapper.toBrand(dto);
        Brand saved = brandRepository.save(brand);
        return brandMapper.toRegisteredDto(saved);

    }

    @Override
    public RegisteredBrandDto update(Long id, UpdateBrandDto dto) {

        if (dto.getName() == null && dto.getDescription() == null) {
            throw new ParameterNotFoundException("No parameters were received!");
        }

        if (!brandRepository.existsById(id)) {
            throw new ResourceNotFoundException("Brand not found");
        }
        if (brandRepository.existsByName(dto.getName())) {
            Brand brand = brandRepository.findByName(dto.getName()).get();
            if (!Objects.equals(brand.getId(), id)) {
                throw new DuplicatedResourceException("Already exists brand name");
            }
        }
        Brand brand = brandRepository.findById(id).get();

        brand = brandMapper.update(dto, brand);

        Brand saved = brandRepository.save(brand);

        return brandMapper.toRegisteredDto(saved);

    }

    @Override
    public List<RegisteredBrandDto> getAll() {
        return brandMapper.toDtoList(brandRepository.findAll());
    }

    @Override
    public RegisteredBrandDto delete(Long id) {
        if (!brandRepository.existsById(id)) {
            throw new ResourceNotFoundException("Brand not found");
        }
        Brand brand = brandRepository.findById(id).get();

        brandRepository.deleteById(id);

        return brandMapper.toRegisteredDto(brand);
    }
}
