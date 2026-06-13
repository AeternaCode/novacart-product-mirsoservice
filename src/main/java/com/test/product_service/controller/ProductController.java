package com.test.product_service.controller;

import com.test.product_service.dto.response.product.GetProductResponseDTO;
import com.test.product_service.service.impl.ProductImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductImpl productService;

    @GetMapping("/get-all-products")
    public ResponseEntity<List<GetProductResponseDTO>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    // get by id
    @GetMapping("/get-product-by-id/{id}")
    public ResponseEntity<GetProductResponseDTO> getProductById(@PathVariable  Integer id){
        return ResponseEntity.ok(productService.getProductById(id));
    }
    //add

    // delete

    // update

}
