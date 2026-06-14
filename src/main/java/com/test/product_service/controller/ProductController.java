package com.test.product_service.controller;

import com.test.product_service.dto.request.product.AddProductRequestDTO;
import com.test.product_service.dto.request.product.UpdateProductRequestDTO;
import com.test.product_service.dto.response.product.GetProductResponseDTO;
import com.test.product_service.service.impl.ProductServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceImpl productService;

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
    @PostMapping("/add-product")
    public ResponseEntity<Void> addProduct(@Valid @RequestBody AddProductRequestDTO addProductRequestDTO){
        productService.addProduct(addProductRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    // delete
    @DeleteMapping("/remove-product/{id}")
    public ResponseEntity<Void> removeProductById(@PathVariable  Integer id){
        productService.removeProductById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    // update
    @PatchMapping("/update-product-by-id/{id}")
    public ResponseEntity<GetProductResponseDTO> updateProductById(@PathVariable  Integer id, @Valid @RequestBody UpdateProductRequestDTO updateProductRequestDTO){
        return ResponseEntity.ok(productService.updateProductById(id,updateProductRequestDTO));
    }
}
