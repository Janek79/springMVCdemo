package pl.springmvcdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.springmvcdemo.entity.Customer;
import pl.springmvcdemo.repository.CustomerRepository;
import pl.springmvcdemo.repository.CustomerRepositoryImpl;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerDAO;
	
	@Override
	public Customer getCustomer(int customerId) {
		return customerDAO.getCustomer(customerId);
	}

	@Override
	public void addCustomer(String firstName, String lastName, String email) {
		customerDAO.addCustomer(firstName, lastName, email);
	}

	public CustomerRepository getCustomerDAO() {
		return customerDAO;
	}

	public void setCustomerDAO(CustomerRepositoryImpl customerDAO) {
		this.customerDAO = customerDAO;
	}
	
}
