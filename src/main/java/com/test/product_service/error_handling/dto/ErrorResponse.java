package com.test.product_service.error_handling.dto;

import lombok.Builder;
import java.time.LocalDateTime;

@Builder
public record ErrorResponse(
         LocalDateTime timestamp,
         int status,
         String error,
         String message,
         String path

) {
}
