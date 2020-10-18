package com.jshop.admin.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jshop.controller.JShopController;
import com.jshop.model.Product;
import com.jshop.service.ProductService;

@Controller("adminProductController")
@RequestMapping("admin/product")
public class ProductController extends JShopController{
	@Autowired
	ProductService productService;
	
	@RequestMapping("index")
	public String index(Model model) {
		model.addAttribute("model", new Product());
		model.addAttribute("items", getItems());
		return admin("product/index.jsp");
	}
	
	@RequestMapping("insert")
	public String insert(Model model,  
			@ModelAttribute("model") Product entity,
			@RequestParam("upimage") MultipartFile upimage) {
		try {
			if(upimage.isEmpty()) {
				entity.setImage("product.png");
			}
			else {
				entity.setImage(System.currentTimeMillis() + "-" + upimage.getOriginalFilename());
				String path = application.getRealPath("/images/products/" + entity.getImage());
				upimage.transferTo(new File(path));
			}
			
			productService.insert(entity);
			model.addAttribute("message", "Thêm mới thành công!");
			return "redirect:/admin/product/index.php";
		} 
		catch (Exception e) {
			model.addAttribute("message", "Thêm mới thất bại!");
		}
		
		model.addAttribute("items", getItems());
		return admin("product/index.jsp");
	}
	
	@RequestMapping("update")
	public String update(Model model,  
			@ModelAttribute("model") Product entity,
			@RequestParam("upimage") MultipartFile upimage) {
		try {
			if(!upimage.isEmpty()) {
				if(!entity.getImage().equals("product.png")) {
					String path = application.getRealPath("/images/products/" + entity.getImage());
					new File(path).delete();
				}
				entity.setImage(System.currentTimeMillis() + "-" + upimage.getOriginalFilename());
				String path = application.getRealPath("/images/products/" + entity.getImage());
				upimage.transferTo(new File(path));
			}
			
			productService.update(entity);
			model.addAttribute("message", "Cập nhật thành công!");
			return "redirect:/admin/product/edit.php?id="+entity.getId();
		} 
		catch (Exception e) {
			model.addAttribute("message", "Cập nhật thất bại!");
		}
		model.addAttribute("items", getItems());
		return admin("product/index.jsp");
	}
	
	@RequestMapping("delete")
	public String delete(Model model,  @ModelAttribute("model") Product entity) {
		try {
			if(!entity.getImage().equals("product.png")) {
				String path = application.getRealPath("/images/products/" + entity.getImage());
				new File(path).delete();
			}
			productService.delete(entity);
			model.addAttribute("message", "Xóa thành công!");
			return "redirect:/admin/product/index.php";
		} 
		catch (Exception e) {
			model.addAttribute("message", "Xóa thất bại!");
		}
		model.addAttribute("items", getItems());
		return admin("product/index.jsp");
	}
	
	@RequestMapping("edit")
	public String edit(Model model,  @ModelAttribute("model") Product entity) {
		productService.refresh(entity);
		model.addAttribute("items", getItems());
		return admin("product/index.jsp");
	}
	
	public List<Product> getItems(){
		return productService.list();
	}
	
	@RequestMapping("get-page")
	public String getPage(Model model,  
			@RequestParam(value="pageNo", defaultValue="0") int pageNo,
			@RequestParam(value="pageSize", defaultValue="10") int pageSize) {
		List<Product> list = productService.getPage(pageNo, pageSize);
		model.addAttribute("items", list);
		return "admin/product/list";
	}
	
	@ResponseBody
	@RequestMapping("get-page-count")
	public String getPageCount(Model model,  
			@RequestParam(value="pageSize", defaultValue="10") int pageSize) {
		
		int rowCount = productService.list().size();
		int pageCount = (int) Math.ceil(1.0*rowCount/pageSize);
		return String.valueOf(pageCount);
	}
}
