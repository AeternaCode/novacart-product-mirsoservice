package com.test.product_service.dto.response.category;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDateTime;

@Schema(description = "Category details returned to the client")
@Builder
public record GetCategoryResponseDTO(
        int id,
        String categoryName,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        Integer createdBy,
        Integer updatedBy,
        boolean isActive,
        LocalDateTime deletedAt
)
{}
