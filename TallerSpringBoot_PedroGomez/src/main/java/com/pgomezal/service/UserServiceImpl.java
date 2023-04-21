package com.pgomezal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgomezal.entities.User;
import com.pgomezal.exceptions.UserValidationException;
import com.pgomezal.persistence.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User findById(Long id) {
		User usuario = userRepository.findUserById(id);
		return usuario;
	}

	
	// Si el usuario llega sin nombre o sin fecha, saltará una excepción de tipo UserValidationException.
	@Override
	public User save(User user) {
		if(user.getName() != null && user.getBirthDate() != null) {
			User usuario = userRepository.save(new User(user.getId(), user.getName(), user.getBirthDate()));
			return usuario;
		}else {
			throw new UserValidationException("Nombre o fecha no incluida");
		}
		
	}

	@Override
	public User delete(Long id) {
		User usuario = userRepository.findUserById(id);
		userRepository.deleteById(id);

		if (usuario != null) {
			userRepository.deleteById(id);
			return usuario;
		} else {
			return null;
		}
	}

	@Override
	public User update(User user) {
		User usuario = userRepository.findUserById(user.getId());
		if (usuario != null) {
			User updatedUser = userRepository.save(user);
			return updatedUser;
		} else {
			return null;
		}
	}

}
