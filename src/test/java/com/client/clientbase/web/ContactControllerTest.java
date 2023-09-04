package com.client.clientbase.web;

import com.client.clientbase.AbstractControllerTest;
import com.client.clientbase.data.ContactTestData;
import com.client.clientbase.model.Contact;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.client.clientbase.data.ContactTestData.*;
import static com.client.clientbase.util.JsonUtil.writeValue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ContactControllerTest extends AbstractControllerTest {

    private static final String REST_URL = ContactController.REST_URL;

    @Test
    void getAllByClientId() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + "/get-all-by-client-id")
                .param("clientId", "1"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(CONTACT_MATCHER.contentJson(contact1, contact2));
    }

    @Test
    void getAllByClientIdAndContactType() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + "/get-all-by-client-id-by-contact-type")
                .param("clientId", "1")
                .param("contactType", "EMAIL"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(CONTACT_MATCHER.contentJsonOneListed(contact1));
    }

    @Test
    void createWithLocation() throws Exception {
        Contact newContact = ContactTestData.getNew();
        ResultActions action = perform(MockMvcRequestBuilders.post(REST_URL)
                .param("clientId", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writeValue(newContact)));
        Contact created = CONTACT_MATCHER.readFromJson(action);
        long newId = created.id();
        newContact.setId(newId);
        CONTACT_MATCHER.assertMatch(created, newContact);
    }
}