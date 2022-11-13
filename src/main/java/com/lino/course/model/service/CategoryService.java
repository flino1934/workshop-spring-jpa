package com.lino.course.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lino.course.model.entities.Category;
import com.lino.course.model.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> findAll() {

		return categoryRepository.findAll();

	}

	public Category findById(Long id) {

		Optional<Category> obj = categoryRepository.findById(id);

		return obj.get();

	}

}
