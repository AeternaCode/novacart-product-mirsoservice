package com.test.product_service.repository;

import com.test.product_service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepo extends JpaRepository<Product, Integer> {

}
