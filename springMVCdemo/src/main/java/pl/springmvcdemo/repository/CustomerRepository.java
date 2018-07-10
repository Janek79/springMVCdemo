package pl.springmvcdemo.repository;

import pl.springmvcdemo.entity.Customer;

public interface CustomerRepository {
	public Customer getCustomer(int customerId);

	public void addCustomer(String firstName, String lastName, String email);
}
