package com.test.product_service.service;

import com.test.product_service.dto.response.product.GetProductResponseDTO;

import java.util.List;

public interface IProduct {
    List<GetProductResponseDTO> getAllProducts();
    GetProductResponseDTO getProductById(Integer id);
}
