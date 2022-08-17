package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;

import com.luv2code.springboot.thymeleafdemo.entity.Cruises;

public interface CruiseService {
	public List<Cruises> findAll();

	public void save(Cruises theCruise);

	public void deleteById(int theId);

	public Cruises findById(int theId);
}
