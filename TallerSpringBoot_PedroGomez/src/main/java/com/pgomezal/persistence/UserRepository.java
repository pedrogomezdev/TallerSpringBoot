package com.pgomezal.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pgomezal.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	List<User> findAll();
	
	public User findUserById(Long id);
	
	public User findUserByName(String name);
	
	public User deleteUserById(Long id);
	

	
}
