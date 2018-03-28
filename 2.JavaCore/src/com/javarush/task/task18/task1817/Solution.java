package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        int allCount = 0;
        int emptySpaceCount = 0;
        try (FileInputStream fis = new FileInputStream(args[0])) {

            while (fis.available() > 0){
                int k = fis.read();
                allCount++;
                if (k == Integer.valueOf(' ')) emptySpaceCount++;
            }
            float div = ((float) emptySpaceCount/allCount )* 100;
            System.out.printf("%.2f", div);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    }

