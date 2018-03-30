package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.BufferOverflowException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Проход по дереву файлов
*/
public class Solution {
   private static ArrayList<File> list = new ArrayList<>();
    public static void main(String[] args) {




        File directory = new File(args[0]);
        File resultFileAbsolute = new File(args[1]);
        File allFilesContent = new File(resultFileAbsolute.getParent()+"/allFilesContent.txt");




            if (!FileUtils.isExist(allFilesContent)) {
                FileUtils.renameFile(resultFileAbsolute, allFilesContent );

            }



            try (
                 BufferedWriter writer = new BufferedWriter(new FileWriter(allFilesContent))
            ) {
                  listOfFiles(directory.getPath());
                list.sort(new FileComparator());
                 for (File file: list){
                     BufferedReader reader = new BufferedReader(new FileReader(file));
                while (reader.ready()) {
                    writer.write(reader.readLine());

                }
                writer.write("\n");
                writer.flush();
                reader.close();
            }
     }catch (IOException e){
                e.printStackTrace();
            }



    }

    private static void listOfFiles(String path){
        File [] files = new File(path).listFiles();
        for (File file : files){
            if (file.isDirectory()){
                listOfFiles(file.getPath());
                continue;
            }
            if (file.length() > 50) FileUtils.deleteFile(file);
            else {
                       list.add(file);
            }
        }
    }

    private static class FileComparator implements Comparator<File>{
        @Override
        public int compare(File o1, File o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

}
