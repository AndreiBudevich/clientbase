package com.client.clientbase.repository.client;

import com.client.clientbase.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    List<Client> getAll();

    Optional<Client> get(long id);

    Client save(Client client);
}