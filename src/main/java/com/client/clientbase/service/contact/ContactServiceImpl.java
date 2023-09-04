package com.client.clientbase.service.contact;

import com.client.clientbase.model.Client;
import com.client.clientbase.model.Contact;
import com.client.clientbase.model.ContactType;
import com.client.clientbase.repository.client.ClientRepository;
import com.client.clientbase.repository.contact.ContactRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final ClientRepository clientRepository;

    public ContactServiceImpl(ContactRepository contactRepository,
                              ClientRepository clientRepository) {
        this.contactRepository = contactRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Contact> getAllByClientId(long clientId) {
        return contactRepository.getAllByClientId(clientId);
    }

    @Override
    public List<Contact> getAllByClientIdAndContactType(long clientId, ContactType contactType) {
        return contactRepository.getAllByClientIdAndContactType(clientId, contactType);
    }

    @Override
    public Contact save(Contact contact, @RequestParam long clientId) {
        Client client = clientRepository.get(clientId).orElse(null);
        assert client != null;
        contact.setClient(client);
        return contactRepository.save(contact);
    }
}