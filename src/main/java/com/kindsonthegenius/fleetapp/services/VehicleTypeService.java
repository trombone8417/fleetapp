package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.VehicleType;
import com.kindsonthegenius.fleetapp.repositories.VehicleTypeRepository;

@Service
public class VehicleTypeService {
	
	@Autowired
	private VehicleTypeRepository vehicleTypeRepository;

/**
 * 列出所有
 * @return
 */
	public List<VehicleType> getVehicleTypes() {
		return vehicleTypeRepository.findAll();
	}

/**
 * 新增or更新
 * @param vehicleType
 */
	public void save(VehicleType vehicleType) {
		vehicleTypeRepository.save(vehicleType);
	}
	
	public Optional<VehicleType> findById(int id) {
		return vehicleTypeRepository.findById(id);
	}

	public void delete(Integer id) {
		vehicleTypeRepository.deleteById(id);
		
	}
}
