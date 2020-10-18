package com.jshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jshop.dao.OrderStatusDAO;
import com.jshop.model.OrderStatus;

@Transactional
@Service
public class OrderStatusService {
	@Autowired
	OrderStatusDAO dao;
	
	public void insert(OrderStatus entity) {
		dao.insert(entity);
	}
	public void update(OrderStatus entity) {
		dao.update(entity);
	}
	public void delete(OrderStatus entity) {
		dao.delete(entity);
	}
	public void refresh(OrderStatus entity) {
		dao.refresh(entity);
	}
	public List<OrderStatus> list() {
		return dao.list();
	}
	public OrderStatus get(Integer id) {
		return dao.get(id);
	}
}
