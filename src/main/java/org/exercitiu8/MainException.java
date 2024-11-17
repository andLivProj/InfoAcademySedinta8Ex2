package org.exercitiu8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MainException {

    private static final Scanner scanner = new Scanner(System.in);
    static Pattern regexName = Pattern.compile("[0-9$&+,:;=\\\\?@#|/'<>.^*()%!-]");
    static List<Person> recensamant = new ArrayList<>();

    public static void main(String[] args) {

        String name;
        String inputAge;
        int personAge;
        String repornire;
        boolean restartFlag = true;

        System.out.println("Curs infoAcademy = Lectia 8 - Exercitiu 2: \n Sa incepem! ");

        while (restartFlag) {

            //initiem dialogul
            System.out.println("introduceti numele: ");
            name = scanner.nextLine();

            //prevalidarea numelui
            while (name.isEmpty()) {
                System.out.println("numele introdus e vid, va rugam introuceti o valoare de minim 2 litere. \n" +
                        "Programul nu va continua fara datele corecte");
                System.out.println("va rugam sa reintroduceti numele: ");
                name = scanner.nextLine();
            }
            while(!name.isEmpty()){
                if (regexName.matcher(name).find()) {
                    System.out.println("numele normale pot contine doar litere! " +
                            "valoarea introdusa nu poate contine caractere speciale sau cifre");
                    System.out.println("va rugam sa reintroduceti numele: ");
                    name = scanner.nextLine();
                }else{
                    break;
                }
            }
            //prevalidatea varstei
            System.out.println("introduceti varsta: ");
            inputAge = scanner.nextLine();

            while (inputAge.isEmpty()) {
                System.out.println("varsta introdusa e vida, va rugam introuceti un numar care sa o reprezinte. Si anume un numar pozitiv. \n" +
                        "Programul nu va continua fara datele corecte");
                System.out.println("va rugam sa reintroduceti varsta: ");
                inputAge = scanner.nextLine();
            }
            personAge = Integer.parseInt(inputAge);

            //Incercam sa populam clasa persoana cu datele preluate de la utilizator
            try {
                Person person = new Person(name, personAge);
                System.out.println("am terminat cu " + person.getName() +  ", vreti sa mai introduceti o persoana? \n" +
                        "***************************************************************************** \n" +
                        "tastati 'Y' pt a introduce o alta persoana, sau 'N' pt a iesi \n" +
                        "*****************************************************************************");
                recensamant.add(person);
            } catch (NegativeAgeException unborn) {
                throw new NegativeAgeException();

            }
            //Daca totul e OK repornim bucla
            repornire = scanner.nextLine();

            while (repornire.isEmpty()) {
                System.out.println("valorile posibile sunt Y (DA) sau N (nu), valoarea vida va fi ignrata");
                repornire = scanner.nextLine();
            }
            while (!repornire.isEmpty() && !repornire.equalsIgnoreCase("Y") && !repornire.equalsIgnoreCase("N")) {
                System.out.println("valorile posibile sunt Y (DA) sau N (nu), vezi ca ai scris: " + repornire);
                repornire = scanner.nextLine();
            }
            if (repornire.equalsIgnoreCase("y")) {
                System.out.println("ma bucur ca-ti place!");
            }else if (repornire.equalsIgnoreCase("N")) {
                System.out.println("ai reusit sa ii adaugi pe cei de mai jos, in total: " +recensamant.size());
                recensamant.forEach(System.out::println);
                System.out.println("cu bine!");
                restartFlag = false;
            }
        }
    }
}
