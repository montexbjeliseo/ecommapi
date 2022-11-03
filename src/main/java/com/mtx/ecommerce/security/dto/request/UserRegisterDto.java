package com.mtx.ecommerce.security.dto.request;

import static com.mtx.ecommerce.util.Constants.Patterns.FIRSTNAME_PATTERN;
import static com.mtx.ecommerce.util.Constants.Patterns.LASTNAME_PATTERN;
import static com.mtx.ecommerce.util.Constants.Patterns.PASSWORD_PATTERN;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserRegisterDto {
    @NotBlank(message = "First name may not be empty")
    @Pattern(regexp = FIRSTNAME_PATTERN)
    private String firstName;
    @NotBlank(message = "Last name may not be empty")
    @Pattern(regexp = LASTNAME_PATTERN)
    private String lastName;
    @Email
    @NotBlank(message = "Email may not be empty")
    private String email;
    @NotBlank
    @Pattern(regexp = PASSWORD_PATTERN)
    private String password;
}
