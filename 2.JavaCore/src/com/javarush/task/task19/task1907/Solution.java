package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String fileName = null;
        int count = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            fileName =  br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader fr = new BufferedReader(new FileReader(fileName))) {

            while(fr.ready()) {
               String[] words = fr.readLine().split("\\W");
               for (String word : words){
                   if( word.equals("world")) count++;
               }
            }
        } catch (FileNotFoundException e){

        } catch (IOException e){

        }
        System.out.println(count);
    }
}
