package maciel.lazaro.ExemploClientsemLombok.Controller;

import maciel.lazaro.ExemploClientsemLombok.Model.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ClientController {
    @GetMapping("/clientes")
    public Client getClient() {
        Client client = new Client();
        client.setName("Lázaro");
        client.setDateOfBirth("13/04/2001");

        return client;
    }
    @GetMapping("/ArrayClientes")
    public ArrayList<Client> getClients() {
        Client client1 = new Client();
        client1.setName("Lázaro");
        client1.setDateOfBirth("13/04/2001");

        Client client2 = new Client();
        client2.setName("Roberto");
        client2.setDateOfBirth("15/08/1957");

        ArrayList<Client> clients = new ArrayList<>();
        clients.add(client1);
        clients.add(client2);

        return clients;
    }
}
