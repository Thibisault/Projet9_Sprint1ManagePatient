/*
package com.example.Sprint1ManagePatient.service;

import com.example.Sprint1ManagePatient.entity.Patient;
import com.example.Sprint1ManagePatient.entity.Sexe;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.util.AssertionErrors.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TestPatientService {

    @Mock
    PatientService patientService;

    @Test
    public void contextLoads() {
    }

    public void createPatient(Patient patient){
        patient.setAddress("33WithMock");
        patient.setAge(15);
        patient.setFirstName("moi");
        patient.setLastName("toi");
        patient.setPhoneNumber(060606);
        patient.setSexe(Sexe.FEMALE);
        patientService.addNewPatient(patient);
    }

    @Test
    public void testAddNewPatient(){
        Patient patient = new Patient();
        this.createPatient(patient);
        Mockito.when(patientService.findByPatientId(patient.getIdPatient())).thenReturn(null);

        final Patient patientResult = patientService.findByPatientId(patient.getIdPatient());

        Mockito.verify(patientService).findByPatientId(patient.getIdPatient());
        assertNull("Le patient n'a pas été crée ou n'a pas été trouvé dans la base de donéés", patientResult);
    }

    @Test
    public void testDeletePatient(){
        Patient patient = new Patient();
        this.createPatient(patient);
        Mockito.when(patientService.findByPatientId(patient.getIdPatient())).thenReturn(null);

        final Patient patientResult = patientService.findByPatientId(patient.getIdPatient());

        patientService.deletePatient(patient);

        Mockito.verify(patientService).findByPatientId(patient.getIdPatient());
        assertNull("Le patitent n'a pas été supprimé", patientResult);

    }

    @Test
    public void testfindPatientById(){
        Patient patient = new Patient();
        this.createPatient(patient);
        Mockito.when(patientService.findByPatientId(patient.getIdPatient())).thenReturn(patient);

        final Patient patientResult = patientService.findByPatientId(patient.getIdPatient());

        Mockito.verify(patientService).findByPatientId(patient.getIdPatient());
        assertNotNull("Le patitent n'a pas été trouvé grâce à son Id", patientResult);
    }

    @Test
    public void testFindAllPatient(){
        Patient patient = new Patient();
        Patient patient_2 = new Patient();
        List<Patient> patientList = new ArrayList<>();
        patientList.add(patient);
        patientList.add(patient_2);
        this.createPatient(patient);
        this.createPatient(patient_2);

        Mockito.when(patientService.findAllPatient()).thenReturn(patientList);

        final List<Patient> patientResult = patientService.findAllPatient();

        Mockito.verify(patientService).findAllPatient();
        assertEquals("La méthode n'a pas réussi à récuperer tout les patients", 2, patientResult.size());
    }

    @Test
    public void testUpdatePatient(){
        Patient patient = new Patient();
        this.createPatient(patient);

        Mockito.when(patientService.findByAddress(patient.getAddress())).thenReturn(patient);

        Patient patientResult = patientService.findByAddress(patient.getAddress());
        System.out.println(patientResult);

        Mockito.verify(patientService).findByAddress(patient.getAddress());
        assertNotNull("Le patient n'a pas été récupéré en base ou n'a pas été crée" , patientResult);

        patient.setAddress("34");
        patient.setAge(16);
        patient.setFirstName("mois");
        patient.setLastName("tois");
        patient.setPhoneNumber(323232);
        patient.setSexe(Sexe.MALE);
        patientService.addNewPatient(patient);

        Mockito.when(patientService.findByAddress(patient.getAddress())).thenReturn(patient);
        Patient patientUpdateResult = patientService.findByAddress(patient.getAddress());
        assertNotNull("Le patient n'a pas été récupéré en base ou n'a pas été crée ou n'a pas été mis à jours" , patientUpdateResult);
    }

    /*
    @Test
    public void testCrudPatient(){
        Patient patient = new Patient();
        Patient patient_2 = new Patient();
        Patient patient_3 = new Patient();
        List<Patient> patientList = new ArrayList<>();
        patientList.add(patient);
        patientList.add(patient_2);
        this.createPatient(patient);
        this.createPatient(patient_2);

        Mockito.when(patientService.findAllPatient()).thenReturn(patientList);
        Mockito.when(patientService.findByPatientId(patient.getIdPatient())).thenReturn(patient);
        Mockito.when(patientService.findByPatientId(patient_2.getIdPatient())).thenReturn(patient);
        Mockito.when(patientService.findByPatientId(patient_3.getIdPatient())).thenReturn(patient);

        final List<Patient> patientListResult = patientService.findAllPatient();
        final Patient patient_1Result = patientService.findByPatientId(patient.getIdPatient());
        final Patient patient_2Result = patientService.findByPatientId(patient_2.getIdPatient());
        final Patient patient_3Result = patientService.findByPatientId(patient_3.getIdPatient());

        patientService.deletePatient(patient_3);

        Mockito.verify(patientService).findAllPatient(), ;
        Mockito.verify(patientService).findByPatientId(patient.getIdPatient());
        Mockito.verify(patientService).findByPatientId(patient_2.getIdPatient());
        Mockito.verify(patientService).findByPatientId(patient_3.getIdPatient());
        assertEquals("La méthode n'a pas réussi à récuperer tout les patients", 2, patientListResult.size());
        assertNotNull("Le patitent n'a pas été trouvé grâce à son Id", patient_1Result);
        assertNotNull("Le patitent n'a pas été supprimé", patient_2Result);
        assertNull("Le patient n'a pas été crée ou n'a pas été trouvé dans la base de donéés",patient_3Result);
    }

}

     */
