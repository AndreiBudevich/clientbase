package com.client.clientbase.service.contact;

import com.client.clientbase.model.Contact;
import com.client.clientbase.model.ContactType;

import java.util.List;

public interface ContactService {

    List<Contact> getAllByClientId(long id);

    List<Contact> getAllByClientIdAndContactType(long id, ContactType contactType);

    Contact save(Contact contact);
}