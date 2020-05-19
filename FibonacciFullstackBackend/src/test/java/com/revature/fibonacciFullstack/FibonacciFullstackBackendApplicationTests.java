package com.revature.fibonacciFullstack;


import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.validation.constraints.AssertTrue;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PathVariable;

import com.revature.fibonacciFullstack.models.FibonacciNumber;
import com.revature.fibonacciFullstack.services.*;

@SpringBootTest
class FibonacciFullstackBackendApplicationTests {
	
	@Autowired
	FibonacciSequenceService fibService;

	
	
	@Test
	void contextLoads() {
	}
	
	
	@Test
	void testFibonacciSequence() {
		
		int actual = fibService.fibonacci(6);
		assertEquals(8, actual);

	}
	


	
}	



