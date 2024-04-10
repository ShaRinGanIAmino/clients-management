package com.Clientsmanagement.services;

import com.Clientsmanagement.DTO.ClientDTO;
import com.Clientsmanagement.models.Client;
import com.Clientsmanagement.repositories.ClientRepository;
import exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository ;

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public Client getClientById(String id ){
        Client client = clientRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Client with this id is not found !"));

        return ResponseEntity.ok(client).getBody();
    }

    public Client createClient (ClientDTO client){
        Client createClient = new Client();
        createClient.setFullName(client.getFullName());
        createClient.setDescription(client.getDescription());
        createClient.setPhoneNumber(client.getPhoneNumber());
        createClient.setEmail(client.getEmail());

        clientRepository.save(createClient);
        return clientRepository.save(createClient);
    }

    public String deleteClient(String id){
        Client client = clientRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Client with this id is not found !"));

        try {
            clientRepository.delete(client);
            return "Client deleted successfully !";
        } catch (Exception e){
            return "Error deleting this Client !";
        }
    }
}
