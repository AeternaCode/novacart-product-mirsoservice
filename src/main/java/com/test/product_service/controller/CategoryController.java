package com.test.product_service.controller;

import com.test.product_service.dto.response.GetAllCategoryResponseDTO;
import com.test.product_service.service.impl.CategoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryImpl categoryService;

    @GetMapping("/get-all-categories")
    public ResponseEntity<List<GetAllCategoryResponseDTO>> getAllCategories(){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
}
