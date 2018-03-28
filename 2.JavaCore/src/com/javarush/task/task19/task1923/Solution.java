package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/
import java.io.*;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter printWriter = new BufferedWriter(new FileWriter(args[1]));

        while (fileReader.ready()){
            String line =fileReader.readLine();
            String[] words = line.split(" ");
            for (String word : words)
                if (Pattern.compile("\\d+").matcher(word).find())
                    printWriter.write(word + " ");
        }
        fileReader.close();
        printWriter.close();
    }
}