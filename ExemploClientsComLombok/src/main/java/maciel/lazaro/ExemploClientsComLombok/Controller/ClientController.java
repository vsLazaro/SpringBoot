package maciel.lazaro.ExemploClientsComLombok.Controller;

import maciel.lazaro.ExemploClientsComLombok.Model.Client;
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

    @GetMapping("ArrayCliente")
    public ArrayList<Client> arrayClient() {
        Client client1 = new Client();
        client1.setName("Lázaro");
        client1.setDateOfBirth("13/04/2001");

        Client client2 = new Client();
        client2.setName("Marcio");
        client2.setDateOfBirth("25/11/2005");

        ArrayList<Client> clients = new ArrayList<>();
        clients.add(client1);
        clients.add(client2);

        return clients;
    }
}
