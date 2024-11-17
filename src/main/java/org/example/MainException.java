package org.example;

import java.util.Scanner;
import java.util.regex.Pattern;

public class MainException {

    private static final Scanner scanner = new Scanner(System.in);
    static Pattern regex = Pattern.compile("[0-9$&+,:;=\\\\?@#|/'<>.^*()%!-]");

    public static void main(String[] args) {

        String name = "";
        String inputAge = "";
        int personAge = 0;

        System.out.println("introduceti numele: ");
        name = scanner.nextLine();
        if(name.isEmpty()){
            System.out.println("numele introdus e vid, va rugam introuceti o valoare de minim 2 litere. \n" +
                    "Programul nu va continua fara datele corecte");
            return;
        }else if(regex.matcher(name).find()){
            throw new RuntimeException("numele poate poate contine doar litere " +
                                        "nu poate contine caractere speciale sau cifre");
        }

        System.out.println("introduceti varsta: ");
        inputAge = scanner.nextLine();
        if(inputAge.isEmpty()) {
            System.out.println("varsta introdusa e vida, va rugam introuceti un numar care sa o reprezinte. \n" +
                    "Programul nu va continua fara datele corecte");
            return;
        }else{
            personAge = Integer.parseInt(inputAge);
        }


        try{
            Person person = new Person(name, personAge);
            System.out.println(person);
        }catch (NegativeAgeException negativeAgeException){
            System.out.println(negativeAgeException.getMessage());
        }


    }
}