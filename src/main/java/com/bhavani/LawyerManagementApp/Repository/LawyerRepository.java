package com.bhavani.LawyerManagementApp.Repository;

import com.bhavani.LawyerManagementApp.Model.Lawyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LawyerRepository extends JpaRepository<Lawyer, Integer> {
}
