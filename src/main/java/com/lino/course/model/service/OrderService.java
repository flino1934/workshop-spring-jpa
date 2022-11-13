package com.lino.course.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lino.course.model.entities.Order;
import com.lino.course.model.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public List<Order> findAll() {

		return orderRepository.findAll();

	}

	public Order findById(Long id) {

		Optional<Order> obj = orderRepository.findById(id);

		return obj.get();

	}

}
