package com.client.clientbase.repository.contact;

import com.client.clientbase.model.Contact;
import com.client.clientbase.model.ContactType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactRepositoryImpl implements ContactRepository {

    private final ContactCrudRepository contactCrudRepository;

    public ContactRepositoryImpl(ContactCrudRepository contactCrudRepository) {
        this.contactCrudRepository = contactCrudRepository;
    }


    @Override
    public List<Contact> getAllByClientId(long id) {
        return contactCrudRepository.getAllByClientId(id);
    }

    @Override
    public List<Contact> getAllByClientIdAndContactType(long id, ContactType contactType) {
        return contactCrudRepository.getAllByClientIdAndContactType(id, contactType);
    }

    @Override
    public Contact save(Contact contact) {
        return contactCrudRepository.save(contact);
    }
}