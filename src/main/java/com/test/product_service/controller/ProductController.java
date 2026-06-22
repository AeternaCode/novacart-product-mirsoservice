package com.test.product_service.controller;

import com.test.product_service.dto.request.product.AddProductRequestDTO;
import com.test.product_service.dto.request.product.UpdateProductRequestDTO;
import com.test.product_service.dto.response.AddDeleteResponseDTO;
import com.test.product_service.dto.response.PageResponse;
import com.test.product_service.dto.response.product.GetProductResponseDTO;
import com.test.product_service.service.impl.ProductServiceImpl;
import com.test.product_service.uttils.enums.ProductSortField;
import com.test.product_service.uttils.enums.SortDirection;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@Validated
public class ProductController {

    private final ProductServiceImpl productService;

    @GetMapping("/get-all-products")
    public ResponseEntity<PageResponse<GetProductResponseDTO>> getAllProducts(
            @RequestParam(defaultValue = "0") @PositiveOrZero(message = "Page number cannot be negative") int pageNumber,
            @RequestParam(defaultValue = "10") @Positive(message = "Size must be greater than 0") int size,
            @RequestParam(defaultValue = "ID") ProductSortField sortBy,
            @RequestParam(defaultValue = "ASC") SortDirection direction){
        return ResponseEntity.ok(productService.getAllProducts(pageNumber, size, sortBy, direction));
    }

    // get by id
    @GetMapping("/get-product-by-id/{id}")
    public ResponseEntity<GetProductResponseDTO> getProductById(@PathVariable @Positive(message = "Id must be greater than 0")  Integer id){
        return ResponseEntity.ok(productService.getProductById(id));
    }
    //add
    @PostMapping("/add-product")
    public ResponseEntity<AddDeleteResponseDTO> addProduct(@Valid @RequestBody AddProductRequestDTO addProductRequestDTO){
        AddDeleteResponseDTO addProductResponseDTO = productService.addProduct(addProductRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(addProductResponseDTO);
    }
    // delete
    @DeleteMapping("/remove-product/{id}")
    public ResponseEntity<AddDeleteResponseDTO> removeProductById(@PathVariable @Positive(message = "Id must be greater than 0") Integer id){
       AddDeleteResponseDTO addDeleteResponseDTO = productService.removeProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(addDeleteResponseDTO);
    }
    // update
    @PatchMapping("/update-product-by-id/{id}")
    public ResponseEntity<GetProductResponseDTO> updateProductById(@PathVariable @Positive(message = "Id must be greater than 0") Integer id, @Valid @RequestBody UpdateProductRequestDTO updateProductRequestDTO){
        return ResponseEntity.ok(productService.updateProductById(id,updateProductRequestDTO));
    }
}
