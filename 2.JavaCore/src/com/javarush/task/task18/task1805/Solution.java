package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeMap;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        try(BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine())){
            while (fileInputStream.available() > 0){
                Integer key = fileInputStream.read();
                map.put(key, 1);
                }
            } catch (IOException e) {
            e.printStackTrace();
        }

        for (Integer key : map.keySet()){
            System.out.print(key + " ");
        }
        }

    }

