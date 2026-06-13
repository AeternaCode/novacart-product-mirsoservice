package com.test.product_service.controller;

import com.test.product_service.dto.request.category.AddUpdateCategoryRequestDTO;
import com.test.product_service.dto.response.category.GetCategoryResponseDTO;
import com.test.product_service.service.impl.CategoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryImpl categoryService;

    @GetMapping("/get-all-categories")
    public ResponseEntity<List<GetCategoryResponseDTO>> getAllCategories(){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    // get by id
    @GetMapping("/get-category-by-id/{id}")
    public ResponseEntity<GetCategoryResponseDTO> getCategoryById(@PathVariable Integer id){
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }
    //add
    @PostMapping("/add-category")
    public ResponseEntity<Void> addCategory(@RequestBody AddUpdateCategoryRequestDTO addCategoryRequestDTO){
        categoryService.addCategory(addCategoryRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    // delete
    @DeleteMapping("/remove-category/{id}")
    public ResponseEntity<Void> removeCategoryById(@PathVariable  Integer id){
        categoryService.removeCategoryById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    // update
    @PatchMapping("/update-category-by-id/{id}")
    public ResponseEntity<GetCategoryResponseDTO> updateCategoryById(@PathVariable  Integer id, @RequestBody AddUpdateCategoryRequestDTO  updateCategoryRequestDTO){
        return ResponseEntity.ok(categoryService.updateCategoryById(id,updateCategoryRequestDTO));
    }
}
