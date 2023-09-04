package com.client.clientbase.service.client;

import com.client.clientbase.model.Client;

import java.util.List;

public interface ClientService {

    List<Client> getAll();

    Client get(long id);

    Client save(Client client);
}