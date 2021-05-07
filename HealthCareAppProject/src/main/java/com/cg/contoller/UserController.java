package com.cg.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dao.UserRepository;
import com.cg.entites.User;
import com.cg.service.UserService;


@RestController
@RequestMapping("/api/v1")
public class UserController {
	@Autowired
	UserService service;
	@Autowired
	UserRepository userRepository;
 
 @GetMapping("/user")
	public List<User> findUser(){
		return userRepository.findAll();
		
	}
 @PostMapping("/user")
	public ResponseEntity<User> addUser( @Validated @RequestBody User user) {
		System.out.println(user);
		User user1 = service.addUser(user);
		
		if(user1!=null) {
			System.out.println("user successfully registered");
		}
		
		System.out.println("add user method accessed");
		return null;
	}
 @DeleteMapping("/user/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable int id) {
		
		User user1 = service.removeUser(id);
		
		if(user1!=null) {
			System.out.println("User successfully removed");
			return new ResponseEntity<>(user1,HttpStatus.OK);
		}
		
		System.out.println("delete user method accessed");
		//throw new UserNotFoundException("Invalid user id");
		return null;
	}
 

}
