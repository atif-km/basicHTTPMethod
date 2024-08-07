package com.ecom.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.ecommerce.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
