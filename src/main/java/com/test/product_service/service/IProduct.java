package com.test.product_service.service;

import com.test.product_service.dto.response.GetAllProductResponseDTO;

import java.util.List;

public interface IProduct {
    List<GetAllProductResponseDTO> getAllProducts();
}
