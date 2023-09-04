package com.client.clientbase.web;

import com.client.clientbase.model.Contact;
import com.client.clientbase.model.ContactType;
import com.client.clientbase.service.contact.ContactService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static com.client.clientbase.util.ValidationUtil.checkNew;

@RestController
@Slf4j
@Validated
@RequestMapping(value = ContactController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ContactController {
    static final String REST_URL = "/api/contacts";

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/get-all-by-client-id")
    public List<Contact> getAllByClientId(@RequestParam long clientId) {
        log.info("get all contacts by clientId {}", clientId);
        return contactService.getAllByClientId(clientId);
    }

    @GetMapping("/get-all-by-client-id-by-contact-type")
    public List<Contact> getAllByClientIdAndContactType(@RequestParam long clientId, @RequestParam ContactType contactType) {
        log.info("get all contacts by clientId {} by contactType {}", clientId, contactType);
        return contactService.getAllByClientIdAndContactType(clientId, contactType);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Contact> createWithLocation(@Valid @RequestBody Contact contact, @RequestParam long clientId) {
        checkNew(contact);
        Contact created = contactService.save(contact, clientId);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        log.info("create {}", created);
        return ResponseEntity.created(uriOfNewResource).body(created);
    }
}