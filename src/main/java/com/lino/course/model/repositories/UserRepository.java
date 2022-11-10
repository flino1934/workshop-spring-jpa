package com.lino.course.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lino.course.model.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
