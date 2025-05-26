package com.victor.contact_list.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victor.contact_list.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUsername(String username);
	
}
