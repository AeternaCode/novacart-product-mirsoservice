package com.test.product_service.service;

import com.test.product_service.dto.request.category.AddUpdateCategoryRequestDTO;
import com.test.product_service.dto.response.AddDeleteResponseDTO;
import com.test.product_service.dto.response.PageResponse;
import com.test.product_service.dto.response.category.GetCategoryResponseDTO;

public interface ICategory {
    PageResponse<GetCategoryResponseDTO> getAllCategories(int pageNumber, int size);
    GetCategoryResponseDTO getCategoryById(Integer id);
    AddDeleteResponseDTO addCategory(AddUpdateCategoryRequestDTO addCategoryRequestDTO);
    AddDeleteResponseDTO removeCategoryById(Integer id);
    GetCategoryResponseDTO updateCategoryById(Integer id, AddUpdateCategoryRequestDTO updateCategoryRequestDTO);
}
