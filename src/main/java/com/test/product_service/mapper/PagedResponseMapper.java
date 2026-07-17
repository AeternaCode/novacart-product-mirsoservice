package com.test.product_service.mapper;

import com.test.product_service.dto.response.PageResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public final class PagedResponseMapper {
    private PagedResponseMapper() {}

    public static <T> PageResponse<T> toPageResponse(List<T> listDto, Page<?> page) {
        return PageResponse.<T>builder()
                .content(listDto)
                .pageNumber(page.getNumber())
                .pageSize(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .numberOfElements(page.getNumberOfElements())
                .first(page.isFirst())
                .last(page.isLast())
                .build();
    }
}
