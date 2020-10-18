package com.jshop.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jshop.model.Supplier;

@Repository
public class SupplierDAO {
	@Autowired
	SessionFactory factory;
	/**
	 * Them vao CSDL
	 * @param entity thuc the can them vao
	 */
	public void insert(Supplier entity) {
		factory.getCurrentSession().save(entity);
	}
	/**
	 * Cap nhat CSDL
	 * @param entity thuc the can can cap nhat
	 */
	public void update(Supplier entity) {
		factory.getCurrentSession().update(entity);
	}
	/**
	 * Xoa thu the khoi CSDL
	 * @param entity thuc the can can xoa
	 */
	public void delete(Supplier entity) {
		factory.getCurrentSession().delete(entity);
	}
	/**
	 * Tai lai thong tin vao thuc the CSDL
	 * @param entity thuc the chua ma can tai
	 */
	public void refresh(Supplier entity) {
		factory.getCurrentSession().refresh(entity);
	}
	/**
	 * Truy van tat ca cac thuc the
	 * @return danh sach thuc the truy van duoc
	 */
	@SuppressWarnings("unchecked")
	public List<Supplier> list() {
		String hql = "FROM Supplier";
		Query query= factory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	/**
	 * Truy van mot thuc the
	 * @param id la ma thuc the can truy van
	 * @return thuc the truy van duoc
	 */
	public Supplier get(String id) {
		return (Supplier) factory.getCurrentSession().get(Supplier.class, id);
	}
}
