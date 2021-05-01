package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.Invoice;
import com.kindsonthegenius.fleetapp.repositories.InvoiceRepository;

@Service
public class InvoiceService {
	
	@Autowired
	private InvoiceRepository invoiceRepository;

/**
 * 列出所有國家
 * @return
 */
	public List<Invoice> getInvoices() {
		return invoiceRepository.findAll();
	}

/**
 * 新增or更新
 * @param invoice
 */
	public void save(Invoice invoice) {
		invoiceRepository.save(invoice);
	}
	
	public Optional<Invoice> findById(int id) {
		return invoiceRepository.findById(id);
	}

	public void delete(Integer id) {
		invoiceRepository.deleteById(id);
		
	}
}
