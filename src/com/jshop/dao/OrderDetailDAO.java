package com.jshop.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jshop.model.OrderDetail;
import com.jshop.model.Product;

@Repository
public class OrderDetailDAO {
	@Autowired
	SessionFactory factory;
	/**
	 * Them vao CSDL
	 * @param entity thuc the can them vao
	 */
	public void insert(OrderDetail entity) {
		factory.getCurrentSession().save(entity);
	}
	/**
	 * Cap nhat CSDL
	 * @param entity thuc the can can cap nhat
	 */
	public void update(OrderDetail entity) {
		factory.getCurrentSession().update(entity);
	}
	/**
	 * Xoa thu the khoi CSDL
	 * @param entity thuc the can can xoa
	 */
	public void delete(OrderDetail entity) {
		factory.getCurrentSession().delete(entity);
	}
	/**
	 * Tai lai thong tin vao thuc the CSDL
	 * @param entity thuc the chua ma can tai
	 */
	public void refresh(OrderDetail entity) {
		factory.getCurrentSession().refresh(entity);
	}
	/**
	 * Truy van tat ca cac thuc the
	 * @return danh sach thuc the truy van duoc
	 */
	@SuppressWarnings("unchecked")
	public List<OrderDetail> list() {
		String hql = "FROM OrderDetail";
		Query query= factory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	/**
	 * Truy van mot thuc the
	 * @param id la ma thuc the can truy van
	 * @return thuc the truy van duoc
	 */
	public OrderDetail get(Integer id) {
		return (OrderDetail) factory.getCurrentSession().get(OrderDetail.class, id);
	}
	@SuppressWarnings("unchecked")
	public List<Product> getPurchasedItemsofUser(String id) {
		String hql = "SELECT DISTINCT d.product FROM OrderDetail d "
				+ " WHERE d.order.customer.id=:cid";
		Query query= factory.getCurrentSession().createQuery(hql);
		query.setParameter("cid", id);
		return query.list();
	}
}
