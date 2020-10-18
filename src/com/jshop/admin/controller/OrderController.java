package com.jshop.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jshop.controller.JShopController;
import com.jshop.model.Order;
import com.jshop.model.OrderStatus;
import com.jshop.service.OrderService;
import com.jshop.service.OrderStatusService;

@Controller("adminOrderController")
@RequestMapping("admin/order")
public class OrderController extends JShopController{
	@Autowired
	OrderService orderService;
	@Autowired
	OrderStatusService orderStatusService;
	
	@RequestMapping("index")
	public String index(Model model) {
		model.addAttribute("model", new Order());
		model.addAttribute("items", getItems());
		return admin("order/index.jsp");
	}
	
	@RequestMapping("insert")
	public String insert(Model model,  
			@ModelAttribute("model") Order entity) {
		try {
			orderService.insert(entity);
			model.addAttribute("message", "Thêm mới thành công!");
			return "redirect:/admin/order/index.php";
		} 
		catch (Exception e) {
			model.addAttribute("message", "Thêm mới thất bại!");
		}
		
		model.addAttribute("items", getItems());
		return admin("order/index.jsp");
	}
	
	@RequestMapping("update")
	public String update(Model model,  
			@ModelAttribute("model") Order entity) {
		try {
			orderService.update(entity);
			model.addAttribute("message", "Cập nhật thành công!");
			return "redirect:/admin/order/edit.php?id="+entity.getId();
		} 
		catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "Cập nhật thất bại!");
		}
		model.addAttribute("items", getItems());
		return admin("order/index.jsp");
	}
	
	@RequestMapping("delete")
	public String delete(Model model,  @ModelAttribute("model") Order entity) {
		try {
			orderService.delete(entity);
			model.addAttribute("message", "Xóa thành công!");
			return "redirect:/admin/order/index.php";
		} 
		catch (Exception e) {
			model.addAttribute("message", "Xóa thất bại!");
		}
		model.addAttribute("items", getItems());
		return admin("order/index.jsp");
	}
	
	@RequestMapping("edit")
	public String edit(Model model,  @ModelAttribute("model") Order entity) {
		orderService.refresh(entity);
		model.addAttribute("items", getItems());
		return admin("order/index.jsp");
	}
	
	public List<Order> getItems(){
		return orderService.list();
	}
	
	@ModelAttribute("orderStatuses")
	public List<OrderStatus> getOrderStatues(){
		return orderStatusService.list();
	}
}