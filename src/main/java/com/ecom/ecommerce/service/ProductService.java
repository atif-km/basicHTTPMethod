package com.ecom.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.ecommerce.entity.Product;
import com.ecom.ecommerce.exception.ProductNotFoundException;
import com.ecom.ecommerce.repo.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(()->new ProductNotFoundException("Product Not Found with id "+id));
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
    	if(!productRepository.existsById(id)) {
    		throw new ProductNotFoundException("Product Not Found With Id "+id);
    	}
    		
        productRepository.deleteById(id);
    }
}
