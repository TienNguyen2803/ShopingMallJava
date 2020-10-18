package com.jshop.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jshop.dao.ProductDAO;
import com.jshop.model.Product;

@Transactional
@Service
public class ProductService {
	@Autowired
	ProductDAO dao;
	
	public void insert(Product entity) {
		dao.insert(entity);
	}
	public void update(Product entity) {
		dao.update(entity);
	}
	public void delete(Product entity) {
		dao.delete(entity);
	}
	public void refresh(Product entity) {
		dao.refresh(entity);
	}
	public List<Product> list() {
		return dao.list();
	}
	public Product get(Integer id) {
		Product p = dao.get(id);
		Hibernate.initialize(p.getCategory().getProducts());
		Hibernate.initialize(p.getSupplier().getProducts());
		return p;
	}
	public List<Product> listByCategory(Integer id) {
		return dao.listByCategory(id);
	}
	public List<Product> listBySupplier(String id) {
		return dao.listBySupplier(id);
	}
	public List<Product> listBySpecial(String id) {
		return dao.listBySpecial(id);
	}
	public List<Product> search(String keywords) {
		return dao.search(keywords);
	}
	public List<Product> getViewProducts(String ids) {
		return dao.getViewProducts(ids);
	}
	public List<Product> getPage(int pageNo, int pageSize) {
		return dao.getPage(pageNo, pageSize);
	}
}
