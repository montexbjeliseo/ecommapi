package com.mtx.ecommerce.security.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserRegisterDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
