package com.lino.course.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lino.course.model.entities.User;
import com.lino.course.model.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {

		return userRepository.findAll();

	}

	public User finfById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.get();
	}

}
