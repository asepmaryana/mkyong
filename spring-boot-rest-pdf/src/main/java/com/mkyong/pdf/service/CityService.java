package com.mkyong.pdf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkyong.pdf.model.City;
import com.mkyong.pdf.repo.CityRepository;

@Service
public class CityService implements ICityService {
	
	@Autowired
    private CityRepository repository;
	
	@Override
	public List<City> findAll() {
		return repository.findAll();
	}

}
