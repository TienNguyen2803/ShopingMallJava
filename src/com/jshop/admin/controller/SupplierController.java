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
import com.jshop.model.Supplier;
import com.jshop.service.SupplierService;

@Controller("adminSupplierController")
@RequestMapping("admin/supplier")
public class SupplierController extends JShopController{
	@Autowired
	SupplierService supplierService;
	
	@RequestMapping("index")
	public String index(Model model) {
		model.addAttribute("model", new Supplier());
		model.addAttribute("items", getItems());
		return admin("supplier/index.jsp");
	}
	
	@RequestMapping("insert")
	public String insert(Model model,  
			@ModelAttribute("model") Supplier entity,
			@RequestParam("uplogo") MultipartFile uplogo) {
		try {
			if(uplogo.isEmpty()) {
				entity.setLogo("supplier.png");
			}
			else {
				entity.setLogo(System.currentTimeMillis() + "-" + uplogo.getOriginalFilename());
				String path = application.getRealPath("/images/suppliers/" + entity.getLogo());
				uplogo.transferTo(new File(path));
			}
			
			supplierService.insert(entity);
			model.addAttribute("message", "Thêm mới thành công!");
			return "redirect:/admin/supplier/index.php";
		} 
		catch (Exception e) {
			model.addAttribute("message", "Thêm mới thất bại!");
		}
		
		model.addAttribute("items", getItems());
		return admin("supplier/index.jsp");
	}
	
	@RequestMapping("update")
	public String update(Model model,  
			@ModelAttribute("model") Supplier entity,
			@RequestParam("uplogo") MultipartFile uplogo) {
		try {
			if(!uplogo.isEmpty()) {
				if(!entity.getLogo().equals("supplier.png")) {
					String path = application.getRealPath("/images/suppliers/" + entity.getLogo());
					new File(path).delete();
				}
				entity.setLogo(System.currentTimeMillis() + "-" + uplogo.getOriginalFilename());
				String path = application.getRealPath("/images/suppliers/" + entity.getLogo());
				uplogo.transferTo(new File(path));
			}
			
			supplierService.update(entity);
			model.addAttribute("message", "Cập nhật thành công!");
			return "redirect:/admin/supplier/edit.php?id="+entity.getId();
		} 
		catch (Exception e) {
			model.addAttribute("message", "Cập nhật thất bại!");
		}
		model.addAttribute("items", getItems());
		return admin("supplier/index.jsp");
	}
	
	@RequestMapping("delete")
	public String delete(Model model,  @ModelAttribute("model") Supplier entity) {
		try {
			if(!entity.getLogo().equals("supplier.png")) {
				String path = application.getRealPath("/images/suppliers/" + entity.getLogo());
				new File(path).delete();
			}
			supplierService.delete(entity);
			model.addAttribute("message", "Xóa thành công!");
			return "redirect:/admin/supplier/index.php";
		} 
		catch (Exception e) {
			model.addAttribute("message", "Xóa thất bại!");
		}
		model.addAttribute("items", getItems());
		return admin("supplier/index.jsp");
	}
	
	@RequestMapping("edit")
	public String edit(Model model,  @ModelAttribute("model") Supplier entity) {
		supplierService.refresh(entity);
		model.addAttribute("items", getItems());
		return admin("supplier/index.jsp");
	}
	
	public List<Supplier> getItems(){
		return supplierService.list();
	}
}
