package org.example;

public class Person {

    private String name;
    private int age;

   //Ctor
    public Person(String name, int age) {
        if(name.length() >= 2){
            this.name = name;
        }else{
            throw new IllegalArgumentException("numele trebuie sa contina minim 2 caractere");
        }
        if(age > 0){
            this.age = age;
        }else{
            throw new NegativeAgeException();
        }
    }

    //get & set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //toString
    @Override
    public String toString() {
        return "Persona introdusa are numele: "  + name + " si varsta de: " + age + " de ani";
    }
}
