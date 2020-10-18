package com.jshop.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jshop.model.Product;

@Repository
public class ProductDAO {
	@Autowired
	SessionFactory factory;
	/**
	 * Them vao CSDL
	 * @param entity thuc the can them vao
	 */
	public void insert(Product entity) {
		factory.getCurrentSession().save(entity);
	}
	/**
	 * Cap nhat CSDL
	 * @param entity thuc the can can cap nhat
	 */
	public void update(Product entity) {
		factory.getCurrentSession().update(entity);
	}
	/**
	 * Xoa thu the khoi CSDL
	 * @param entity thuc the can can xoa
	 */
	public void delete(Product entity) {
		factory.getCurrentSession().delete(entity);
	}
	/**
	 * Tai lai thong tin vao thuc the CSDL
	 * @param entity thuc the chua ma can tai
	 */
	public void refresh(Product entity) {
		factory.getCurrentSession().refresh(entity);
	}
	/**
	 * Truy van tat ca cac thuc the
	 * @return danh sach thuc the truy van duoc
	 */
	@SuppressWarnings("unchecked")
	public List<Product> list() {
		String hql = "FROM Product";
		Query query= factory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	/**
	 * Truy van mot thuc the
	 * @param id la ma thuc the can truy van
	 * @return thuc the truy van duoc
	 */
	public Product get(Integer id) {
		return (Product) factory.getCurrentSession().get(Product.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> listByCategory(Integer id) {
		String hql = "FROM Product WHERE category.id=:cid";
		Query query= factory.getCurrentSession().createQuery(hql);
		query.setParameter("cid", id);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> listBySupplier(String id) {
		String hql = "FROM Product WHERE supplier.id=:sid";
		Query query= factory.getCurrentSession().createQuery(hql);
		query.setParameter("sid", id);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> listBySpecial(String id) {
		Query query = null;
		String hql = "FROM Product";
		switch (id) {
		case "best":
			hql = "FROM Product ORDER BY SIZE(orderDetails) DESC";
			query= factory.getCurrentSession().createQuery(hql);
			query.setMaxResults(12);
			break;
		case "late":
			hql = "FROM Product WHERE latest=true";
			query= factory.getCurrentSession().createQuery(hql);
			break;
		case "disc":
			hql = "FROM Product WHERE discount > 0 ORDER BY discount DESC";
			query= factory.getCurrentSession().createQuery(hql);
			query.setMaxResults(12);
			break;
		case "spec":
			hql = "FROM Product WHERE special=true";
			query= factory.getCurrentSession().createQuery(hql);
			break;
		case "favo":
			hql = "FROM Product WHERE viewCount > 0 ORDER BY viewCount DESC";
			query= factory.getCurrentSession().createQuery(hql);
			query.setMaxResults(12);
			break;
		default:
			query= factory.getCurrentSession().createQuery(hql);
			break;
		}
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> search(String keywords) {
		String hql = "FROM Product WHERE concat(name, category.name, "
				+ "category.nameVN, supplier.companyName) LIKE :kw";
		Query query= factory.getCurrentSession().createQuery(hql);
		query.setParameter("kw", "%"+keywords+"%");
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> getViewProducts(String ids) {
		String hql = "FROM Product WHERE id IN ("+ids+")";
		Query query= factory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	@SuppressWarnings("unchecked")
	public List<Product> getPage(int pageNo, int pageSize) {
		String hql = "FROM Product";
		Query query= factory.getCurrentSession().createQuery(hql);
		query.setFirstResult(pageNo * pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}
}
