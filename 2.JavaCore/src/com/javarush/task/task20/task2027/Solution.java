package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        System.out.println(detectAllWords(crossword, "home", "same"));
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    private static Word checkAboveLeft(int[][] crossword, int StartX, int StartY, String word){
        int x = StartX - 1;
        int y = StartY - 1;

       for (int i = 1; i < word.length(); i++){
           if (x < 0 || y < 0 ) return null;
           if ((char)crossword[y][x] != word.charAt(i)) {
              return null;

           }
           x--;
           y--;

       }
        Word finded = new Word(word);
        finded.setStartPoint(StartX,StartY);
        finded.setEndPoint(x+1, y+1);
        return finded;
    }
    private static Word checkBelowLeft(int[][] crossword, int StartX, int StartY, String word){
        int x = StartX - 1;
        int y = StartY + 1;
          for (int i = 1; i < word.length(); i++){
            if (x < 0 || y > crossword.length-1 ) return null;
            if ((char)crossword[y][x] != word.charAt(i)) {
                return null;

            }
            x--;
            y++;
        }
        Word finded = new Word(word);
        finded.setStartPoint(StartX,StartY);
        finded.setEndPoint(x+1, y-1);
        return finded;

    }

    private static Word checkBelowRight(int[][] crossword, int StartX, int StartY, String word){
        int x = StartX + 1;
        int y = StartY + 1;

        for (int i = 1; i < word.length(); i++){
            if (x > crossword[StartY].length -1 || y > crossword.length -1 ) return null;
            if ((char)crossword[y][x] != word.charAt(i)) {
                return  null;

            }
            x++;
            y++;
        }
        Word finded = new Word(word);
        finded.setStartPoint(StartX,StartY);
        finded.setEndPoint(x-1, y-1);
        return finded;

    }

    private static Word checkAboveRight(int[][] crossword, int StartX, int StartY, String word){
        int x = StartX - 1;
        int y = StartY + 1;
                for (int i = 1; i < word.length(); i++){
            if (y > (crossword[StartY].length - 1) || x < 0 ) return null;
            if ((char)crossword[y][x] != word.charAt(i)) {
                return  null;

            }
                x--;
                y++;
            }

        Word finded = new Word(word);
        finded.setStartPoint(StartX,StartY);
        finded.setEndPoint(x+1, y-1);
        return finded;
    }

    private static Word checkLeft(int[][] crossword, int StartX, int StartY, String word){
        int x = StartX - 1;
        int y = StartY;

        for (int i = 1; i < word.length(); i++){
            if (x < 0  ) return null;
            if ((char)crossword[y][x] != word.charAt(i)) {
              return null;


            }
            x--;
        }

        Word finded = new Word(word);
        finded.setStartPoint(StartX,StartY);
        finded.setEndPoint(x+1, y);
        return finded;
    }

    private static Word checkRight(int[][] crossword, int StartX, int StartY, String word){
        int x = StartX + 1;
        int y = StartY ;

        for (int i = 1; i < word.length(); i++){
            if (x > crossword[StartY].length -1 ) return null;
            if ((char)crossword[y][x] != word.charAt(i)) {
                return null;
                   }
            x++;
        }

        Word finded = new Word(word);
        finded.setStartPoint(StartX,StartY);
        finded.setEndPoint(x-1, y);
        return finded;
    }

    private static Word checkBelow(int[][] crossword, int StartX, int StartY, String word){
        int x = StartX;
        int y = StartY + 1;

        for (int i = 1; i < word.length(); i++){
            if ( y > crossword.length -1) return null;
            if ((char)crossword[y][x] != word.charAt(i)) {
                return null;
            }

                y++;

        }

        Word finded = new Word(word);
        finded.setStartPoint(StartX,StartY);
        finded.setEndPoint(x, y-1);
        return finded;
    }
    private static Word checkAbove(int[][] crossword, int StartX, int StartY, String word){
        int x = StartX ;
        int y = StartY - 1;

        for (int i = 1; i < word.length(); i++){
            if (y < 0) return null;
            if ((char)crossword[y][x] != word.charAt(i)) {
                return null;
            }

                y--;

        }

        Word finded = new Word(word);
        finded.setStartPoint(StartX,StartY);
        finded.setEndPoint(x, y+1);
        return finded;
    }
    public static List<Word> detectAllWords(int[][] crossword, String... words) {
           List <Word> list = new ArrayList<>();
           for (String word: words){
               for (int i = 0; i < crossword.length; i++){
                   for (int j = 0; j < crossword[i].length; j++){
                       if ((char)crossword[i][j] == word.charAt(0) ){
                           int StartX = j;
                           int StartY = i;
                           Word [] vector = new Word[8];
                           vector[0] = checkAbove(crossword, StartX, StartY, word);
                           vector[1] = checkBelow(crossword, StartX, StartY, word);
                           vector[2] = checkAboveLeft(crossword, StartX, StartY, word);
                           vector[3] = checkAboveRight(crossword, StartX, StartY, word);
                           vector[4] = checkBelowLeft(crossword, StartX, StartY, word);
                           vector[5] = checkBelowRight(crossword, StartX, StartY, word);
                           vector[6] = checkLeft(crossword, StartX, StartY, word);
                           vector[7] = checkRight(crossword, StartX, StartY, word);
                          for (int k = 0; k < vector.length; k++){
                              if (vector[k]!= null){
                                  list.add(vector[k]);
                              }
                          }
                       }
                   }
               }
           }
        return list;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
