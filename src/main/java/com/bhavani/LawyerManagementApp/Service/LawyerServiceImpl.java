package com.bhavani.LawyerManagementApp.Service;

//import Client;
//import com.bhavani.LawyerManagementApp.Repository.LawyerRepository;
import com.bhavani.LawyerManagementApp.Model.Client;
import com.bhavani.LawyerManagementApp.Model.Lawyer;
import com.bhavani.LawyerManagementApp.Repository.LawyerRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class LawyerServiceImpl implements LawyerService {

    private final LawyerRepository lawyerRepository;

    public LawyerServiceImpl(LawyerRepository lawyerRepository) {
        this.lawyerRepository = lawyerRepository;
    }

    public Lawyer registerLawyer(Lawyer lawyer) {
        return lawyerRepository.save(lawyer);
    }

    public int verifyLawyer(Integer did, String pin) {
        Lawyer lawyer = lawyerRepository.findById(did).orElse(null);

        if (ObjectUtils.isEmpty(lawyer)) {
            return -1;
        }
        if (pin.equals(lawyer.getPin())) {
            return 1;
        } else {
            return -1;
        }
    }

    public List<Lawyer> getLawyersBySpecialization(String specialization) {
        return lawyerRepository.findAll().stream().filter(lawyer -> lawyer.getSpecialization().equals(specialization)).toList();
    }

    public List<Lawyer> getListOfLawyers() {
        return lawyerRepository.findAll();
    }

    /**
     * @param did
     * @return
     */


    public Set<Client> getClientsAppointmentsList(int did) {
        Lawyer lawyer = lawyerRepository.findById(did).orElse(null);
        if (ObjectUtils.isEmpty(lawyer)) {
            return new HashSet<>();
        }
        return lawyer.getPatList();
    }

}
