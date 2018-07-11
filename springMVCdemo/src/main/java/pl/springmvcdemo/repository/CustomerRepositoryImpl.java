package pl.springmvcdemo.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.springmvcdemo.entity.Customer;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Customer getCustomer(int customerId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer.class, customerId);
	}

	@Override
	public void addCustomer(String firstName, String lastName, String email) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = new Customer(firstName, lastName, email);
		session.save(customer);
	}

	@Override
	public void addCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.save(customer);
	}

	@Override
	public List<Customer> getWholeCustomersList() {
		Session session = sessionFactory.getCurrentSession();

		return session.createQuery("FROM Customer", Customer.class).getResultList();
	}

	@Override
	public void deleteCustomer(int customerId) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, customerId);
		session.delete(customer);
	}

	@Override
	public List<Customer> getSearchedCustomers(String searchedCustomer) {
		Session session = sessionFactory.getCurrentSession();

		List<Customer> list = new ArrayList<>();

		list.addAll(session
				.createQuery("FROM Customer c WHERE c.firstName like '%" + searchedCustomer + "%'", Customer.class)
				.getResultList());
		
		list.addAll(session
				.createQuery("FROM Customer c WHERE c.lastName like '%" + searchedCustomer + "%'", Customer.class)
				.getResultList());
		
		list.addAll(session
				.createQuery("FROM Customer c WHERE c.email like '%" + searchedCustomer + "%'", Customer.class)
				.getResultList());
		
		if(searchedCustomer.split(" ").length > 1) {
			list.addAll(session
					.createQuery("FROM Customer c WHERE c.firstName like '%" + searchedCustomer.split(" ")[0] + "%'", Customer.class)
					.getResultList());
			
			list.addAll(session
					.createQuery("FROM Customer c WHERE c.firstName like '%" + searchedCustomer.split(" ")[1] + "%'", Customer.class)
					.getResultList());
			
			list.addAll(session
					.createQuery("FROM Customer c WHERE c.lastName like '%" + searchedCustomer.split(" ")[0] + "%'", Customer.class)
					.getResultList());
			
			list.addAll(session
					.createQuery("FROM Customer c WHERE c.lastName like '%" + searchedCustomer.split(" ")[1] + "%'", Customer.class)
					.getResultList());
		}

		list = new ArrayList<>(new HashSet<>(list));
		
		return list;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
