package com.mtx.ecommerce.exception.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExceptionDto {
    private int statusCode;
    private Date timestamp;
    private String message;
    private String description;
}
