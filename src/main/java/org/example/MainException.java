package org.example;

import java.util.Scanner;
import java.util.regex.Pattern;

public class MainException {

    private static final Scanner scanner = new Scanner(System.in);
    static Pattern regexName = Pattern.compile("[0-9$&+,:;=\\\\?@#|/'<>.^*()%!-]");

    public static void main(String[] args) {

        String name;
        String inputAge;
        int personAge;
        String repornire;
        boolean restartFlag = true;

        while (restartFlag) {

            System.out.println("Curs infoAcademy = Lectia 8 - Exercitiu 2: \n Sa incepem! \n introduceti numele: ");
            name = scanner.nextLine();

            while (name.isEmpty()) {

                System.out.println("numele introdus e vid, va rugam introuceti o valoare de minim 2 litere. \n" +
                        "Programul nu va continua fara datele corecte");
                if (regexName.matcher(name).find()) {
                    throw new RuntimeException("numele poate poate contine doar litere " +
                            "nu poate contine caractere speciale sau cifre");
                }
                System.out.println("va rugam sa reintroduceti numele: ");
                name = scanner.nextLine();
            }


            System.out.println("introduceti varsta: ");
            inputAge = scanner.nextLine();

            while (inputAge.isEmpty()) {
                System.out.println("varsta introdusa e vida, va rugam introuceti un numar care sa o reprezinte. Si anume un numar pozitiv. \n" +
                        "Programul nu va continua fara datele corecte");
                System.out.println("va rugam sa reintroduceti varsta: ");
                inputAge = scanner.nextLine();
            }
            personAge = Integer.parseInt(inputAge);

            try {
                Person person = new Person(name, personAge);
                System.out.println(person);
                System.out.println("am terminat cu " + person.getName() +  ", vreti sa mai introduceti o persoana? \n" +
                        "tastati 'Y' pt a introduce o alta persoana, sau 'N' pt a iesi \n" +
                        "*****************************************************************************");
            } catch (NegativeAgeException unborn) {
                System.out.println(unborn.getMessage());

            }
            repornire = scanner.nextLine();

            while (repornire.isEmpty()) {
                System.out.println("valorile posibile sunt Y (DA) sau N (nu), valoarea vida va fi ignrata");
                repornire = scanner.nextLine();
            }
            if (repornire.equalsIgnoreCase("y")) {
                System.out.println("ma bucur ca-ti place!");
            }
            if (repornire.equalsIgnoreCase("N")) {
                System.out.println("cu bine!");
                restartFlag = false;
            }
        }
    }
}
