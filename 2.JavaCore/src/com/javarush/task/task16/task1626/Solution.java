package com.javarush.task.task16.task1626;

public class Solution {
    public static int number = 5;

    public static void main(String[] args) {
        new Thread(new CountDownRunnable(), "Уменьшаем").start();

        new Thread(new CountUpRunnable(), "Увеличиваем").start();
    }

    public static class CountUpRunnable implements Runnable {
        private int countIndexUp = 0;

        public void run() {
            try {
                while (countIndexUp != Solution.number) {
                    countIndexUp += 1;
                    System.out.println(toString());
                    Thread.sleep(500);


                }
            } catch (InterruptedException e) {
            }

        }

        public String toString() {
            return  Thread.currentThread().getName() + ": " + countIndexUp ;
        }//Add your code here - добавь код тут
    }


    public static class CountDownRunnable implements Runnable {
        private int countIndexDown = Solution.number;

        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    Thread.sleep(500);
                    countIndexDown -= 1;
                    if (countIndexDown == 0) return;

                }
            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexDown;
        }
    }
}
