package com.jshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class HomeController extends JShopController{
	@RequestMapping("index")
	public String index(Model model) {
		return user("home/index.jsp");
	}
	
	@RequestMapping("about")
	public String about(Model model) {
		return user("home/about.jsp");
	}
}
