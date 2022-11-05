package com.mtx.ecommerce.dto.response;

import lombok.Data;

@Data
public class RegisteredBrandDto {

    private Long id;
    private String name;
    private String description;
    private String image;
}
