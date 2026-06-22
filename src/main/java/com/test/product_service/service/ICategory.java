package com.test.product_service.service;

import com.test.product_service.dto.request.category.AddUpdateCategoryRequestDTO;
import com.test.product_service.dto.response.AddDeleteResponseDTO;
import com.test.product_service.dto.response.PageResponse;
import com.test.product_service.dto.response.category.GetCategoryResponseDTO;
import com.test.product_service.uttils.enums.CategorySortField;
import com.test.product_service.uttils.enums.SortDirection;

public interface ICategory {
    PageResponse<GetCategoryResponseDTO> getAllCategories(int pageNumber, int size, CategorySortField sortBy, SortDirection direction);
    GetCategoryResponseDTO getCategoryById(Integer id);
    AddDeleteResponseDTO addCategory(AddUpdateCategoryRequestDTO addCategoryRequestDTO);
    AddDeleteResponseDTO removeCategoryById(Integer id);
    GetCategoryResponseDTO updateCategoryById(Integer id, AddUpdateCategoryRequestDTO updateCategoryRequestDTO);
}
