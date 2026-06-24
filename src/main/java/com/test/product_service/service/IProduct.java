package com.test.product_service.service;

import com.test.product_service.dto.ApiResponse;
import com.test.product_service.dto.request.product.AddProductRequestDTO;
import com.test.product_service.dto.request.product.UpdateProductRequestDTO;
import com.test.product_service.dto.response.PageResponse;
import com.test.product_service.dto.response.product.GetProductResponseDTO;
import com.test.product_service.uttils.enums.ProductSortField;
import com.test.product_service.uttils.enums.SortDirection;

public interface IProduct {
    ApiResponse<PageResponse<GetProductResponseDTO>> getAllProducts(int pageNumber, int size, ProductSortField sortBy, SortDirection direction);
    ApiResponse<GetProductResponseDTO> getProductById(Integer id);
    ApiResponse<Integer> addProduct(AddProductRequestDTO addProductRequestDTO);
    ApiResponse<Integer> removeProductById(Integer id);
    ApiResponse<Integer>softRemoveProductById(Integer id);
    ApiResponse<Integer>restoreProductById(Integer id);
    ApiResponse<GetProductResponseDTO> getDeletedProductById(Integer id);
    ApiResponse<PageResponse<GetProductResponseDTO>>getDeletedProduct(int pageNumber, int size, ProductSortField sortBy, SortDirection direction);
    ApiResponse<GetProductResponseDTO> updateProductById( Integer id, UpdateProductRequestDTO updateProductRequestDTO);
}
