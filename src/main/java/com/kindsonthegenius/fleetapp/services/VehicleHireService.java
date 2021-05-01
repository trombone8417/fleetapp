package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.VehicleHire;
import com.kindsonthegenius.fleetapp.repositories.VehicleHireRepository;

@Service
public class VehicleHireService {
	
	@Autowired
	private VehicleHireRepository vehicleHireRepository;

/**
 * 列出所有
 * @return
 */
	public List<VehicleHire> getVehicleHires() {
		return vehicleHireRepository.findAll();
	}

/**
 * 新增or更新
 * @param vehicleHire
 */
	public void save(VehicleHire vehicleHire) {
		vehicleHireRepository.save(vehicleHire);
	}
	
	public Optional<VehicleHire> findById(int id) {
		return vehicleHireRepository.findById(id);
	}

	public void delete(Integer id) {
		vehicleHireRepository.deleteById(id);
		
	}
}
