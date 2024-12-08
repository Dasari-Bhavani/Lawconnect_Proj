package com.bhavani.LawyerManagementApp.Service;

import com.bhavani.LawyerManagementApp.Model.Client;

import java.util.List;


public interface ClientService {

    Client registerClient(Client client);

    int verifyClient(Integer pid, String pin);

    List<Client> getListOfClients ( );

    void selectLawyer ( Integer pid, Integer did );

    Client getClientObject ( Integer pid );

    void deleteClientProfile ( Integer pid );

    Client updateClientProfile ( Client client );
}
