package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.VehicleMake;
import com.kindsonthegenius.fleetapp.repositories.VehicleMakeRepository;

@Service
public class VehicleMakeService {
	@Autowired
	private VehicleMakeRepository vehicleMakeRepository;

/**
 * 列出所有
 * @return
 */
	public List<VehicleMake> getVehicleMakes() {
		return vehicleMakeRepository.findAll();
	}

/**
 * 新增or更新
 * @param vehicleMake
 */
	public void save(VehicleMake vehicleMake) {
		vehicleMakeRepository.save(vehicleMake);
	}
	
	public Optional<VehicleMake> findById(int id) {
		return vehicleMakeRepository.findById(id);
	}

	public void delete(Integer id) {
		vehicleMakeRepository.deleteById(id);
		
	}

}
