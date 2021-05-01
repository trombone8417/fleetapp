package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.Employee;
import com.kindsonthegenius.fleetapp.repositories.EmployeeRepository;

@Service
public class EmployeeService {
		
	@Autowired
	private EmployeeRepository employeeRepository;

/**
 * 列出所有
 * @return
 */
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

/**
 * 新增or更新
 * @param employee
 */
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}
	
	public Optional<Employee> findById(int id) {
		return employeeRepository.findById(id);
	}

	public void delete(Integer id) {
		employeeRepository.deleteById(id);
		
	}
}
