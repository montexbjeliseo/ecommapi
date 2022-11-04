package com.mtx.ecommerce.security.dto.request;

import static com.mtx.ecommerce.util.Constants.Messages.Validations.EMAIL_MESSAGE;
import static com.mtx.ecommerce.util.Constants.Messages.Validations.PASSWORD_MESSAGE;
import static com.mtx.ecommerce.util.Constants.Patterns.PASSWORD_PATTERN;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserLoginDto {

    @Email(message = EMAIL_MESSAGE)
    private String username;

    @Pattern(regexp = PASSWORD_PATTERN, message = PASSWORD_MESSAGE)
    private String password;
}
