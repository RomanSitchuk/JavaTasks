package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable{
    public static void main(String[] args) {
        System.out.println(new Solution(4));
        File file = new File("C:\\JavaRushTasks\\2.JavaCore\\src\\file.txt");
        try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(file));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Solution sol = new Solution(5);
            ous.writeObject(sol);
            ous.flush();
            Solution solDeserialized = (Solution) ois.readObject();
            System.out.println("Original object" + sol.string);
            System.out.println("Deserialized object" + solDeserialized.string);
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }


    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient  int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
