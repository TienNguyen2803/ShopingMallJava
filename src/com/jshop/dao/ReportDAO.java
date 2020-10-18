package com.jshop.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReportDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Object[]> inventoryByCategory() {
		String hql = "SELECT p.category.nameVN,"
				+ " SUM(p.unitsInStock),"
				+ " SUM(p.unitsInStock * p.unitPrice * (1-p.discount)),"
				+ " MIN(p.unitPrice),"
				+ " MAX(p.unitPrice),"
				+ " AVG(p.unitPrice)"
				+ " FROM Product p"
				+ " GROUP BY p.category.nameVN";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> inventoryBySupplier() {
		String hql = "SELECT p.supplier.companyName,"
				+ " SUM(p.unitsInStock),"
				+ " SUM(p.unitsInStock * p.unitPrice * (1-p.discount)),"
				+ " MIN(p.unitPrice),"
				+ " MAX(p.unitPrice),"
				+ " AVG(p.unitPrice)"
				+ " FROM Product p"
				+ " GROUP BY p.supplier.companyName";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> revenueByCategory() {
		String hql = "SELECT d.product.category.nameVN,"
				+ " SUM(d.quantity),"
				+ " SUM(d.quantity * d.unitPrice * (1-d.discount)),"
				+ " MIN(d.unitPrice),"
				+ " MAX(d.unitPrice),"
				+ " AVG(d.unitPrice)"
				+ " FROM OrderDetail d"
				+ " GROUP BY d.product.category.nameVN";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> revenueBySupplier() {
		String hql = "SELECT d.product.supplier.companyName,"
				+ " SUM(d.quantity),"
				+ " SUM(d.quantity * d.unitPrice * (1-d.discount)),"
				+ " MIN(d.unitPrice),"
				+ " MAX(d.unitPrice),"
				+ " AVG(d.unitPrice)"
				+ " FROM OrderDetail d"
				+ " GROUP BY d.product.supplier.companyName";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> revenueByProduct() {
		String hql = "SELECT d.product.name,"
				+ " SUM(d.quantity),"
				+ " SUM(d.quantity * d.unitPrice * (1-d.discount)),"
				+ " MIN(d.unitPrice),"
				+ " MAX(d.unitPrice),"
				+ " AVG(d.unitPrice)"
				+ " FROM OrderDetail d"
				+ " GROUP BY d.product.name";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> revenueByCustomer() {
		String hql = "SELECT d.order.customer.id,"
				+ " SUM(d.quantity),"
				+ " SUM(d.quantity * d.unitPrice * (1-d.discount)),"
				+ " MIN(d.unitPrice),"
				+ " MAX(d.unitPrice),"
				+ " AVG(d.unitPrice)"
				+ " FROM OrderDetail d"
				+ " GROUP BY d.order.customer.id"
				+ " ORDER BY SUM(d.quantity * d.unitPrice * (1-d.discount)) DESC";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> revenueByYear() {
		String hql = "SELECT YEAR(d.order.orderDate),"
				+ " SUM(d.quantity),"
				+ " SUM(d.quantity * d.unitPrice * (1-d.discount)),"
				+ " MIN(d.unitPrice),"
				+ " MAX(d.unitPrice),"
				+ " AVG(d.unitPrice)"
				+ " FROM OrderDetail d"
				+ " GROUP BY YEAR(d.order.orderDate)";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> revenueByMonth() {
		String hql = "SELECT MONTH(d.order.orderDate),"
				+ " SUM(d.quantity),"
				+ " SUM(d.quantity * d.unitPrice * (1-d.discount)),"
				+ " MIN(d.unitPrice),"
				+ " MAX(d.unitPrice),"
				+ " AVG(d.unitPrice)"
				+ " FROM OrderDetail d"
				+ " GROUP BY MONTH(d.order.orderDate)"
				+ " ORDER BY MONTH(d.order.orderDate)";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> revenueByQuarter() {
		String hql = "SELECT CEILING(MONTH(d.order.orderDate)/3.0),"
				+ " SUM(d.quantity),"
				+ " SUM(d.quantity * d.unitPrice * (1-d.discount)),"
				+ " MIN(d.unitPrice),"
				+ " MAX(d.unitPrice),"
				+ " AVG(d.unitPrice)"
				+ " FROM OrderDetail d"
				+ " GROUP BY CEILING(MONTH(d.order.orderDate)/3.0)";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}
}
