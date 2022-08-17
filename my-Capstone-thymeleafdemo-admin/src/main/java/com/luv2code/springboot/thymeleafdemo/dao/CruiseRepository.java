package com.luv2code.springboot.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Cruises;

public interface CruiseRepository extends JpaRepository<Cruises, Integer> {

	// that's it ... no need to write any code LOL!

	// add a method to sort by last name
//	@Override
//	public List<Cruises> findAllByOrderByLastNameAsc();
}