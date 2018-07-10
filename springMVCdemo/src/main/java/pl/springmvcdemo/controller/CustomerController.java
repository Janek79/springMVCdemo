package pl.springmvcdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.springmvcdemo.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/list")
	public String showList(Model model) {
		model.addAttribute("customersList", customerService.getWholeCustomersList());
		return "list";
	}
}
