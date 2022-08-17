package com.mycapstone.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycapstone.entity.Cruises;
import com.mycapstone.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query ... sort by last name
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();

		// return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save/update the customer ... finally LOL
		currentSession.saveOrUpdate(theCustomer);

	}

	@Override
	public Customer getCustomer(String theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);

		return theCustomer;
	}

	@Override
	public void deleteCustomer(String theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);

		theQuery.executeUpdate();
	}

	@Override
	public Customer validateCustomer(Customer theCustomer) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		Query theQuery = currentSession.createQuery("from Customer where id=:customerId");
		theQuery.setParameter("customerId", theCustomer.getEmail());
		List<Customer> validation = theQuery.getResultList();

		if (!validation.isEmpty()) {
			return theCustomer;
		} else {
			return null;
		}
	}

	@Override
	public void addCruiseForCustomer(int theId, String currentUser) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		Customer theCustomer = currentSession.get(Customer.class, currentUser);

		Cruises theCruise = currentSession.get(Cruises.class, theId);

		List<Cruises> takingCruise = theCustomer.getsCruises();
		takingCruise.add(theCruise);
		currentSession.saveOrUpdate(theCustomer);

	}

	@Override
	public void removeCruiseForCustomer(int theId, String currentUser) {
		System.out.println("Running remove cruise");
		// get the current hibernate session
		// theId = 5
		Session currentSession = sessionFactory.getCurrentSession();

		Customer theCustomer = currentSession.get(Customer.class, currentUser);
		// getting the customer's list of cruises, remove the specific cruise from it,
		// then update the customer
		Cruises theCruise = theCustomer.getsCruises().remove(theId);

		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public List<Cruises> getCustomerCruises(String currentUser) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		Customer theCustomer = currentSession.get(Customer.class, currentUser);

		List<Cruises> takingCruise = theCustomer.getsCruises();
		List<Cruises> realCruises = new ArrayList<>();
		for (Cruises i : takingCruise) {
			realCruises.add(i);
		}

		return realCruises;
	}

}
