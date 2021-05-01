package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.Contact;
import com.kindsonthegenius.fleetapp.repositories.ContactRepository;

@Service
public class ContactService {
	@Autowired
	private ContactRepository contactRepository;

/**
 * 列出所有
 * @return
 */
	public List<Contact> getContacts() {
		return contactRepository.findAll();
	}

/**
 * 新增or更新
 * @param contact
 */
	public void save(Contact contact) {
		contactRepository.save(contact);
	}
	
	public Optional<Contact> findById(int id) {
		return contactRepository.findById(id);
	}

	public void delete(Integer id) {
		contactRepository.deleteById(id);
		
	}

}
