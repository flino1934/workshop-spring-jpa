package com.lino.course.model.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lino.course.model.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll() {

		User u = new User(1L, "Maria", "Maria@gmail.com", "12345", "1234");
		return ResponseEntity.ok().body(u);

	}

}
