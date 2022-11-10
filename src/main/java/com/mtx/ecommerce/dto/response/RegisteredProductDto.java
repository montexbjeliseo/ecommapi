package com.mtx.ecommerce.dto.response;

import lombok.Data;

@Data
public class RegisteredProductDto {
    private Long id;
    private String name;
    private String description;
    private String image;
    private float price;
    private RegisteredCategoryDto category;
    private RegisteredBrandDto brand;
}
