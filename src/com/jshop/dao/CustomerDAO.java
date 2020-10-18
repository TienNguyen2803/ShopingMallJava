package com.jshop.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jshop.model.Customer;

@Repository
public class CustomerDAO {
	@Autowired
	SessionFactory factory;
	/**
	 * Them vao CSDL
	 * @param entity thuc the can them vao
	 */
	public void insert(Customer entity) {
		factory.getCurrentSession().save(entity);
	}
	/**
	 * Cap nhat CSDL
	 * @param entity thuc the can can cap nhat
	 */
	public void update(Customer entity) {
		factory.getCurrentSession().update(entity);
	}
	/**
	 * Xoa thu the khoi CSDL
	 * @param entity thuc the can can xoa
	 */
	public void delete(Customer entity) {
		factory.getCurrentSession().delete(entity);
	}
	/**
	 * Tai lai thong tin vao thuc the CSDL
	 * @param entity thuc the chua ma can tai
	 */
	public void refresh(Customer entity) {
		factory.getCurrentSession().refresh(entity);
	}
	/**
	 * Truy van tat ca cac thuc the
	 * @return danh sach thuc the truy van duoc
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> list() {
		String hql = "FROM Customer";
		Query query= factory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	/**
	 * Truy van mot thuc the
	 * @param id la ma thuc the can truy van
	 * @return thuc the truy van duoc
	 */
	public Customer get(String id) {
		return (Customer) factory.getCurrentSession().get(Customer.class, id);
	}
}
