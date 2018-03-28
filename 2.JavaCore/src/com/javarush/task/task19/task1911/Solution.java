package com.javarush.task.task19.task1911;

/* 
Ридер обертка
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ourStream  = new PrintStream(byteArrayOutputStream);
        System.setOut(ourStream);

        testString.printSomething();

        String ourOutput = byteArrayOutputStream.toString().toUpperCase();
        System.setOut(consoleStream);
        System.out.println(ourOutput);


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
