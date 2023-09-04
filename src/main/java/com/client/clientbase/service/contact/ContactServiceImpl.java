package com.client.clientbase.service.contact;

import com.client.clientbase.model.Contact;
import com.client.clientbase.model.ContactType;
import com.client.clientbase.repository.contact.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<Contact> getAllByClientId(long id) {
        return contactRepository.getAllByClientId(id);
    }

    @Override
    public List<Contact> getAllByClientIdAndContactType(long id, ContactType contactType) {
        return contactRepository.getAllByClientIdAndContactType(id, contactType);
    }

    @Override
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }
}