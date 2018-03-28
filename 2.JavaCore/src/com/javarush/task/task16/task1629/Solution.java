package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();

        t1.start();
        t1.join();
        t2.start();
        t2.join();//add your code here - добавьте код тут

        t1.printResult();
        t2.printResult();
    //    t1.interrupt();
       // t2.interrupt();
    }

    public static class Read3Strings extends Thread{
        public ArrayList<String> list= new ArrayList<>();

        public void run () {
           // while(!isInterrupted()){
                try {

                        for (int i = 0; i < 3; i++ ){
                          //  if (reader.ready()){
                            list.add(reader.readLine());
                       // }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
           // }
        }
        public void printResult(){
           for (String s : list){
               System.out.print(s+ " ");
           }
        }
    } //add your code here - добавьте код тут
}
