package com.test.product_service.dto.response;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record GetAllProductResponseDTO(
        Integer id,

        String productName,

        String productImageUrl,

        String productBrand,

        BigDecimal rating,

        String productDescription,

        BigDecimal price,

        Integer stockQuantity,

        Boolean isActive,

        Integer createdBy,

        Integer updatedBy,

        LocalDateTime createdAt,

        LocalDateTime updatedAt,

        Integer categoryId,

        String categoryName)
{}