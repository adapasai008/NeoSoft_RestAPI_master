package com.neosoft.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	Optional<UserEntity> findByFirstName(String firstName);
	

	

}
