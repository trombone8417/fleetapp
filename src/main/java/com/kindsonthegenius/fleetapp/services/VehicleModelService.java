package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.VehicleModel;
import com.kindsonthegenius.fleetapp.repositories.VehicleModelRepository;

@Service
public class VehicleModelService {
	
	@Autowired
	private VehicleModelRepository vehicleModelRepository;

/**
 * 列出所有
 * @return
 */
	public List<VehicleModel> getVehicleModels() {
		return vehicleModelRepository.findAll();
	}

/**
 * 新增or更新
 * @param vehicleModel
 */
	public void save(VehicleModel vehicleModel) {
		vehicleModelRepository.save(vehicleModel);
	}
	
	public Optional<VehicleModel> findById(int id) {
		return vehicleModelRepository.findById(id);
	}

	public void delete(Integer id) {
		vehicleModelRepository.deleteById(id);
		
	}
}
