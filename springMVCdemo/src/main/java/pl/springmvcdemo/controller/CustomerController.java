package pl.springmvcdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.springmvcdemo.entity.Customer;
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

	@RequestMapping("/form")
	public String showForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "form";
	}

	@RequestMapping("/process")
	public String processForm(@ModelAttribute Customer customer) {
		customerService.addCustomer(customer);
		return "redirect:/list";
	}

	@RequestMapping("/delete")
	public String deleteCustomer(@RequestParam(name = "customerId") int customerId) {
		customerService.deleteCustomer(customerId);
		return "redirect:/list";
	}

	@RequestMapping("/update")
	public String deleteCustomer(@RequestParam(name = "customerId") int customerId, Model model) {
		Customer customer = customerService.getCustomer(customerId);
		model.addAttribute("customer", customer);
		return "form";
	}

	@RequestMapping("/search")
	public String searchCustomer(@RequestParam(name = "searchedCustomer") String searchedCustomer, Model model) {
		if (!searchedCustomer.isEmpty()) {
			model.addAttribute("customersList", customerService.getSearchedCustomers(searchedCustomer));
			return "list";
		} else {
			return "redirect:/list";
		}

	}
}
