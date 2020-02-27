package net.tirasa.client;

import com.okta.sdk.authc.credentials.TokenClientCredentials;
import com.okta.sdk.client.Client;
import com.okta.sdk.client.Clients;
import java.util.Date;

public class App {

    public static void main(String[] args) {

        Client client =
                Clients.builder()
                        .setOrgUrl("https://host/")
                        .setClientCredentials(new TokenClientCredentials("XXX")).
                        build();

        System.out.println("Start: " + new Date());
        client.listUsers(null,
                "status eq \"STAGED\"", null, null, null).stream().
                forEach(item -> {
                    System.out.println("User: " + item.getId());
                    item.deactivate(false);
                });
        System.out.println("Finish: " + new Date());
    }
}
