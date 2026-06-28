package com.test.product_service.repository;

import com.test.product_service.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface IProductRepo extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {

    Page<Product> findAllByDeletedAtIsNull(Pageable pageable);
    Page<Product> findAllByDeletedAtIsNotNull(Pageable pageable);
    Optional<Product> findByIdAndDeletedAtIsNull(Integer id);
    Optional<Product> findByIdAndDeletedAtIsNotNull(Integer id);
}
