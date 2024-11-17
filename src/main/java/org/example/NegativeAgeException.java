package org.example;

public class NegativeAgeException extends RuntimeException {

    //constructor
    public NegativeAgeException() {
        super();
    }

    public String getMessage(){
        return "Negative age was input";
    }
}
