package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.EmployeeType;
import com.kindsonthegenius.fleetapp.repositories.EmployeeTypeRepository;

@Service
public class EmployeeTypeService {
	
	@Autowired
	private EmployeeTypeRepository employeeTypeRepository;

/**
 * 列出所有
 * @return
 */
	public List<EmployeeType> getEmployeeTypes() {
		return employeeTypeRepository.findAll();
	}

/**
 * 新增or更新
 * @param employeeType
 */
	public void save(EmployeeType employeeType) {
		employeeTypeRepository.save(employeeType);
	}
	
	public Optional<EmployeeType> findById(int id) {
		return employeeTypeRepository.findById(id);
	}

	public void delete(Integer id) {
		employeeTypeRepository.deleteById(id);
		
	}
}
