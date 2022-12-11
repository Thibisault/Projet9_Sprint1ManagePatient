package com.example.Sprint1ManagePatient.service;

import com.example.Sprint1ManagePatient.entity.Patient;
import com.example.Sprint1ManagePatient.repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public Patient addNewPatient(Patient newPatient){
        return patientRepository.save(newPatient);
    }

    public void deletePatient(Patient patient){
        patientRepository.delete(patient);
    }

    public List<Patient> findAllPatient(){
        List<Patient> patientList;
        patientList = patientRepository.findAll();
        return patientList;
    }

    public Patient findByPatientId(Integer idPatient){
        return patientRepository.findByIdPatient(idPatient).orElse(null);
    }

    public Patient findByAddress(String address){
        return patientRepository.findByAddress(address).orElse(null);
    }

}
