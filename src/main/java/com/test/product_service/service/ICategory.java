package com.test.product_service.service;

import com.test.product_service.dto.response.category.GetAllCategoryResponseDTO;

import java.util.List;

public interface ICategory {
    List<GetAllCategoryResponseDTO> getAllCategories();
}
