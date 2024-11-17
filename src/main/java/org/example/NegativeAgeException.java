package org.example;

public class NegativeAgeException extends RuntimeException {

    //constructor
    public NegativeAgeException() {
        super();
    }

    public String getMessage(){
        return "Omul trebuie sa se fii nascut";
    }
}
