package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.Supplier;
import com.kindsonthegenius.fleetapp.repositories.SupplierRepository;

@Service
public class SupplierService {
	@Autowired
	private SupplierRepository supplierRepository;

/**
 * 列出所有
 * @return
 */
	public List<Supplier> getSuppliers() {
		return supplierRepository.findAll();
	}

/**
 * 新增or更新
 * @param supplier
 */
	public void save(Supplier supplier) {
		supplierRepository.save(supplier);
	}
	
	public Optional<Supplier> findById(int id) {
		return supplierRepository.findById(id);
	}

	public void delete(Integer id) {
		supplierRepository.deleteById(id);
		
	}
}
