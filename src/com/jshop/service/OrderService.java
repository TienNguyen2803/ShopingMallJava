package com.jshop.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jshop.dao.OrderDAO;
import com.jshop.dao.OrderDetailDAO;
import com.jshop.dao.ProductDAO;
import com.jshop.helper.CartItem;
import com.jshop.helper.CartService;
import com.jshop.model.Order;
import com.jshop.model.OrderDetail;
import com.jshop.model.Product;

@Transactional
@Service
public class OrderService {
	@Autowired
	OrderDAO dao;
	
	@Autowired
	CartService cartService;
	
	@Autowired
	OrderDetailService orderDetailService;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	OrderDetailDAO orderDetailDAO;
	
	public void insert(Order entity) {
		dao.insert(entity);
	}
	public void update(Order entity) {
		dao.update(entity);
	}
	public void delete(Order entity) {
		dao.delete(entity);
	}
	public void refresh(Order entity) {
		dao.refresh(entity);
	}
	public List<Order> list() {
		return dao.list();
	}
	public Order get(Integer id) {
		Order order = dao.get(id);
		Hibernate.initialize(order.getOrderDetails());
		return order;
	}
	
	public void purchase(Order order) {
		dao.insert(order);
		
		for(CartItem item : cartService.getItems()) {
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setDiscount(item.getDiscount());
			orderDetail.setOrder(order);
			orderDetail.setProduct(productDAO.get(item.getId()));
			orderDetail.setQuantity(item.getQuantity());
			orderDetail.setUnitPrice(item.getUnitPrice());
			
			orderDetailService.insert(orderDetail);
		}
	}
	public List<Order> listByUser(String id) {
		return dao.listByUser(id);
	}
	public List<Product> getPurchasedItemsofUser(String id) {
		return orderDetailDAO.getPurchasedItemsofUser(id);
	}
}
