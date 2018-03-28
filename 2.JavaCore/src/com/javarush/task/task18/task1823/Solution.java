package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        int i = 0;

        while ( !(s = br.readLine()).equals("exit")){
            ReadThread rh = new ReadThread(s);
            rh.start();
        }


    }

    public static class ReadThread extends Thread {
        private String fileName;
        private  int findedByte;
        public ReadThread(String fileName) {
           this.fileName = fileName;//implement constructor body
        }

        @Override
        public void run() {
            HashMap<Integer, Integer> map = new HashMap<>();
            int maxCount = 0;


            try ( FileInputStream fis = new FileInputStream(fileName)) {
               int k = 0;
                while ((k = fis.read() ) != -1) {
                    if (map.containsKey(k)){
                        map.put(k, map.get(k) + 1);
                    } else map.put(k, 1);
                }
            } catch ( IOException e) {
                e.printStackTrace();
            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet()){
                if (entry.getValue() > maxCount) {
                    maxCount = entry.getValue();
                findedByte =  entry.getKey();
                }
            }

            synchronized (resultMap){resultMap.put(fileName, findedByte);}
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
