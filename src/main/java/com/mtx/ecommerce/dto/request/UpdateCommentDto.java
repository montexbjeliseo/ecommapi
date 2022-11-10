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
public class UpdateCommentDto {

    @NotBlank
    @Pattern(regexp = Constants.Patterns.COMMENT_PATTERN)
    private String body;
}
