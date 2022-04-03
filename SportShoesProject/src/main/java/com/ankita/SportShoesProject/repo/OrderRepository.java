package com.ankita.SportShoesProject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ankita.SportShoesProject.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	@Query("SELECT o FROM Order o WHERE o.date = ?1")
    List<Order> findByDate(String date);

	@Query("SELECT o FROM Order o WHERE o.ocategory = ?1")
	List<Order> findByCategory(String category);


}
