package com.test.product_service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Schema(
        name = "ApiResponse",
        description = "Standard API response wrapper"
)
@Builder
public record ApiResponse<T>(

        @Schema(
                description = "Indicates whether the request was processed successfully",
                example = "true"
        )
        boolean success,

        @Schema(
                description = "Human-readable message describing the result of the request",
                example = "Product retrieved successfully."
        )
        String message,

        @Schema(
                description = "Response payload. The type depends on the API endpoint."
        )
        T data

) {
}