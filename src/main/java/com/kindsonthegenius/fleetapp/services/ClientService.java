package com.kindsonthegenius.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kindsonthegenius.fleetapp.models.Client;
import com.kindsonthegenius.fleetapp.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;

/**
 * 列出所有
 * @return
 */
	public List<Client> getClients() {
		return clientRepository.findAll();
	}

/**
 * 新增or更新
 * @param client
 */
	public void save(Client client) {
		clientRepository.save(client);
	}
	
	public Optional<Client> findById(int id) {
		return clientRepository.findById(id);
	}

	public void delete(Integer id) {
		clientRepository.deleteById(id);
		
	}
}
