package com.jshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jshop.dao.CategoryDAO;
import com.jshop.model.Category;

@Transactional
@Service
public class CategoryService {
	@Autowired
	CategoryDAO dao;
	
	public void insert(Category entity) {
		dao.insert(entity);
	}
	public void update(Category entity) {
		dao.update(entity);
	}
	public void delete(Category entity) {
		dao.delete(entity);
	}
	public void refresh(Category entity) {
		dao.refresh(entity);
	}
	public List<Category> list() {
		return dao.list();
	}
	public Category get(Integer id) {
		return dao.get(id);
	}
}
