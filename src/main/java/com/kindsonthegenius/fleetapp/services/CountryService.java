package com.kindsonthegenius.fleetapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.repositories.CountryRepository;
import com.kindsonthegenius.fleetapp.models.Country;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;

	public List<Country> getCountries() {
		return countryRepository.findAll();
	}

	public void save(Country country) {
		countryRepository.save(country);
	}
}
