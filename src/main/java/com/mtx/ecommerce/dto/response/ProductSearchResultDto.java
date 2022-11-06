package com.mtx.ecommerce.dto.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductSearchResultDto {

    private String q;
    private int page;
    private int page_size;
    private List<RegisteredProductDto> products;
}
