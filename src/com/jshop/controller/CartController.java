package com.jshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jshop.helper.CartService;

@Controller
@RequestMapping("cart")
public class CartController extends JShopController{
	@Autowired
	CartService cartService;
	
	@ResponseBody
	@RequestMapping("add")
	public String add(@RequestParam("id") Integer id) {
		cartService.add(id);
		return String.format("{\"count\":%d, \"amount\":%.3f}", 
					cartService.getCount(), cartService.getAmount());
	}
	
	@ResponseBody
	@RequestMapping("remove")
	public String remove(@RequestParam("id") Integer id) {
		cartService.remove(id);
		return String.format("{\"count\":%d, \"amount\":%.3f}", 
					cartService.getCount(), cartService.getAmount());
	}
	
	@ResponseBody
	@RequestMapping("update")
	public String update(
			@RequestParam("id") Integer id, 
			@RequestParam("qty") Integer qty) {
		cartService.update(id, qty);
		return String.format("{\"count\":%d, \"amount\":%.3f}", 
					cartService.getCount(), cartService.getAmount());
	}
	
	@ResponseBody
	@RequestMapping("clear")
	public String clear() {
		cartService.clear();
		return "{\"count\":0, \"amount\":0}";
	}
	
	@RequestMapping("view")
	public String view() {
		return user("cart/view.jsp");
	}
}
