package com.bhavani.LawyerManagementApp.Service;


import com.bhavani.LawyerManagementApp.Model.Client;
import com.bhavani.LawyerManagementApp.Model.Lawyer;

import java.util.List;
import java.util.Set;


public interface LawyerService {

 Lawyer registerLawyer(Lawyer lawyer);

    int verifyLawyer(Integer pid, String pin);

    List<Lawyer> getLawyersBySpecialization(String specialization);

    List<Lawyer> getListOfLawyers();

    Set<Client> getClientsAppointmentsList(int did);

}
