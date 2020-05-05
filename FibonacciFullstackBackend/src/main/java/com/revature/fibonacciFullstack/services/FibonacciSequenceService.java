package com.revature.fibonacciFullstack.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.revature.fibonacciFullstack.models.FibonacciNumber;

@Service
public class FibonacciSequenceService {
	
	public int fibonacci(int n) {


      
       ArrayList<Integer> fibonacci = new ArrayList<Integer>();
        fibonacci.add(0);
        fibonacci.add(1);

        int i =0;
        int j =1;
        while(fibonacci.size() < 31) {
          
        fibonacci.add(fibonacci.get(i) + fibonacci.get(j));
        i++;
        j++;
           
        }
        
     
        

       return fibonacci.get(n);
      

        
    }

}
