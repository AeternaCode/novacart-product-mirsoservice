package com.test.product_service.service;

import com.test.product_service.dto.request.category.AddUpdateCategoryRequestDTO;
import com.test.product_service.dto.response.AddDeleteResponseDTO;
import com.test.product_service.dto.response.category.GetCategoryResponseDTO;

import java.util.List;

public interface ICategory {
    List<GetCategoryResponseDTO> getAllCategories();
    GetCategoryResponseDTO getCategoryById(Integer id);
    AddDeleteResponseDTO addCategory(AddUpdateCategoryRequestDTO addCategoryRequestDTO);
    AddDeleteResponseDTO removeCategoryById(Integer id);
    GetCategoryResponseDTO updateCategoryById(Integer id, AddUpdateCategoryRequestDTO updateCategoryRequestDTO);
}
