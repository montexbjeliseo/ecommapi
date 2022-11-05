package com.mtx.ecommerce.dto.request;

import static com.mtx.ecommerce.util.Constants.Patterns.DESCRIPTION_PATTERN;
import static com.mtx.ecommerce.util.Constants.Patterns.NAME_PATTERN;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UpdateCategoryDto {

    @Pattern(regexp = NAME_PATTERN)
    private String name;
    @Pattern(regexp = DESCRIPTION_PATTERN)
    private String description;
}
