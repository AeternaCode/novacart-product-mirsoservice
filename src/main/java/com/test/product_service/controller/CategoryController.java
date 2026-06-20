package com.test.product_service.controller;

import com.test.product_service.dto.request.category.AddUpdateCategoryRequestDTO;
import com.test.product_service.dto.response.AddDeleteResponseDTO;
import com.test.product_service.dto.response.category.GetCategoryResponseDTO;
import com.test.product_service.service.impl.CategoryServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
@Validated
public class CategoryController {

    private final CategoryServiceImpl categoryService;

    @GetMapping("/get-all-categories")
    public ResponseEntity<List<GetCategoryResponseDTO>> getAllCategories(){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    // get by id
    @GetMapping("/get-category-by-id/{id}")
    public ResponseEntity<GetCategoryResponseDTO> getCategoryById(@PathVariable @Positive(message = "Id must be greater than 0") Integer id){
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }
    //add
    @PostMapping("/add-category")
    public ResponseEntity<AddDeleteResponseDTO> addCategory(@Valid @RequestBody AddUpdateCategoryRequestDTO addCategoryRequestDTO){
        AddDeleteResponseDTO addDeleteResponseDTO = categoryService.addCategory(addCategoryRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(addDeleteResponseDTO);
    }
    // delete
    @DeleteMapping("/remove-category/{id}")
    public ResponseEntity<AddDeleteResponseDTO> removeCategoryById(@PathVariable @Positive(message = "Id must be greater than 0") Integer id){
        AddDeleteResponseDTO addDeleteResponseDTO = categoryService.removeCategoryById(id);
        return ResponseEntity.status(HttpStatus.OK).body(addDeleteResponseDTO);
    }
    // update
    @PatchMapping("/update-category-by-id/{id}")
    public ResponseEntity<GetCategoryResponseDTO> updateCategoryById(@PathVariable @Positive(message = "Id must be greater than 0") Integer id,@Valid @RequestBody AddUpdateCategoryRequestDTO  updateCategoryRequestDTO){
        return ResponseEntity.ok(categoryService.updateCategoryById(id,updateCategoryRequestDTO));
    }
}
