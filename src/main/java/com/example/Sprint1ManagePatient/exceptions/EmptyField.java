package com.example.Sprint1ManagePatient.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NO_CONTENT)
public class EmptyField extends RuntimeException {
    public EmptyField(String string, HttpStatus noContent) {
        super(string);
        System.out.println(string + " -- " + noContent);
    }
}
