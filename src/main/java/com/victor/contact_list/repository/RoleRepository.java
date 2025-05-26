package com.victor.contact_list.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victor.contact_list.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
}
