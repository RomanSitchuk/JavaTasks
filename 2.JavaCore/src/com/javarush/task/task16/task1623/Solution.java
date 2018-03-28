package com.javarush.task.task16.task1623;

/* 
Рекурсивное создание нитей
*/

public class Solution {
    static int count = 15;
    static volatile int countCreatedThreads;

    public static void main(String[] args) {
        System.out.println("callto://" + String.join("","+38(050)123-45-67".split("\\( | \\)|\\-")));

    }

    public static class GenerateThread extends Thread{
       // countCreatedThreads = 1;
        public  GenerateThread (){
            super(String.valueOf(++countCreatedThreads));
            start();
        }

        @Override
        public void run() {
            if (countCreatedThreads < count){
                GenerateThread thread = new GenerateThread();
                System.out.println(thread);
            }
        }

        @Override
        public String toString() {
            return getName() + " created";
        }
    }
}
