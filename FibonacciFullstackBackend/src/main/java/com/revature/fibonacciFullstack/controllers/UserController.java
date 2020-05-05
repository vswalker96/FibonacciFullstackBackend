package com.revature.fibonacciFullstack.controllers;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.fibonacciFullstack.exceptions.UserNotFoundException;
import com.revature.fibonacciFullstack.models.FibonacciNumber;
import com.revature.fibonacciFullstack.models.Users;
import com.revature.fibonacciFullstack.repositories.UserRepository;
import com.revature.fibonacciFullstack.services.FibonacciSequenceService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserController {
	@Autowired
	UserRepository ur;
	@Autowired
	FibonacciSequenceService fibService;
	
	@PostMapping("/login")
	public ResponseEntity<Users> login(@RequestBody Users loginCredentials) throws UserNotFoundException {
		
		String username = loginCredentials.getUsername();
		String password = loginCredentials.getPassword();
		
		Users user = ur.login(username, password);
		
		if(user == null) 
			throw new UserNotFoundException("Please Enter a valid username/password");
		
		
		return new ResponseEntity<Users>(user, HttpStatus.ACCEPTED);	
		
	}
	

	
	@PostMapping("/users")
	public ResponseEntity<Users> createUser(@RequestBody Users newUser) {
		Users user = ur.save(newUser);
		
		return ResponseEntity.ok(user);
	}
	
	
	@PostMapping("/sequence/{n}")
	public FibonacciNumber getFibonacciSequence(@PathVariable(value = "n") Integer n) {
		
		FibonacciNumber number = new FibonacciNumber();
		number.setFibNumber(fibService.fibonacci(n));
		

		//int number = fibService.fibonacci(n);
		//System.out.println(number);
	return number;
		

		
	}

}
