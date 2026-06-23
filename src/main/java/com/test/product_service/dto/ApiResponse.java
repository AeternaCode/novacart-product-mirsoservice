package com.test.product_service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Schema(description = "Standard API response wrapper")
@Builder
public record ApiResponse<T>(
        boolean success,
        String message,
        T data
) {}
