package com.client.clientbase.repository.contact;

import com.client.clientbase.model.Contact;
import com.client.clientbase.model.ContactType;

import java.util.List;

public interface ContactRepository {

    List<Contact> getAllByClientId(long id);

    List<Contact> getAllByClientIdAndContactType(long id, ContactType contactType);

    Contact save(Contact contact);
}