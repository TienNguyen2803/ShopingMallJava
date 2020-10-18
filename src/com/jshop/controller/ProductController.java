package com.jshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jshop.model.Product;
import com.jshop.service.ProductService;

@Controller
@RequestMapping("product")
public class ProductController extends JShopController{
	@Autowired
	ProductService productService;
	
	@RequestMapping("list-by-category/{id}")
	public String listByCategory(Model model, @PathVariable("id") Integer id) {
		session.setAttribute("backUrl", "product/list-by-category/"+id+".php");
		model.addAttribute("items", productService.listByCategory(id));
		return user("product/list.jsp");
	}
	
	@RequestMapping("list-by-supplier/{id}")
	public String listBySupplier(Model model, @PathVariable("id") String id) {
		session.setAttribute("backUrl", "product/list-by-supplier/"+id+".php");
		model.addAttribute("items", productService.listBySupplier(id));
		return user("product/list.jsp");
	}
	
	@RequestMapping("list-by-special/{id}")
	public String listBySpecial(Model model, @PathVariable("id") String id) {
		session.setAttribute("backUrl", "product/list-by-special/"+id+".php");
		model.addAttribute("items", productService.listBySpecial(id));
		return user("product/list.jsp");
	}
	
	@RequestMapping("search")
	public String search(Model model, @RequestParam("keywords") String keywords) {
		session.setAttribute("backUrl", "product/search.php?keywords="+keywords);
		model.addAttribute("items", productService.search(keywords));
		return user("product/list.jsp");
	}
	
	@RequestMapping("detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		// Đọc Product từ CSDL
		Product p = productService.get(id);
		
		// Tăng số lượt xem
		p.setViewCount(p.getViewCount() + 1);
		productService.update(p);
		
		// Ghi nhận hàng đã xem
		String value = getCookieValue("views", "-1");
		if(value.indexOf(id.toString()) < 0) {
			value += "~" + id.toString();
			addCookie("views", value, 30);
		}
		model.addAttribute("views", productService.getViewProducts(value.replace("~", ",")));
		
		model.addAttribute("model", p);
		return user("product/detail.jsp");
	}
}
