package pl.springmvcdemo.repository;

import java.util.List;

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

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
