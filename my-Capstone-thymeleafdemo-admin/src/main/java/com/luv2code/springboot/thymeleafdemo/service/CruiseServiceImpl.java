package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.thymeleafdemo.dao.CruiseRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Cruises;

@Service
public class CruiseServiceImpl implements CruiseService {

	private CruiseRepository cruiseRepository;

	@Autowired
	public CruiseServiceImpl(CruiseRepository theCruiseRepository) {
		cruiseRepository = theCruiseRepository;
	}

	@Override
	public List<Cruises> findAll() {
		return cruiseRepository.findAll();
	}

	@Override
	public void save(Cruises theCruise) {
		cruiseRepository.save(theCruise);
	}

	@Override
	public void deleteById(int theId) {
		cruiseRepository.deleteById(theId);

	}

	@Override
	public Cruises findById(int theId) {
		// Optional<Customer> result = customerRepository.findById(theId);
		Optional<Cruises> result = cruiseRepository.findById(theId);

		Cruises theCruise = null;

		if (result.isPresent()) {
			theCruise = result.get();
		} else {
			// we didn't find the customer
			throw new RuntimeException("Did not find customer id - " + theId);
		}

		return theCruise;
	}

}
