package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;
import java.nio.file.Path;

public class Solution  {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        BufferedReader br =null;
        BufferedReader br1 = null;
        try {
          br = new BufferedReader(new InputStreamReader(System.in));

            File file = new File(br.readLine());
           br1 = new BufferedReader(new FileReader(file));

while (br1.ready()){
    String str = br1.readLine();
    if (str.startsWith(args[0] + " ")) {
        System.out.println(str);
        }

    }
}

         finally {
            if (br != null) br.close();
            if (br1 != null) br1.close();
        }
    }
}
