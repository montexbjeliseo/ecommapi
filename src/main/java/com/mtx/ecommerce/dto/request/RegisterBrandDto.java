package com.mtx.ecommerce.dto.request;

import static com.mtx.ecommerce.util.Constants.Patterns.DESCRIPTION_PATTERN;
import static com.mtx.ecommerce.util.Constants.Patterns.NAME_PATTERN;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
public class RegisterBrandDto {

    @NotBlank
    @Pattern(regexp = NAME_PATTERN)
    private String name;
    @NotBlank
    @Pattern(regexp = DESCRIPTION_PATTERN)
    private String description;
    private String image;
}
