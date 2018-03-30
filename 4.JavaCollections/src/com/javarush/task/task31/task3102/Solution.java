package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* 
Находим все файлы
*/
public class Solution {
    private static List<String> getFileTree(String root) throws IOException {
        List<String> pathList = new ArrayList<>();
        Queue<File> queue = new LinkedList<>();
        queue.add(new File(root));
        while (queue.peek() != null) {
            File directory = queue.remove();
            for (File file : directory.listFiles()) {
                if (file.isDirectory()) {
                    queue.add(file);
                } else {
                    pathList.add(file.getAbsolutePath());
                }
            }


        }
        return pathList;
    }

    public static void main(String[] args) {

        try {
            for(String s : getFileTree("C:/ReadingWriting")){
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
