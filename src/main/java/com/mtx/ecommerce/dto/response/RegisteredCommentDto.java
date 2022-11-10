package com.mtx.ecommerce.dto.response;

import lombok.Data;

@Data
public class RegisteredCommentDto {

    private Long id;
    private String body;
    private PublicUserDto user;
}
