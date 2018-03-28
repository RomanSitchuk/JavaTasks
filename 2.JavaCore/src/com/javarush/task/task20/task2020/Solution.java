package com.javarush.task.task20.task2020;

import java.io.*;
import java.util.logging.Logger;

/* 
Сериализация человека
*/
public class Solution {

    public static class Person implements Serializable{
        String firstName;
        String lastName;
        transient String fullName;
       transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient  Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) {
        Person person = new Person("Sitchuk", "Roman", "Ukraine", Sex.MALE );
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try (ObjectOutputStream ous = new ObjectOutputStream(output)) {
            ous.writeObject(person);
            ous.flush();
        } catch ( IOException e){
            e.printStackTrace();
        }
        ByteArrayInputStream input = new ByteArrayInputStream(output.toByteArray());
        try (ObjectInputStream ois = new ObjectInputStream(input)) {

            try {
                Person peson = (Person) ois.readObject();
                System.out.println(peson);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e){
            e.printStackTrace();
        }




    }
}
