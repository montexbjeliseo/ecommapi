package com.mtx.ecommerce.security.dto.request;

import static com.mtx.ecommerce.util.Constants.Messages.Validations.EMAIL_MESSAGE;
import static com.mtx.ecommerce.util.Constants.Messages.Validations.PASSWORD_MESSAGE;
import static com.mtx.ecommerce.util.Constants.Patterns.PASSWORD_PATTERN;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
public class LoginUserDto {

    @NotBlank
    @Email(message = EMAIL_MESSAGE)
    private String username;
    @NotBlank
    @Pattern(regexp = PASSWORD_PATTERN, message = PASSWORD_MESSAGE)
    private String password;
}
