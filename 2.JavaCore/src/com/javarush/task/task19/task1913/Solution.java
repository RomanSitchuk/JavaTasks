package com.javarush.task.task19.task1913;

/* 
Выводим только цифры
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream cons = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream our = new PrintStream(outputStream);
        System.setOut(our);

        testString.printSomething();
        String [] output = outputStream.toString().split("\\D");
        StringBuilder out = new StringBuilder();
        for(String s : output){
            out.append(s);
        }
        System.setOut(cons);

        System.out.println(out);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
