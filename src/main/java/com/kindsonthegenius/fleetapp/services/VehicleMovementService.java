package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.VehicleMovement;
import com.kindsonthegenius.fleetapp.repositories.VehicleMovementRepository;

@Service
public class VehicleMovementService {
	
	@Autowired
	private VehicleMovementRepository vehicleMovementRepository;

/**
 * 列出所有
 * @return
 */
	public List<VehicleMovement> getVehicleMovements() {
		return vehicleMovementRepository.findAll();
	}

/**
 * 新增or更新
 * @param vehicleMovement
 */
	public void save(VehicleMovement vehicleMovement) {
		vehicleMovementRepository.save(vehicleMovement);
	}
	
	public Optional<VehicleMovement> findById(int id) {
		return vehicleMovementRepository.findById(id);
	}

	public void delete(Integer id) {
		vehicleMovementRepository.deleteById(id);
		
	}
}
