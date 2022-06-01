package com.neosoft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.neosoft.model.UserEntity;
import com.neosoft.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	public UserEntity saveUser(UserEntity userEntity) {
		return repository.save(userEntity);
	}

	public List<UserEntity> getUsers() {
		return repository.findAll();
	}
	
	public List<UserEntity> sortDob(String val) {
		return repository.findAll(Sort.by(Sort.Direction.ASC,val));
	}
	

	public List<UserEntity> sortbyjoining(String val) {
		return repository.findAll(Sort.by(Sort.Direction.DESC,val));
	}

	public UserEntity getUsersByFirstName(String firstName) {
		return repository.findByFirstName(firstName).orElse(null);
	}

	public String deleteUser(int userId) {
		return "users deleted !!" + userId;
	}

	public String deleteUsers(int userId) {
		repository.deleteById(userId);
		return "users deleted !!" + userId;
	}

	public String updateUsers(UserEntity entity, Integer userId) {
		Optional<UserEntity> users = repository.findById(userId);

		if (users.isPresent()) {
			UserEntity newEntity = users.get();
			newEntity.setEmailId(entity.getEmailId());
			newEntity.setFirstName(entity.getFirstName());
			newEntity.setLastName(entity.getLastName());
			newEntity.setDob(entity.getDob());
			newEntity.setJoinDate(entity.getJoinDate());

			newEntity = repository.save(newEntity);

			return "user upadated: " + userId;
		} else {
			return "USER NOT FOUND: " + userId;
		}

	}
}
