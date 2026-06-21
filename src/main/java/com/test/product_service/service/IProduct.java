package com.test.product_service.service;

import com.test.product_service.dto.request.product.AddProductRequestDTO;
import com.test.product_service.dto.request.product.UpdateProductRequestDTO;
import com.test.product_service.dto.response.AddDeleteResponseDTO;
import com.test.product_service.dto.response.product.GetProductResponseDTO;
import java.util.List;

public interface IProduct {
    List<GetProductResponseDTO> getAllProducts();
    GetProductResponseDTO getProductById(Integer id);
    AddDeleteResponseDTO addProduct(AddProductRequestDTO addProductRequestDTO);
    AddDeleteResponseDTO removeProductById(Integer id);
    GetProductResponseDTO updateProductById( Integer id, UpdateProductRequestDTO updateProductRequestDTO);
}
