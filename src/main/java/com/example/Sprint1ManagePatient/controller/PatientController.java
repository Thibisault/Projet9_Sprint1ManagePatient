package com.example.Sprint1ManagePatient.controller;

import com.example.Sprint1ManagePatient.entity.Patient;
import com.example.Sprint1ManagePatient.exceptions.EmptyField;
import com.example.Sprint1ManagePatient.exceptions.ListPatientIntrouvable;
import com.example.Sprint1ManagePatient.exceptions.ElementIntrouvable;
import com.example.Sprint1ManagePatient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
public class PatientController {
    @Autowired
    PatientService patientService;

    /**
     * Obtenir la liste de tout les patients
     * @return
     */
    @GetMapping("/patient/allPatientList")
    public ResponseEntity<List<Patient>> patientList() {
        RestTemplate restTemplate = new RestTemplate();
        List<Patient> patientList = patientService.findAllPatient();
        if(patientList==null){
            throw new ListPatientIntrouvable("La liste des patients est null", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(patientList, HttpStatus.OK);
    }

    /**
     * Créer un nouveau patient
     * @param patient
     * @return
     */
    @RequestMapping(value = "/patient/validate", method = { RequestMethod.GET, RequestMethod.PUT })
    public ResponseEntity<Patient> validateAddPatient(@RequestBody Patient patient) {
        if (Objects.isNull(patient.getLastName())){
            throw new EmptyField("Le champ lastName est vide", HttpStatus.NO_CONTENT);
        }
        if (Objects.isNull(patient.getAge())){
            throw new EmptyField("Le champ age est vide", HttpStatus.NO_CONTENT);
        }
        if (Objects.isNull(patient.getFirstName())){
            throw new EmptyField("Le champ firstName est vide", HttpStatus.NO_CONTENT);
        }
        if (Objects.isNull(patient.getAddress())){
            throw new EmptyField("Le champ address est vide", HttpStatus.NO_CONTENT);
        }
        if (Objects.isNull(patient.getSexe())){
            throw new EmptyField("Le champ sexe est vide", HttpStatus.NO_CONTENT);
        }
        if (Objects.isNull(patient.getPhoneNumber())){
            throw new EmptyField("Le champ phoneNumber est vide", HttpStatus.NO_CONTENT);
        }
        patient = patientService.addNewPatient(patient);
        if (Objects.isNull(patient)) {
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromPath("/patient/getOnePatient")
                .path("/{id}")
                .buildAndExpand(patient.getIdPatient())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    /**
     * Mettre à jour un patient
     * @param id
     * @param patient
     * @return
     */
    @PutMapping("/patient/updatePatient/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable("id") Integer id, @RequestBody Patient patient) {
        if (Objects.isNull(patient.getLastName())){
            throw new EmptyField("Le champ lastName est vide", HttpStatus.NO_CONTENT);
        }
        if (Objects.isNull(patient.getAge())){
            throw new EmptyField("Le champ age est vide", HttpStatus.NO_CONTENT);
        }
        if (Objects.isNull(patient.getFirstName())){
            throw new EmptyField("Le champ firstName est vide", HttpStatus.NO_CONTENT);
        }
        if (Objects.isNull(patient.getAddress())){
            throw new EmptyField("Le champ address est vide", HttpStatus.NO_CONTENT);
        }
        if (Objects.isNull(patient.getSexe())){
            throw new EmptyField("Le champ sexe est vide", HttpStatus.NO_CONTENT);
        }
        if (Objects.isNull(patient.getPhoneNumber())){
            throw new EmptyField("Le champ phoneNumber est vide", HttpStatus.NO_CONTENT);
        }
        patient.setIdPatient(id);
        patient = patientService.addNewPatient(patient);
        if (Objects.isNull(patient)) {
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(patient.getIdPatient())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    /**
     * Supprimer un patient de la base de données
     * @param id
     * @return
     */
    @RequestMapping(value = "/patient/delete/{id}", method = { RequestMethod.GET, RequestMethod.PUT })
    public ResponseEntity<Patient> showDeletePatient(@RequestBody @PathVariable("id") Integer id) {
        Patient patient = patientService.findByPatientId(id);
        if (Objects.isNull(patient)) {
            throw new ElementIntrouvable("Le patient n'éxiste pas ou l'id '" + id +"' est faux", HttpStatus.NOT_FOUND);
        }
        patientService.deletePatient(patient);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Obtenir un patient via son id
     * @param id
     * @return
     */
    @GetMapping("/patient/getOnePatient/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") Integer id){
        Patient patient = patientService.findByPatientId(id);
        if(patient==null){
            throw new ElementIntrouvable("Le patient est null ou introuvable", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }
}
