package com.mtx.ecommerce.dto.request;

import com.mtx.ecommerce.util.Constants;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegisterSlideDto {

    @NotBlank
    @Pattern(regexp = Constants.Patterns.SLIDES_ALT_PATTERN)
    private Long alt;

    @NotBlank
    private String image;

    @NotBlank
    private String link;
}
