package com.example.cubochallenger.repository;

import com.example.cubochallenger.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
