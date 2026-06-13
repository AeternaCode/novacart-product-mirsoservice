package com.test.product_service.service.impl;

import com.test.product_service.dto.response.product.GetProductResponseDTO;
import com.test.product_service.entity.Product;
import com.test.product_service.mapper.product.ToDTO;
import com.test.product_service.repository.IProductRepo;
import com.test.product_service.service.IProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductImpl implements IProduct{

    private final IProductRepo productRepo;

    @Override
    public List<GetProductResponseDTO> getAllProducts() {
        List<Product> products = productRepo.findAll();
        return ToDTO.toGetProductResponseDTO(products);
    }

    @Override
    public GetProductResponseDTO getProductById(Integer id){
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("No Product Found"));
        return ToDTO.toGetProductResponseDTO(product);
    }
}
