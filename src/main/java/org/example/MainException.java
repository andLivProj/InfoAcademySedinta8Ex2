package org.example;

import java.util.Scanner;

public class MainException {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("introduceti numele: ");
        String name = scanner.nextLine();
        System.out.println("introduceti varsta: ");
        int age = scanner.nextInt();

        Person person = new Person(name, age);
        System.out.println(person);
    }
}