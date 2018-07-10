package pl.springmvcdemo.service;

import pl.springmvcdemo.entity.Customer;

public interface CustomerService {
	public Customer getCustomer(int customerId);

	public void addCustomer(String firstName, String lastName, String email);
}
