package com.ecom.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.ecommerce.entity.Order;
import com.ecom.ecommerce.exception.OrderNotFoundException;
import com.ecom.ecommerce.repo.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(()->new OrderNotFoundException("Order Not Found with id "+id));
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
    	
    	if (!orderRepository.existsById(id)) {
			throw new OrderNotFoundException("Order Not Found with Id "+id);
		}
        orderRepository.deleteById(id);
    }
}

