package com.client.clientbase.repository.contact;

import com.client.clientbase.model.Contact;
import com.client.clientbase.model.ContactType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContactCrudRepository extends JpaRepository<Contact, Long> {

    @Query("SELECT c FROM Contact c WHERE c.client.id =?1")
    List<Contact> getAllByClientId(long clientId);

    @Query("SELECT c FROM Contact c WHERE c.client.id =?1 AND c.contactType = ?2")
    List<Contact> getAllByClientIdAndContactType(long clientId, ContactType contactType);
}