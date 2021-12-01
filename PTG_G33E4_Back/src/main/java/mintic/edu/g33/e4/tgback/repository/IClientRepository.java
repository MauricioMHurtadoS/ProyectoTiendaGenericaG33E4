package mintic.edu.g33.e4.tgback.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import mintic.edu.g33.e4.tgback.model.Client;

@Repository
public interface IClientRepository extends MongoRepository<Client, String> {

}
