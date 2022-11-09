package com.mtx.ecommerce.dto.request;

import com.mtx.ecommerce.util.Constants.Patterns;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
public class RegisterCommentDto {

    @Pattern(regexp = Patterns.COMMENT_PATTERN)
    @NotBlank
    private String body;
}
