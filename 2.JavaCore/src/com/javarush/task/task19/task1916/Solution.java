package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {

        try (BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));) {
            String file1 = reader.readLine();
            String file2 = reader.readLine();
            compareUpdate(file1, file2, lines);
        } catch (IOException e){
            e.printStackTrace();
        }
        for (LineItem item : lines) {
           System.out.println(item.line + " " + item.type.name());
        }
    }

    public static void compareUpdate(String fileName1, String fileName2, List<LineItem> list)  throws IOException {

        List<String> original = new ArrayList<>();
        List<String> modified = new ArrayList<>();
        BufferedReader file1 = new BufferedReader(new FileReader(fileName1));
        BufferedReader file2 = new BufferedReader(new FileReader(fileName2));

        while (file1.ready()){
            original.add(file1.readLine());
        }

        while (file2.ready()){
            modified.add(file2.readLine());
        }
        file1.close();
        file2.close();



        while (original.size() != 0 & modified.size() != 0 ) {
           if (original.get(0).equals(modified.get(0))) {
               lines.add(new LineItem(Type.SAME, original.remove(0)));
               modified.remove(0);
           } else if (modified.size()!=1 && original.get(0).equals(modified.get(1))){
               lines.add(new LineItem(Type.ADDED, modified.remove(0)));
           } else if (original.size()!=1 && original.get(1).equals(modified.get(0))){
               lines.add(new LineItem(Type.REMOVED, original.remove(0)));
           }
        }

        if (original.size() == 1 && modified.size() ==0 ) {
            lines.add(new LineItem(Type.REMOVED, original.remove(0)));
        } else if  (original.size() == 0 && modified.size() == 1 ){
            lines.add(new LineItem(Type.ADDED, modified.remove(0)));
        }

       /* for (int i = 0; i < listFile1.size() ; i++){
            if (listFile1.get(i).equals(listFile2.get(i))){
                list.add(new LineItem(Type.SAME, listFile1.get(i)));

            } else if (!listFile1.get(i).equals(listFile2.get(i)) && listFile1.size()< listFile2.size()){
               if (listFile1.get(i).equals(listFile2.get(i+1))){
                list.add(new LineItem(Type.ADDED, listFile2.get(i)));
                listFile2.remove(i);
               }
            } else if (!listFile1.get(i).equals(listFile2.get(i)) && !listFile1.get(i).equals(listFile2.get(i+1))){
                list.add ( new LineItem(Type.REMOVED, listFile1.get(i)));
                listFile2.add(0, null);
            }
        }*/
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
