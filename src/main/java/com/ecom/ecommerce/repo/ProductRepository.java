package com.ecom.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.ecommerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
