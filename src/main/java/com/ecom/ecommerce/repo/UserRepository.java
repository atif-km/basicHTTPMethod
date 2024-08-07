package com.ecom.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.ecommerce.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
