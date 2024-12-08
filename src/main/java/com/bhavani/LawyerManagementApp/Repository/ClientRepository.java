package com.bhavani.LawyerManagementApp.Repository;

import com.bhavani.LawyerManagementApp.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
