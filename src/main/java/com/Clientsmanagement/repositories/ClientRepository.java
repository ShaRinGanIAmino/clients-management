package com.Clientsmanagement.repositories;

import com.Clientsmanagement.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,String> {
}
