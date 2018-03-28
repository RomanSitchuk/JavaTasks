package com.javarush.task.task20.task2015;

import java.io.*;

/* 
Переопределение сериализации
*/
public class Solution implements Serializable, Runnable{
    private transient Thread runner;
    private int speed;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        int k = 0;
        while ( k < 10) {
            System.out.println("inside run");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            k++;
        }// do something here, does not matter
    }

    /**
     Переопределяем сериализацию.
     Для этого необходимо объявить методы:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        System.out.println("Deserialization");
        Thread run = new Thread(this);
        run.start();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
          Solution sol = new Solution(5);
          File file = new File ("C:\\JavaRushTasks\\2.JavaCore\\src\\file.txt");
          ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
          ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
          out.writeObject(sol);
          out.flush();
          Solution sol1 = (Solution) ois.readObject();
    }
}
