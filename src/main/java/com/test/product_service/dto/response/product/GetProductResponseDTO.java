package com.test.product_service.dto.response.product;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Product details returned to the client")
@Builder
public record GetProductResponseDTO(
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