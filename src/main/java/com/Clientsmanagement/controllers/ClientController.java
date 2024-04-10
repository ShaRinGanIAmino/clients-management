package com.Clientsmanagement.controllers;

import com.Clientsmanagement.DTO.ClientDTO;
import com.Clientsmanagement.models.Client;
import com.Clientsmanagement.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Client getClientByID(@PathVariable String id ){
        return clientService.getClientById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client createClient(@RequestBody ClientDTO client){
        return clientService.createClient(client);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteClient(@PathVariable String id){
        return clientService.deleteClient(id);
    }
}
