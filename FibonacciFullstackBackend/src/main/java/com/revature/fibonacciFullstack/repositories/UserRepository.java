package com.revature.fibonacciFullstack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.fibonacciFullstack.models.Users;


public interface UserRepository extends JpaRepository<Users, Long>{
	
	@Query( value= "select * from users_table where username = :username and password = :password", nativeQuery=true)
	public Users login(@Param(value="username") String username, @Param(value="password") String password);

}
