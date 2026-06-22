package com.test.product_service.repository;

import com.test.product_service.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepo extends JpaRepository<Category, Integer> {

    @Override
    Page<Category> findAll(Pageable pageable);
}
