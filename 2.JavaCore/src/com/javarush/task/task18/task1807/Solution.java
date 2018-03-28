package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        int count = 0;
        FileInputStream fileInputStream = null;
        try {
            fileName = reader.readLine();
            fileInputStream = new FileInputStream(fileName);
            while (fileInputStream.available() > 0){
                 if (fileInputStream.read( ) == ',') {
                     count++;

                 }

            }
            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                reader.close();
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
