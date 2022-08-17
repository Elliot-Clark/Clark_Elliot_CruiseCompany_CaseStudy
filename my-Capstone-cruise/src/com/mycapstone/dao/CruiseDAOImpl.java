package com.mycapstone.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycapstone.entity.Cruises;

@Repository
public class CruiseDAOImpl implements CruiseDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Cruises> getCruises() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query ... sort by last name
		Query<Cruises> theQuery = currentSession.createQuery("from Cruises", Cruises.class);

		// execute query and get result list
		List<Cruises> cruises = theQuery.getResultList();

		System.out.println(cruises);

		// return the results
		return cruises;
	}

}