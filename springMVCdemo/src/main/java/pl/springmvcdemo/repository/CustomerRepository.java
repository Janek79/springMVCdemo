package pl.springmvcdemo.repository;

import java.util.List;

import pl.springmvcdemo.entity.Customer;

public interface CustomerRepository {
	public Customer getCustomer(int customerId);

	public List<Customer> getWholeCustomersList();
	public List<Customer> getSearchedCustomers(String searchedCustomer);
	
	public void addCustomer(String firstName, String lastName, String email);
	public void addCustomer(Customer customer);
	
	public void deleteCustomer(int customerId);
}