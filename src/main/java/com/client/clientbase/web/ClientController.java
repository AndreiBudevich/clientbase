package com.client.clientbase.web;

import com.client.clientbase.model.Client;
import com.client.clientbase.service.client.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static com.client.clientbase.util.ValidationUtil.checkNew;

@RestController
@Slf4j
@Tag(name = "Rest controller by client")
@RequestMapping(value = ClientController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {
    static final String REST_URL = "/api/clients";

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    @Operation(description = "get all clients")
    public List<Client> getAll() {
        log.info("get all clients");
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    @Operation(description = "get client by id")
    public Client get(@PathVariable long id) {
        log.info("get by id");
        return clientService.get(id);
    }

    @Operation(description = "create new client")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> createWithLocation(@Valid @RequestBody Client client) {
        checkNew(client);
        Client created = clientService.save(client);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        log.info("create {}", created);
        return ResponseEntity.created(uriOfNewResource).body(created);
    }
}