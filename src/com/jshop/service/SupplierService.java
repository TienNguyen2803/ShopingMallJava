package com.jshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jshop.dao.SupplierDAO;
import com.jshop.model.Supplier;

@Transactional
@Service
public class SupplierService {
	@Autowired
	SupplierDAO dao;
	
	public void insert(Supplier entity) {
		dao.insert(entity);
	}
	public void update(Supplier entity) {
		dao.update(entity);
	}
	public void delete(Supplier entity) {
		dao.delete(entity);
	}
	public void refresh(Supplier entity) {
		dao.refresh(entity);
	}
	public List<Supplier> list() {
		return dao.list();
	}
	public Supplier get(String id) {
		return dao.get(id);
	}
}
