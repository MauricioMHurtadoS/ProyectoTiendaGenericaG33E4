package mintic.edu.g33.e4.tgback.service;

import java.util.List;

import mintic.edu.g33.e4.tgback.model.Client;


public interface ClientService {
	
	Client createClient(Client client);
	
	Client updateClient(Client client);
	
	List<Client> getAllClient();
	
	Client getClientById(String clientId);
	
	void delClient(String clientId);
	
}
