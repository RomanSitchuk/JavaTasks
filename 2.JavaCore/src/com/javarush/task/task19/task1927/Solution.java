package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleOut = System.out;
        ByteArrayOutputStream myStream = new ByteArrayOutputStream();
        PrintStream myOutput = new PrintStream(myStream);
        System.setOut(myOutput);
        testString.printSomething();
        String [] splittedOut = myStream.toString().split("\n");
        System.setOut(consoleOut);
        for (int i = 0; i < splittedOut.length; i++){
            System.out.println(splittedOut[i]);
            if (i%2 == 1) {
                System.out.println("JavaRush - курсы Java онлайн");
           }
        }

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
