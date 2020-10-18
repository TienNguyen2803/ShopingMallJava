package com.jshop.admin.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jshop.controller.JShopController;
import com.jshop.model.Customer;
import com.jshop.service.CustomerService;

@Controller("adminCustomerController")
@RequestMapping("admin/customer")
public class CustomerController extends JShopController{
	@Autowired
	CustomerService customerService;
	
	@RequestMapping("index")
	public String index(Model model) {
		model.addAttribute("model", new Customer());
		model.addAttribute("items", getItems());
		return admin("customer/index.jsp");
	}
	
	@RequestMapping("insert")
	public String insert(Model model,  
			@ModelAttribute("model") Customer entity,
			@RequestParam("upphoto") MultipartFile upphoto) {
		try {
			if(upphoto.isEmpty()) {
				entity.setPhoto("customer.png");
			}
			else {
				entity.setPhoto(System.currentTimeMillis() + "-" + upphoto.getOriginalFilename());
				String path = application.getRealPath("/images/customers/" + entity.getPhoto());
				upphoto.transferTo(new File(path));
			}
			
			customerService.insert(entity);
			model.addAttribute("message", "Thêm mới thành công!");
			return "redirect:/admin/customer/index.php";
		} 
		catch (Exception e) {
			model.addAttribute("message", "Thêm mới thất bại!");
		}
		
		model.addAttribute("items", getItems());
		return admin("customer/index.jsp");
	}
	
	@RequestMapping("update")
	public String update(Model model,  
			@ModelAttribute("model") Customer entity,
			@RequestParam("upphoto") MultipartFile upphoto) {
		try {
			if(!upphoto.isEmpty()) {
				if(!entity.getPhoto().equals("customer.png")) {
					String path = application.getRealPath("/images/customers/" + entity.getPhoto());
					new File(path).delete();
				}
				entity.setPhoto(System.currentTimeMillis() + "-" + upphoto.getOriginalFilename());
				String path = application.getRealPath("/images/customers/" + entity.getPhoto());
				upphoto.transferTo(new File(path));
			}
			
			customerService.update(entity);
			model.addAttribute("message", "Cập nhật thành công!");
			return "redirect:/admin/customer/edit.php?id="+entity.getId();
		} 
		catch (Exception e) {
			model.addAttribute("message", "Cập nhật thất bại!");
		}
		model.addAttribute("items", getItems());
		return admin("customer/index.jsp");
	}
	
	@RequestMapping("delete")
	public String delete(Model model,  @ModelAttribute("model") Customer entity) {
		try {
			if(!entity.getPhoto().equals("customer.png")) {
				String path = application.getRealPath("/images/customers/" + entity.getPhoto());
				new File(path).delete();
			}
			customerService.delete(entity);
			model.addAttribute("message", "Xóa thành công!");
			return "redirect:/admin/customer/index.php";
		} 
		catch (Exception e) {
			model.addAttribute("message", "Xóa thất bại!");
		}
		model.addAttribute("items", getItems());
		return admin("customer/index.jsp");
	}
	
	@RequestMapping("edit")
	public String edit(Model model,  @ModelAttribute("model") Customer entity) {
		customerService.refresh(entity);
		model.addAttribute("items", getItems());
		return admin("customer/index.jsp");
	}
	
	public List<Customer> getItems(){
		return customerService.list();
	}
}
