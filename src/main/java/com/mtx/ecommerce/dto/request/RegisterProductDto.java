package com.mtx.ecommerce.dto.request;

import static com.mtx.ecommerce.util.Constants.Patterns.DESCRIPTION_PATTERN;
import static com.mtx.ecommerce.util.Constants.Patterns.NAME_PATTERN;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
public class RegisterProductDto {

    @NotBlank
    @Pattern(regexp = NAME_PATTERN)
    private String name;
    @NotBlank
    @Pattern(regexp = DESCRIPTION_PATTERN)
    private String description;
    private String image;
    @NotNull
    private float price;
    @NotNull
    private Long category_id;
    @NotNull
    private Long brand_id;
}
