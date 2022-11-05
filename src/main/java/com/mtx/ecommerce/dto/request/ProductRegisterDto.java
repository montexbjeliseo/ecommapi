package com.mtx.ecommerce.dto.request;

import lombok.Data;

@Data
public class ProductRegisterDto {

    private String name;
    private String description;
    private String image;
    private float price;
    private Long category_id;
    private Long brand_id;
}
