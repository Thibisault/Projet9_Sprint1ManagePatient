package com.example.Sprint1ManagePatient.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ElementIntrouvable extends RuntimeException {
    public ElementIntrouvable(String string, HttpStatus notFound) {
        super(string);
        System.out.println(string + " -- " + notFound);
    }
}
