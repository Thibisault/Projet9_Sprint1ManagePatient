package com.example.Sprint1ManagePatient.repository;

import com.example.Sprint1ManagePatient.entity.Patient;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>, JpaSpecificationExecutor<Patient>{

    public List<Patient> findAll(Specification<Patient> patientSpecification);

    public Optional<Patient> findByIdPatient(Integer idPatient);
    public Optional<Patient> findByAddress(String adress);


}
