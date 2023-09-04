package com.client.clientbase.repository.client;

import com.client.clientbase.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientCrudRepository extends JpaRepository<Client, Long> {
}