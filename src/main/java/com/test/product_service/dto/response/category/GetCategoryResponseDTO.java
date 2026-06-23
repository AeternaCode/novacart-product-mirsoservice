package com.test.product_service.dto.response.category;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record GetCategoryResponseDTO(
        int id,
        String categoryName,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
)
{}
