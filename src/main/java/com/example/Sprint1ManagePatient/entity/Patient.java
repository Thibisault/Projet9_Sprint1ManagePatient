package com.example.Sprint1ManagePatient.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "patient")
public class Patient {

    @Id
    @Column(name = "id_patient", nullable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer idPatient;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "sexe", nullable = false)
    private Sexe sexe;

    @Column(name = "phoneNumber", nullable = false)
    private Integer phoneNumber;


}
