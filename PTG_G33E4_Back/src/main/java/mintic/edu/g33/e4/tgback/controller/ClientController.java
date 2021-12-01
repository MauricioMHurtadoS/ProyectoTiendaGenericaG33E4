package mintic.edu.g33.e4.tgback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mintic.edu.g33.e4.tgback.model.Client;
import mintic.edu.g33.e4.tgback.service.ClientService;

@RestController
@CrossOrigin(origins="*", methods={RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/clientes")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/clientes")
	public ResponseEntity<List<Client>> getAllClients(){
		return ResponseEntity.ok().body(clientService.getAllClient());
	}

	@GetMapping("/clientes/{id}")
	public ResponseEntity<Client> getClienteById(@PathVariable String id){
		return ResponseEntity.ok().body(clientService.getClientById(id));
	}

	@PostMapping("/clientes")
	public ResponseEntity<Client> createClient(@RequestBody Client client){
		return ResponseEntity.ok().body(this.clientService.createClient(client));
	}

	@PutMapping("/clientes")
	public ResponseEntity<Client> updateClient(@PathVariable String id,@RequestBody Client client){
		client.setId(id);
		return ResponseEntity.ok().body(this.clientService.updateClient(client));
	}

	@DeleteMapping("/clientes")
	public HttpStatus deleteClient(@PathVariable String id){
		this.clientService.delClient(id);
		return HttpStatus.OK;
	}
	
}
