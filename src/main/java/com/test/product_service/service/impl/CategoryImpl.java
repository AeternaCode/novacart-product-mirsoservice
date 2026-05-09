package com.test.product_service.service.impl;

import com.test.product_service.dto.response.GetAllCategoryResponseDTO;
import com.test.product_service.repository.ICategoryRepo;
import com.test.product_service.service.ICategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryImpl implements ICategory {

    private final ICategoryRepo categoryRepo;

    @Override
    public List<GetAllCategoryResponseDTO> getAllCategories() {
        return categoryRepo.findAll().stream()
                .map(category ->
                    GetAllCategoryResponseDTO.builder()
                            .id(category.getId())
                            .categoryName(category.getCategoryName())
                            .build()
                ).toList();
    }

}
