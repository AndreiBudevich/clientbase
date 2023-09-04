package com.client.clientbase.data;

import com.client.clientbase.MatcherFactory;
import com.client.clientbase.model.Client;

public class ClientTestData {

    public static final long CLIENT_ID_1 = 1;
    public static final long CLIENT_ID_2 = CLIENT_ID_1 + 1;
    public static final long CLIENT_ID_3 = CLIENT_ID_2 + 1;
    public static final MatcherFactory.Matcher<Client> CLIENT_MATCHER =
            MatcherFactory.usingIgnoringFieldsComparator(Client.class, "contacts");
    public static final Client client1 = new Client(CLIENT_ID_1, "Андрей", "Будевич");
    public static final Client client2 = new Client(CLIENT_ID_2, "Татьяна", "Будевич");
    public static final Client client3 = new Client(CLIENT_ID_3, "Ксения", "Будевич");

    public static Client getNew() {
        return new Client("Вероника", "Будевич");
    }
}