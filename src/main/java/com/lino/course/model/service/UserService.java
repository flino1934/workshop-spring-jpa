package com.lino.course.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lino.course.model.entities.User;
import com.lino.course.model.repositories.UserRepository;
import com.lino.course.model.service.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {

		return userRepository.findAll();

	}

	public User findById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User obj) {

		return userRepository.save(obj);

	}

	public void delete(Long id) {

		userRepository.deleteById(id);

	}

	public User update(Long id, User obj) {

		User entity = userRepository.getReferenceById(id);
		updateData(entity, obj);
		return userRepository.save(entity);

	}

	private void updateData(User entity, User obj) {
		// TODO Auto-generated method stub
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());

	}

}
