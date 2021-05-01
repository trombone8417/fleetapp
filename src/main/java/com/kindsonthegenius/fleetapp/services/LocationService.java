package com.kindsonthegenius.fleetapp.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.Location;
import com.kindsonthegenius.fleetapp.repositories.LocationRepository;


@Service
public class LocationService {
	@Autowired
	private LocationRepository locationRepository;

/**
 * 列出所有國家
 * @return
 */
	public List<Location> getLocations() {
		return locationRepository.findAll();
	}

/**
 * 新增or更新
 * @param location
 */
	public void save(Location location) {
		locationRepository.save(location);
	}
	
	public Optional<Location> findById(int id) {
		return locationRepository.findById(id);
	}

	public void delete(Integer id) {
		locationRepository.deleteById(id);
		
	}
	
}
