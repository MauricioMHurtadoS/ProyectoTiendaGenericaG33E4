package mintic.edu.g33.e4.tgback.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mintic.edu.g33.e4.tgback.exception.ResourceNotFoundException;
import mintic.edu.g33.e4.tgback.model.Client;
import mintic.edu.g33.e4.tgback.repository.IClientRepository;
@Service
@Transactional
public class ClientServiceImp implements ClientService {
	
	@Autowired
	private IClientRepository clientRepo;
	
	@Override
	public Client createClient(Client client) {

		return clientRepo.save(client);
		
	}

	@Override
	public Client updateClient(Client client) {
		
		Optional<Client> clientDb=this.clientRepo.findById(client.getId());
		
		if(clientDb.isPresent()) {
			
			Client clientUpdate=clientDb.get();
			clientUpdate.setId(client.getId());
			clientUpdate.setCedula(client.getCedula());
			clientUpdate.setDireccion(client.getDireccion());
			clientUpdate.setEmail(client.getEmail());
			clientUpdate.setNombre(client.getNombre());
			clientUpdate.setTelefono(client.getTelefono());
			clientRepo.save(clientUpdate);
			
			return clientUpdate;			
		}else {
			throw new ResourceNotFoundException("Registro no encontrado con el id: "+client.getId());
		}
		
	}

	@Override
	public List<Client> getAllClient() {
		
		return clientRepo.findAll();
		
	}

	@Override
	public Client getClientById(String clientId) {
		
		Optional<Client> clientDb=this.clientRepo.findById(clientId);
		if(clientDb.isPresent()) {
			return clientDb.get();
		}else {
			throw new ResourceNotFoundException("Registro no encontrado con el id: "+clientId);
		}
		
	}

	@Override
	public void delClient(String clientId) {
		
		Optional<Client> clientDb=this.clientRepo.findById(clientId);
		if(clientDb.isPresent()) {
			this.clientRepo.delete(clientDb.get());
		}else {
			throw new ResourceNotFoundException("Registro no encontrado con el id: "+clientId);
		}
	}

}
