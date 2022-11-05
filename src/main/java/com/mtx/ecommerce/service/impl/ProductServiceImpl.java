package com.mtx.ecommerce.service.impl;

import com.mtx.ecommerce.dto.request.RegisterProductDto;
import com.mtx.ecommerce.dto.request.UpdateProductDto;
import com.mtx.ecommerce.dto.response.RegisteredProductDto;
import com.mtx.ecommerce.exception.DuplicatedResourceException;
import com.mtx.ecommerce.exception.ParameterNotFoundException;
import com.mtx.ecommerce.exception.ResourceNotFoundException;
import com.mtx.ecommerce.mapper.ProductMapper;
import com.mtx.ecommerce.model.Brand;
import com.mtx.ecommerce.model.Category;
import com.mtx.ecommerce.model.Product;
import com.mtx.ecommerce.repository.BrandRepository;
import com.mtx.ecommerce.repository.CategoryRepository;
import com.mtx.ecommerce.repository.ProductRepository;
import com.mtx.ecommerce.service.IProductService;
import java.util.List;
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
    public RegisteredProductDto save(RegisterProductDto dto) {

        if (productRepository.existsNameAndBrandDuplicatedProductCustomQuery(dto.getName(), dto.getBrand_id())) {
            throw new DuplicatedResourceException("Already exists a product with the same name and brand");
        }

        Product product = productMapper.toProduct(dto);

        product = updateBrand(dto.getBrand_id(), product);

        product = updateCategory(dto.getCategory_id(), product);

        Product saved = productRepository.save(product);

        return productMapper.toRegistered(saved);
    }

    @Override
    public RegisteredProductDto update(Long id, UpdateProductDto dto) {

        if (dto.getName() == null
                && dto.getDescription() == null
                && dto.getImage() == null
                && new Float(dto.getPrice()) == null
                && dto.getCategory_id() == null
                && dto.getBrand_id() == null) {
            throw new ParameterNotFoundException("No parameters were received!");
        }

        if (dto.getName() == null && dto.getDescription() == null) {
            throw new ParameterNotFoundException("No parameters were received!");
        }
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product not found");
        }

        if (productRepository.existsNameAndBrandDuplicatedProductIdCustomQuery(id, dto.getName(), dto.getBrand_id())) {
            throw new DuplicatedResourceException("Already exists a product with the same name and brand");
        }

        Product product = productRepository.findById(id).get();
        product = productMapper.update(dto, product);
        if (dto.getBrand_id() != null) {
            product = updateBrand(dto.getBrand_id(), product);
        }
        if (dto.getCategory_id() != null) {
            product = updateCategory(dto.getCategory_id(), product);
        }
        Product saved = productRepository.save(product);
        return productMapper.toRegistered(saved);
    }

    private Product updateCategory(Long id, Product product) {
        Optional<Category> category = categoryRepository.findById(id);
        if (!category.isPresent()) {
            throw new ResourceNotFoundException("Category not found with id: " + id);
        }
        product.setCategory(category.get());

        return product;
    }

    private Product updateBrand(Long id, Product product) {
        Optional<Brand> brand = brandRepository.findById(id);
        if (!brand.isPresent()) {
            throw new ResourceNotFoundException("Brand not found with id: " + id);
        }
        product.setBrand(brand.get());

        return product;
    }

    @Override
    public List<RegisteredProductDto> getAll() {
        return productMapper.toDtoList(productRepository.findAll());
    }

}
