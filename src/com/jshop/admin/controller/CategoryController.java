package com.jshop.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jshop.controller.JShopController;
import com.jshop.model.Category;
import com.jshop.service.CategoryService;

@Controller("adminCategoryController")
@RequestMapping("admin/category")
public class CategoryController extends JShopController{
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("index")
	public String index(Model model) {
		model.addAttribute("model", new Category());
		model.addAttribute("items", getItems());
		return admin("category/index.jsp");
	}
	
	@RequestMapping("insert")
	public String insert(Model model,  @ModelAttribute("model") Category entity) {
		try {
			categoryService.insert(entity);
			model.addAttribute("message", "Thêm mới thành công!");
			return "redirect:/admin/category/index.php";
		} 
		catch (Exception e) {
			model.addAttribute("message", "Thêm mới thất bại!");
		}
		
		model.addAttribute("items", getItems());
		return admin("category/index.jsp");
	}
	
	@RequestMapping("update")
	public String update(Model model,  @ModelAttribute("model") Category entity) {
		try {
			categoryService.update(entity);
			model.addAttribute("message", "Cập nhật thành công!");
			return "redirect:/admin/category/edit.php?id="+entity.getId();
		} 
		catch (Exception e) {
			model.addAttribute("message", "Cập nhật thất bại!");
		}
		model.addAttribute("items", getItems());
		return admin("category/index.jsp");
	}
	
	@RequestMapping("delete")
	public String delete(Model model,  @ModelAttribute("model") Category entity) {
		try {
			categoryService.delete(entity);
			model.addAttribute("message", "Xóa thành công!");
			return "redirect:/admin/category/index.php";
		} 
		catch (Exception e) {
			model.addAttribute("message", "Xóa thất bại!");
		}
		model.addAttribute("items", getItems());
		return admin("category/index.jsp");
	}
	
	@RequestMapping("edit")
	public String edit(Model model,  @ModelAttribute("model") Category entity) {
		categoryService.refresh(entity);
		model.addAttribute("items", getItems());
		return admin("category/index.jsp");
	}
	
	public List<Category> getItems(){
		return categoryService.list();
	}
}
