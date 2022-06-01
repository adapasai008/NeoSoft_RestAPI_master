package com.neosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.model.UserEntity;
import com.neosoft.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService service;

	@PostMapping("/addusers")
	public UserEntity addUsers(@RequestBody UserEntity users) {
		return service.saveUser(users);
	}

	@GetMapping("/users")
	public List<UserEntity> findAllUsers() {
		return service.getUsers();
	}

	@GetMapping("users/acs/{val}")
	public List<UserEntity> sortByAcs(@PathVariable String val) {
		return service.sortDob(val);
	}

	@GetMapping("/users/desc/{val}")
	public List<UserEntity> sortByDesc(@PathVariable String val) {
		return service.sortbyjoining(val);
	}

	@GetMapping("/users/{firstName}")
	public UserEntity findUsersByName(@PathVariable String firstName) {
		return service.getUsersByFirstName(firstName);
	}

	@PutMapping("/users/{userId}")
	public String updateUsers(@RequestBody UserEntity users, @PathVariable Integer userId) {
		return service.updateUsers(users, userId);

	}

	@DeleteMapping("/users/{userId}")
	public String deleteUsers(@PathVariable Integer userId) {
		return service.deleteUsers(userId);
	}

	@DeleteMapping("/user/{userId}")
	public String deleteUser(@PathVariable Integer userId) {
		return service.deleteUser(userId);
	}

}