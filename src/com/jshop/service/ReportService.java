package com.jshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jshop.dao.ReportDAO;

@Transactional
@Service
public class ReportService {
	@Autowired
	ReportDAO dao;
	
	public List<Object[]> inventoryByCategory() {
		return dao.inventoryByCategory();
	}

	public List<Object[]> inventoryBySupplier() {
		return dao.inventoryBySupplier();
	}
	
	public List<Object[]> revenueByCategory() {
		return dao.revenueByCategory();
	}

	public List<Object[]> revenueBySupplier() {
		return dao.revenueBySupplier();
	}
	
	public List<Object[]> revenueByProduct() {
		return dao.revenueByProduct();
	}
	
	public List<Object[]> revenueByCustomer() {
		return dao.revenueByCustomer();
	}
	
	public List<Object[]> revenueByYear() {
		return dao.revenueByYear();
	}
	
	public List<Object[]> revenueByQuarter() {
		return dao.revenueByQuarter();
	}
	
	public List<Object[]> revenueByMonth() {
		return dao.revenueByMonth();
	}
}
