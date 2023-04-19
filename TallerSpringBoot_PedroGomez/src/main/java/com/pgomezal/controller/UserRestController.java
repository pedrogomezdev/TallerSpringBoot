package com.pgomezal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgomezal.entities.User;
import com.pgomezal.service.UserServiceImpl;

@RestController
@RequestMapping(value="/api/v1/")
public class UserRestController {

	@Autowired
	UserServiceImpl userServiceImpl;
	
	// No devuelve nada
	@GetMapping(value = "users")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> lista = new ArrayList<User>();
		lista = userServiceImpl.getAllUsers();
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	// No devuelve nada.
	@GetMapping(value="users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> findUserById(@PathVariable("id") Long id){
		User user = userServiceImpl.findById(id);
		
		if(user!=null) {
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}else {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
	
}
