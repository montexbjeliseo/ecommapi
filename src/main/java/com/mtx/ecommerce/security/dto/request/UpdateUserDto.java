package com.mtx.ecommerce.security.dto.request;

import static com.mtx.ecommerce.util.Constants.Messages.Validations.EMAIL_MESSAGE;
import static com.mtx.ecommerce.util.Constants.Messages.Validations.FIRSTNAME_MESSAGE;
import static com.mtx.ecommerce.util.Constants.Messages.Validations.LASTNAME_MESSAGE;
import static com.mtx.ecommerce.util.Constants.Messages.Validations.PASSWORD_MESSAGE;
import static com.mtx.ecommerce.util.Constants.Patterns.FIRSTNAME_PATTERN;
import static com.mtx.ecommerce.util.Constants.Patterns.LASTNAME_PATTERN;
import static com.mtx.ecommerce.util.Constants.Patterns.PASSWORD_PATTERN;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UpdateUserDto {

    @Pattern(regexp = FIRSTNAME_PATTERN, message = FIRSTNAME_MESSAGE)
    private String firstName;

    @Pattern(regexp = LASTNAME_PATTERN, message = LASTNAME_MESSAGE)
    private String lastName;

    @Pattern(regexp = PASSWORD_PATTERN, message = PASSWORD_MESSAGE)
    private String password;
    
    private String photo;
}
