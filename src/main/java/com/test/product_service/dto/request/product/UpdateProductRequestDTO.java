package com.test.product_service.dto.request.product;

import java.math.BigDecimal;

public record UpdateProductRequestDTO(

        String productName,

        String productImageUrl,

        String productBrand,

        BigDecimal rating,

        String productDescription,

        BigDecimal price,

        Integer stockQuantity,

        Boolean isActive,

        Integer categoryId
) {
}
