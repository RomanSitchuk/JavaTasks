package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {

        switch (args[0]){
            case "-e" : encrypt(args[1], args[2]);
            break;
            case "-d" : decrypt(args[1], args[2]);
        }
    }

    private static void encrypt (String inputFile, String outputFile) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(inputFile);
            fos = new FileOutputStream(outputFile);
            byte [] arr = new byte[fis.available()];
            fis.read(arr);
            for(int i = 0; i < arr.length; i++){
                arr[i] ^= "key".getBytes()[0];
            }

            fos.write(arr);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    private static void decrypt (String inputFile, String outputFile) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(inputFile);
            fos = new FileOutputStream(outputFile);
            byte [] arr = new byte[fis.available()];
            fis.read(arr);
            for(int i = 0; i < arr.length; i++){
                arr[i] ^= "key".getBytes()[0];
            }


            fos.write(arr);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
