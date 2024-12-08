package com.bhavani.LawyerManagementApp.Service;

import com.bhavani.LawyerManagementApp.Model.Client;
import com.bhavani.LawyerManagementApp.Model.Lawyer;
import com.bhavani.LawyerManagementApp.Repository.ClientRepository;
import com.bhavani.LawyerManagementApp.Repository.LawyerRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final LawyerRepository lawyerRepository;

    public ClientServiceImpl(ClientRepository clientRepository, LawyerRepository lawyerRepository) {
        this.clientRepository = clientRepository;
        this.lawyerRepository = lawyerRepository;
    }

    public Client registerClient(Client client) {
        return clientRepository.save(client);
    }

    public int verifyClient(Integer pid, String pin) {
        Client client = clientRepository.findById(pid).orElse(null);

        if (ObjectUtils.isEmpty(client)) {
            return -1;
        }
        if (pin.equals(client.getPin())) {
            return 1;
        } else {
            return -1;
        }
    }

    public List<Client> getListOfClients() {
        return clientRepository.findAll();
    }

    public void selectLawyer(Integer pid, Integer did) {
        Client client = clientRepository.findById(pid).orElse(null);
        Lawyer lawyer = lawyerRepository.findById(did).orElse(null);

        if (!ObjectUtils.isEmpty(lawyer)) {
            lawyer.getPatList().add(client);
            lawyerRepository.save(lawyer);
        }
    }

    public Client getClientObject(Integer pid) {
        return clientRepository.findById(pid).orElse(null);
    }

    public void deleteClientProfile(Integer pid) {
        clientRepository.deleteById(pid);
    }

    public Client updateClientProfile(Client client) {
        return clientRepository.save(client);
    }

}
