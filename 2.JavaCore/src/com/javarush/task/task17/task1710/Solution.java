package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //while(true) {
            String readed = null;
            try {
                readed = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            String[] inputInformation = readed.split(" ");
            switch (inputInformation[0]) {
                case "-c": {
                    if (inputInformation[2].equals("м")) {
                        Person person = null;
                        try {
                            person = Person.createMale(inputInformation[1], dateFormat.parse(inputInformation[3]));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        allPeople.add(person);
                        System.out.println(allPeople.indexOf(person));
                    } else if (inputInformation[2].equals("ж")) {
                        Person person = null;
                        try {
                            person = Person.createFemale(inputInformation[1], dateFormat.parse(inputInformation[3]));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        allPeople.add(person);
                        System.out.println(allPeople.indexOf(person));
                    }
                }
                break;

                case "-u": {
                    if (inputInformation[3].equals("м")) {
                        Person person = null;
                        try {
                            person = Person.createMale(inputInformation[2], dateFormat.parse(inputInformation[4]));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        allPeople.add(Integer.parseInt(inputInformation[1]), person);

                    } else if (inputInformation[3].equals("ж")) {
                        Person person = null;
                        try {
                            person = Person.createFemale(inputInformation[2], dateFormat.parse(inputInformation[4]));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        allPeople.add(Integer.parseInt(inputInformation[1]), person);

                    }
                }
                break;

                case "-d": {

                    Person person = allPeople.get(Integer.parseInt(inputInformation[1]));
                    person.setName(null);
                    person.setSex(null);
                    person.setBirthDay(null);
                }
                break;

                case "-i": {
                    Person person = allPeople.get(Integer.parseInt(inputInformation[1]));
                   String sex = person.getSex() == Sex.MALE ? "м" : "ж";
                    SimpleDateFormat dateF = new SimpleDateFormat("dd-EEE-yyyy", Locale.ENGLISH);
                    System.out.println(person.getName() +" " + sex + " " +  dateF.format(person.getBirthDay()));
                }
                break;
            }

       // }//start here - начни тут
    }
}
