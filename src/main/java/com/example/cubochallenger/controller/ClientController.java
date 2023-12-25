package com.example.cubochallenger.controller;

import com.example.cubochallenger.model.Client;
import com.example.cubochallenger.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> listarClient() {
        List<Client> clients = clientService.buscarClients();
        return ResponseEntity.ok(clients);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Client> buscarClient(@PathVariable("id") Long id) {
        Client client = clientService.buscarClient(id);
        return ResponseEntity.ok(client);
    }

    @PostMapping
    public ResponseEntity<Client> salvarClient(@RequestBody Client client) {
        Client clientSalvo = clientService.salvarClient(client);
        return ResponseEntity.ok(clientSalvo);
    }

    @PutMapping(path = "/{id}")
   public ResponseEntity<Client> atualizarClient(@PathVariable Long id, @RequestBody Client client) {
        clientService.atualizarClient(id, client);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarClient(@PathVariable Long id) {
        clientService.deletarClient(id);
        return ResponseEntity.ok().build();
    }
}
