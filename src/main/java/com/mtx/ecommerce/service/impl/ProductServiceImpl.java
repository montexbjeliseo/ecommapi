package com.mtx.ecommerce.service.impl;

import com.mtx.ecommerce.dto.request.ProductRegisterDto;
import com.mtx.ecommerce.dto.response.RegisteredProductDto;
import com.mtx.ecommerce.mapper.ProductMapper;
import com.mtx.ecommerce.model.Brand;
import com.mtx.ecommerce.model.Category;
import com.mtx.ecommerce.model.Product;
import com.mtx.ecommerce.repository.BrandRepository;
import com.mtx.ecommerce.repository.CategoryRepository;
import com.mtx.ecommerce.repository.ProductRepository;
import com.mtx.ecommerce.service.IProductService;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public RegisteredProductDto save(ProductRegisterDto dto) {
        Product product = productMapper.toProduct(dto);
        if (dto.getBrand_id() != null) {
            Optional<Brand> brand = brandRepository.findById(dto.getBrand_id());

            if (brand.isPresent()) {
                product.setBrand(brand.get());
            }
        }
        if (dto.getCategory_id() != null) {
            Optional<Category> category = categoryRepository.findById(dto.getCategory_id());

            if (category.isPresent()) {
                product.setCategory(category.get());
            }
        }
        Product saved = productRepository.save(product);
        return productMapper.toRegistered(saved);
    }
}
