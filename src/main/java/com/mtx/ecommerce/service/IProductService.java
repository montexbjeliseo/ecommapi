package com.mtx.ecommerce.service;

import com.mtx.ecommerce.dto.request.RegisterProductDto;
import com.mtx.ecommerce.dto.request.UpdateProductDto;
import com.mtx.ecommerce.dto.response.ProductSearchResultDto;
import com.mtx.ecommerce.dto.response.RegisteredProductDto;
import java.util.List;
import java.util.Map;

public interface IProductService {

    RegisteredProductDto save(RegisterProductDto dto);

    RegisteredProductDto update(Long id, UpdateProductDto dto);
    
    List<RegisteredProductDto> getAll();
    
    ProductSearchResultDto getSearch(Map<String, String> params);
}
