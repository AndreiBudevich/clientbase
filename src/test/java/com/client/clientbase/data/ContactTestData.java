package com.client.clientbase.data;

import com.client.clientbase.MatcherFactory;
import com.client.clientbase.model.Contact;

import static com.client.clientbase.model.ContactType.EMAIL;
import static com.client.clientbase.model.ContactType.PHONE_NUMBER;

public class ContactTestData {

    public static final long CONTACT_ID_1 = 1;
    public static final long CONTACT_ID_2 = CONTACT_ID_1 + 1;

    public static final MatcherFactory.Matcher<Contact> CONTACT_MATCHER =
            MatcherFactory.usingIgnoringFieldsComparator(Contact.class, "client");
    public static final Contact contact1 = new Contact(CONTACT_ID_1, "budevichac@gmail.com", EMAIL);
    public static final Contact contact2 = new Contact(CONTACT_ID_2, "+375297634349", PHONE_NUMBER);

    public static Contact getNew() {
        return new Contact("info@unibell.ru", EMAIL);
    }
}