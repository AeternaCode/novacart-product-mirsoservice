package com.test.product_service.service;

import com.test.product_service.dto.ApiResponse;
import com.test.product_service.dto.request.category.AddUpdateCategoryRequestDTO;
import com.test.product_service.dto.response.PageResponse;
import com.test.product_service.dto.response.category.GetCategoryResponseDTO;
import com.test.product_service.uttils.enums.CategorySortField;
import com.test.product_service.uttils.enums.SortDirection;

public interface ICategory {
    ApiResponse<PageResponse<GetCategoryResponseDTO>> getAllCategories(int pageNumber, int size, CategorySortField sortBy, SortDirection direction);
    ApiResponse<GetCategoryResponseDTO> getCategoryById(Integer id);
    ApiResponse<Integer> addCategory(AddUpdateCategoryRequestDTO addCategoryRequestDTO);
    ApiResponse<Integer> removeCategoryById(Integer id);
    ApiResponse<GetCategoryResponseDTO> updateCategoryById(Integer id, AddUpdateCategoryRequestDTO updateCategoryRequestDTO);
}
