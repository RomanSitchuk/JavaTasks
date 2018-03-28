package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
            FileInputStream fileInputStream = new FileInputStream(reader.readLine());
            FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine())){
            byte [] array = new byte[fileInputStream.available()];
            byte [] reverseArray = new byte[fileInputStream.available()];

            if (fileInputStream.available() > 0){
                Integer key = fileInputStream.read(array);
                int index = 0;
                for (int i = reverseArray.length-1 ; i >= 0; i--){

                        reverseArray[i] = array[index];
                        index++;

                }
                fileOutputStream.write(reverseArray, 0, array.length);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
