package com.mtx.ecommerce.service.impl;

import com.mtx.ecommerce.dto.request.CategoryRegisterDto;
import com.mtx.ecommerce.dto.response.RegisteredCategoryDto;
import com.mtx.ecommerce.exception.DuplicatedResource;
import com.mtx.ecommerce.mapper.CategoryMapper;
import com.mtx.ecommerce.model.Category;
import com.mtx.ecommerce.repository.CategoryRepository;
import com.mtx.ecommerce.service.ICategoryService;
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
    public RegisteredCategoryDto save(CategoryRegisterDto dto) {
        if (categoryRepository.existsByName(dto.getName())) {
            throw new DuplicatedResource("Already exists category name.");
        }
        Category category = categoryMapper.toCategory(dto);
        Category saved = categoryRepository.save(category);
        return categoryMapper.toRegistered(saved);
    }
}
