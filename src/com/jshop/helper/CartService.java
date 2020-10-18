package com.jshop.helper;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.jshop.model.Product;
import com.jshop.service.ProductService;

//scopedTarget.cartService
@Service
@SessionScope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class CartService {
	@Autowired
	ProductService productService;
	
	Map<Integer, CartItem> map = new HashMap<>();
	
	public void add(Integer id) {
		CartItem item = map.get(id);
		if(item != null) {
			item.setQuantity(item.getQuantity() + 1);
		}
		else {
			Product p = productService.get(id);
			
			item = new CartItem();
			item.setId(p.getId());
			item.setName(p.getName());
			item.setUnitPrice(p.getUnitPrice());
			item.setDiscount(p.getDiscount());
			item.setQuantity(1);
			
			map.put(id, item);
		}
	}
	
	public void remove(Integer id) {
		map.remove(id);
	}
	
	public void update(Integer id, int newQuantity) {
		CartItem item = map.get(id);
		item.setQuantity(newQuantity);
	}
	
	public void clear() {
		map.clear();
	}
	
	public Collection<CartItem> getItems() {
		return map.values();
	}
	
	public int getCount() {
		int count = 0;
		for(CartItem item : getItems()) {
			count += item.getQuantity();
		}
		return count;
	}
	
	public double getAmount() {
		double amount = 0;
		for(CartItem item : getItems()) {
			amount += item.getAmount();
		}
		return amount;
	}
}
