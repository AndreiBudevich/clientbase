package com.client.clientbase.repository.client;

import com.client.clientbase.model.Client;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    private final ClientCrudRepository clientCrudRepository;

    public ClientRepositoryImpl(ClientCrudRepository clientCrudRepository) {
        this.clientCrudRepository = clientCrudRepository;
    }

    @Override
    public List<Client> getAll() {
        return clientCrudRepository.findAll();
    }

    @Override
    public Optional<Client> get(long id) {
        return clientCrudRepository.findById(id);
    }

    @Override
    public Client save(Client client) {
        return clientCrudRepository.save(client);
    }
}