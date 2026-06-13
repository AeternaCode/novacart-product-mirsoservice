package com.test.product_service.mapper.category;

import com.test.product_service.dto.request.category.AddUpdateCategoryRequestDTO;
import com.test.product_service.dto.response.category.GetCategoryResponseDTO;
import com.test.product_service.entity.Category;

import java.util.List;

public class CategoryMapper {

    public static  GetCategoryResponseDTO toDTO(Category category) {
        return GetCategoryResponseDTO.builder()
                .id(category.getId())
                .categoryName(category.getCategoryName())
                .build();
    }

    public static  List<GetCategoryResponseDTO> toDto(List<Category> category) {
        return category.stream().map(cat -> GetCategoryResponseDTO.builder()
                        .id(cat.getId())
                        .categoryName(cat.getCategoryName())
                        .build()
        ).toList();
    }

    public static  Category toEntity(AddUpdateCategoryRequestDTO getCategoryResponseDTO) {
        return Category.builder()
                .categoryName(getCategoryResponseDTO.name())
                .build();
    }
}
