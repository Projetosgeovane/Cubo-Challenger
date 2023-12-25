package com.example.cubochallenger.services;

import com.example.cubochallenger.model.Client;
import com.example.cubochallenger.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> buscarClients() {
        return clientRepository.findAll();
    }

    public Client buscarClient(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public Client salvarClient(Client client) {
        return clientRepository.save(client);
    }

    public Client atualizarClient(Long id, Client client) {
        Client clientAtual = clientRepository.findById(id).orElse(null);
        clientAtual.setFirstName(client.getFirstName());
        clientAtual.setLastName(client.getLastName());
        clientAtual.setParticipation(client.getParticipation());
        return clientRepository.save(clientAtual);
    }

    public void deletarClient(Long id) {
        clientRepository.deleteById(id);
    }
}
