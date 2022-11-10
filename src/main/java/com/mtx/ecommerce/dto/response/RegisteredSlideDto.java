package com.mtx.ecommerce.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegisteredSlideDto {

    private Long id;
    private Long alt;
    private String image;
    private String link;
}
