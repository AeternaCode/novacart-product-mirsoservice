package com.test.product_service.dto.response.product;

import java.math.BigDecimal;

public record AddProductRequestDTO(

        String productName,

        String productImageUrl,

        String productBrand,

        String productDescription,

        BigDecimal price,

        Integer stockQuantity,

        Boolean isActive,

        Integer categoryId

        ) {
}
