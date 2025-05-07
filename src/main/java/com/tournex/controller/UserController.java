package com.tournex.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tournex.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/status")
	public ResponseEntity<?> status() {
		return ResponseEntity.ok(Map.of("message", "User Service Running"));
	}

	@GetMapping("/allUsers")
	public ArrayList<?> getAllUser() {
		return userService.getAllUsers();
	}

	@PostMapping("/login")
	public ResponseEntity<?> getUserById(@RequestBody Map<String, Object> request) {
		ArrayList<?> result = userService.getUserById(request);
		if(result.size() > 0) {
			return ResponseEntity.ok(result.get(0));
		} else {
			return ResponseEntity.status(404).body(Map.of("message", "Check your credentials"));
		}
	}

	@PostMapping("/register")
	public ResponseEntity<?> addUser(@RequestBody Map<String, Object> request) {
		try {
			int res = userService.addUser(request);
			if (res == 2) {
				return ResponseEntity.status(400).body(Map.of("message", "User already exist"));
			} else if (res == 0) {
				return ResponseEntity.status(400).body(Map.of("message", "Error Occured while adding user"));
			} else {
				return ResponseEntity.ok(Map.of("message", "User added successfully"));
			}
		} catch (Exception e) {
			throw new RuntimeException("Exception occured while registering user; Exception : " + e.getMessage());
		}
	}

	@PutMapping
	public ResponseEntity<?> updateUser(@RequestBody Map<String, Object> request) {
		int res = userService.updateUser(request);
		if (res == 0) {
			return ResponseEntity.status(404).body(Map.of("message", "User not found"));
		} else {
			return ResponseEntity.ok(Map.of("message", "User updated successfully"));
		}
	}

	@DeleteMapping
	public ResponseEntity<?> deleteUser(@RequestBody Map<String, Object> request) {
		int res = userService.deleteUser(request);
		if (res == 0) {
			return ResponseEntity.status(404).body(Map.of("message", "User not found"));
		} else {
			return ResponseEntity.ok(Map.of("message", "User deleted successfully"));
		}
	}

}
