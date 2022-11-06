package com.mtx.ecommerce.service.impl;

import com.mtx.ecommerce.dto.request.RegisterCategoryDto;
import com.mtx.ecommerce.dto.request.UpdateCategoryDto;
import com.mtx.ecommerce.dto.response.RegisteredCategoryDto;
import com.mtx.ecommerce.exception.DuplicatedResourceException;
import com.mtx.ecommerce.exception.ParameterNotFoundException;
import com.mtx.ecommerce.exception.ResourceNotFoundException;
import com.mtx.ecommerce.mapper.CategoryMapper;
import com.mtx.ecommerce.model.Category;
import com.mtx.ecommerce.repository.CategoryRepository;
import com.mtx.ecommerce.service.ICategoryService;
import java.util.List;
import java.util.Objects;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public RegisteredCategoryDto save(RegisterCategoryDto dto) {
        if (categoryRepository.existsByName(dto.getName())) {
            throw new DuplicatedResourceException("Already exists category name.");
        }
        Category category = categoryMapper.toCategory(dto);
        Category saved = categoryRepository.save(category);
        return categoryMapper.toRegisteredDto(saved);
    }

    @Override
    public RegisteredCategoryDto update(Long id, UpdateCategoryDto dto) {

        if (dto.getName() == null && dto.getDescription() == null) {
            throw new ParameterNotFoundException("No parameters were received!");
        }

        if (!categoryRepository.existsById(id)) {
            throw new ResourceNotFoundException("Category not found");
        }
        if (categoryRepository.existsByName(dto.getName())) {
            Category category = categoryRepository.findByName(dto.getName()).get();
            if (!Objects.equals(category.getId(), id)) {
                throw new DuplicatedResourceException("Already exists category name");
            }
        }
        Category category = categoryRepository.findById(id).get();

        category = categoryMapper.update(dto, category);

        Category saved = categoryRepository.save(category);

        return categoryMapper.toRegisteredDto(saved);
    }

    @Override
    public List<RegisteredCategoryDto> getAll() {
        return categoryMapper.toDtoList(categoryRepository.findAll());
    }

}
