package com.test.product_service.controller;

import com.test.product_service.dto.ApiResponse;
import com.test.product_service.dto.request.category.AddUpdateCategoryRequestDTO;
import com.test.product_service.dto.response.PageResponse;
import com.test.product_service.dto.response.category.GetCategoryResponseDTO;
import com.test.product_service.service.impl.CategoryServiceImpl;
import com.test.product_service.uttils.enums.CategorySortField;
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
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
@Validated
public class CategoryController {

    private final CategoryServiceImpl categoryService;

    @GetMapping("/get-all-categories")
    public ResponseEntity<ApiResponse<PageResponse<GetCategoryResponseDTO>>> getAllCategories(
            @RequestParam(defaultValue = "0") @PositiveOrZero(message = "Page number cannot be negative") int pageNumber,
            @RequestParam(defaultValue = "10") @Positive(message = "Size must be greater than 0") int size,
             @RequestParam(defaultValue = "ID") CategorySortField sortBy,
            @RequestParam(defaultValue = "ASC") SortDirection direction
    ){
        return ResponseEntity.ok(categoryService.getAllCategories(pageNumber, size, sortBy, direction));
    }

    // get by id
    @GetMapping("/get-category-by-id/{id}")
    public ResponseEntity<ApiResponse<GetCategoryResponseDTO>> getCategoryById(@PathVariable @Positive(message = "Id must be greater than 0") Integer id){
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }
    //add
    @PostMapping("/add-category")
    public ResponseEntity<ApiResponse<Integer>> addCategory(@Valid @RequestBody AddUpdateCategoryRequestDTO addCategoryRequestDTO){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoryService.addCategory(addCategoryRequestDTO));
    }
    // delete
    @DeleteMapping("/remove-category/{id}")
    public ResponseEntity<ApiResponse<Integer>> removeCategoryById(@PathVariable @Positive(message = "Id must be greater than 0") Integer id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(categoryService.removeCategoryById(id));
    }
    // update
    @PatchMapping("/update-category-by-id/{id}")
    public ResponseEntity<ApiResponse<GetCategoryResponseDTO>> updateCategoryById(@PathVariable @Positive(message = "Id must be greater than 0") Integer id,@Valid @RequestBody AddUpdateCategoryRequestDTO  updateCategoryRequestDTO){
        return ResponseEntity.ok(categoryService.updateCategoryById(id,updateCategoryRequestDTO));
    }
}
