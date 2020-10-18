package com.jshop.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jshop.helper.Mailer;
import com.jshop.model.Customer;
import com.jshop.service.CustomerService;

@Controller
@RequestMapping("account")
public class AccountController extends JShopController {
	@Autowired
	CustomerService customerService;
	
	@Autowired
	Mailer mailer;
	
	@GetMapping("register")
	public String register(Model model) {
		model.addAttribute("user", new Customer());
		return user("account/register.jsp");
	}
	@PostMapping("register")
	public String register(Model model, 
			@ModelAttribute("user") Customer customer,
			@RequestParam("upphoto") MultipartFile photo) {
		if(photo.isEmpty()) {
			customer.setPhoto("user.png");
		}
		else {
			customer.setPhoto(System.currentTimeMillis() + "-" + photo.getOriginalFilename());
			File file = new File(application.getRealPath("/images/customers/" + customer.getPhoto()));
			try {
				photo.transferTo(file);
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		Customer user = customerService.get(customer.getId());
		if(user != null) {
			model.addAttribute("message", "Trùng mã đăng nhập!");
		}
		else {
			customer.setActivated(false);
			customer.setAdmin(false);
			customerService.insert(customer);
			
			model.addAttribute("message", "Đăng ký thành công!");
			
			String url = request.getRequestURL().toString().replace("register", "activate/"+customer.getId());
			String to = customer.getEmail();
			String subject = "Welcome mail!";
			String content = "Click the link below to activate your account<hr>"
					+ "<a href='"+url+"'>Activate</a>";
			mailer.send(to, subject, content);
		}
		return user("account/register.jsp");
	}
	
	@GetMapping("login")
	public String login() {
		return user("account/login.jsp");
	}
	@PostMapping("login")
	public String login(Model model, 
			@RequestParam("id") String id,
			@RequestParam("password") String password,
			@RequestParam(value="remember", defaultValue="false") Boolean remember) {
		Customer user = customerService.get(id);
		if(user == null) {
			model.addAttribute("message", "Sai tên đăng nhập!");
		}
		else if(user.getActivated() == false) {
			model.addAttribute("message", "Chưa kích hoạt!");
		}
		else if(!password.equals(user.getPassword())) {
			model.addAttribute("message", "Sai mật khẩu!");
		}
		else {
			session.setAttribute("user", user);
			
			model.addAttribute("message", "Đăng nhập thành công!");
			
			if(remember == true) {
				this.addCookie("uid", id, 30);
				this.addCookie("pwd", password, 30);
			}
			else {
				this.removeCookie("uid");
				this.removeCookie("pwd");
			}
			
			String requestAction = (String) session.getAttribute("requestAction");
			if(requestAction != null) {
				return "redirect:" + requestAction;
			}
		}
		return user("account/login.jsp");
	}
	
	@GetMapping("forgot")
	public String forgot() {
		return user("account/forgot.jsp");
	}
	@PostMapping("forgot")
	public String forgot(Model model, 
			@RequestParam("id") String id,
			@RequestParam("email") String email) {
		Customer user = customerService.get(id);
		if(user == null) {
			model.addAttribute("message", "Sai tên đăng nhập!");
		}
		else if(!email.equals(user.getEmail())) {
			model.addAttribute("message", "Sai email!");
		}
		else {
			mailer.send(email, "Forgot password", "Pass: " + user.getPassword());
			model.addAttribute("message", "Mật khẩu đã được gửi qua email!");
		}
		return user("account/forgot.jsp");
	}
	
	@GetMapping("change")
	public String change() {
		return user("account/change.jsp");
	}
	@PostMapping("change")
	public String change(Model model, 
			@RequestParam("id") String id,
			@RequestParam("password") String password,
			@RequestParam("newPassword") String newPassword,
			@RequestParam("confirmPassword") String confirmPassword) {
		if(!newPassword.equals(confirmPassword)) {
			model.addAttribute("message", "Xác nhận mật khẩu không đúng!");
		}
		else {
			Customer user = customerService.get(id);
			if(user == null) {
				model.addAttribute("message", "Sai tên đăng nhập!");
			}
			else if(!password.equals(user.getPassword())) {
				model.addAttribute("message", "Sai mật khẩu!");
			}
			else {
				user.setPassword(newPassword);
				customerService.update(user);
				model.addAttribute("message", "Đổi mật khẩu thành công!");
			}
		}
		
		return user("account/change.jsp");
	}
	
	@GetMapping("edit")
	public String edit(Model model) {
		Customer user = (Customer) session.getAttribute("user");
		model.addAttribute("user", user);
		return user("account/edit.jsp");
	}
	@PostMapping("edit")
	public String edit(Model model, 
			@ModelAttribute("user") Customer customer,
			@RequestParam("upphoto") MultipartFile photo) {
		
		if(!photo.isEmpty()) {
			if(!customer.getPhoto().equals("user.png")) {
				File oldfile = new File(application.getRealPath("/images/customers/" + customer.getPhoto()));
				oldfile.delete();
			}
			customer.setPhoto(System.currentTimeMillis() + "-" + photo.getOriginalFilename());
			File file = new File(application.getRealPath("/images/customers/" + customer.getPhoto()));
			try {
				photo.transferTo(file);
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		customerService.update(customer);
		model.addAttribute("message", "Cập nhật tài khoản thành công!");
		
		session.setAttribute("user", customer);
		
		return user("account/edit.jsp");
	}
	
	@GetMapping("logoff")
	public String logoff() {
		session.removeAttribute("user");
		return "redirect:/home/index.php";
	}
	
	@GetMapping("activate/{id}")
	public String activate(@PathVariable("id") String id) {
		Customer user = customerService.get(id);
		user.setActivated(true);
		customerService.update(user);
		return "redirect:/account/login.php";
	}
}
