package com.test.product_service.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record PageResponse<T>(
         List<T> content,

         int pageNumber,

         int pageSize,

         long totalElements,

         int totalPages,

         int numberOfElements,

         boolean first,

         boolean last
) {
}
