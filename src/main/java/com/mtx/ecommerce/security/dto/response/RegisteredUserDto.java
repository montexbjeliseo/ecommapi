package com.mtx.ecommerce.security.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegisteredUserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String photo;
    private String email;
    private String jwtToken;
}
