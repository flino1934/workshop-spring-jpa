package com.lino.course.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lino.course.model.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
