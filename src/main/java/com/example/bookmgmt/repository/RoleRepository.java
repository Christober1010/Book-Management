package com.example.bookmgmt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookmgmt.model.ERole;
import com.example.bookmgmt.model.Role;

public interface RoleRepository extends JpaRepository<Role,Integer> {
	//Native querry
	//SELECT * FROM roles AS i WHERE i.name = 'ROLE_USER'
	Optional <Role> findByName(ERole name);
}
