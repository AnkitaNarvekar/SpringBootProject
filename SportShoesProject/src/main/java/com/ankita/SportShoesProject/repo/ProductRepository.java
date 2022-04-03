package com.ankita.SportShoesProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ankita.SportShoesProject.entity.Order;
import com.ankita.SportShoesProject.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {
	
	
}
