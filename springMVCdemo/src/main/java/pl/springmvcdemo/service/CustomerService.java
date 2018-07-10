package pl.springmvcdemo.service;

import java.util.List;

import pl.springmvcdemo.entity.Customer;

public interface CustomerService {
	public Customer getCustomer(int customerId);
	
	public List<Customer> getWholeCustomersList();

	public void addCustomer(String firstName, String lastName, String email);
	public void addCustomer(Customer customer);
}
