package com.ankita.SportShoesProject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ankita.SportShoesProject.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT u FROM User u WHERE u.email = ?1")
	User findByEmail(String email);

	public User getUserByEmail(String email);

	
	@Query("SELECT u FROM User u WHERE u.email = ?1")
	List<User> findByEmailId(String email);

	
}
