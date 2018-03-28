package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        String fileName = args[0];
        TreeMap<String, Double> map = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while(reader.ready()){
                String [] inLine = reader.readLine().split(" ");
                String name = inLine[0];
                Double value = Double.parseDouble(inLine[1]);
                if (map.containsKey(name)){
                    map.put(name, map.get(name) + value);
                } else map.put(name, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Map.Entry<String, Double> entry: map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
