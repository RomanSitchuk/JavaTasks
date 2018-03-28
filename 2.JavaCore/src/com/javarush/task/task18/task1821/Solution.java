package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String fileName = args[0];
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(args[0]));

        TreeMap <Character, Integer> map = new TreeMap<>();
        while(inputStreamReader.ready()){
              char s = (char) inputStreamReader.read();
              if (map.containsKey(s)) {
                  int x = map.get(s);
                  map.put(s, x+1);
              } else map.put(s, 1);
        }

        inputStreamReader.close();

        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey()+ " " + entry.getValue() );
        }


    }
}
