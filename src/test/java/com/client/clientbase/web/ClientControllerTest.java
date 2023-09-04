package com.client.clientbase.web;

import com.client.clientbase.AbstractControllerTest;
import com.client.clientbase.data.ClientTestData;
import com.client.clientbase.model.Client;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.client.clientbase.data.ClientTestData.*;
import static com.client.clientbase.util.JsonUtil.writeValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ClientControllerTest extends AbstractControllerTest {

    private static final String REST_URL = ClientController.REST_URL;

    @Test
    void getAll() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(CLIENT_MATCHER.contentJson(client1, client2, client3));
    }

    @Test
    void get() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + '/' + CLIENT_ID_1))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(CLIENT_MATCHER.contentJson(client1));
    }

    @Test
    void createWithLocation() throws Exception {
        Client newClient = getNew();
        ResultActions action = perform(MockMvcRequestBuilders.post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(writeValue(newClient)));
        Client created = CLIENT_MATCHER.readFromJson(action);
        long newId = created.id();
        newClient.setId(newId);
        CLIENT_MATCHER.assertMatch(created, newClient);
    }
}