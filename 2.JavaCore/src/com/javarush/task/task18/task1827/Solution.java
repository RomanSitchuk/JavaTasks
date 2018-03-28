package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        if (args.length == 0 || !args[0].equals("-c")) return;

          // local variable declaring
        String fileName = null;
        String productName;
        String quantity;
        String price;
        ArrayList<String> list;
        BufferedReader fr = null;
        Pattern p;
        int maxID;
        Integer idParsed;

        //reading a file
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
             } catch (IOException e) {
            e.printStackTrace();
        }

        // checking whether productName consists from two or more words
       if (args.length > 4) {
            StringBuilder sb = new StringBuilder(args[1]);
            for (int i = 2; i < args.length - 2; i++) {
                sb.append(" ");
                sb.append(args[i]);
            }
            productName = sb.toString();
        } else productName = args [1];

        price = args[args.length-2];
        quantity = args [args.length - 1];

        //reading lines from file
        list = new ArrayList<>();
        try {
            fr = new BufferedReader(new FileReader(fileName));
            while(fr.ready())
            {
                list.add(fr.readLine());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        if (fr != null) {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }

        //Get ID from line
        p = Pattern.compile("([0-9]{1,8})");
        maxID = 0;
        for (String s : list) {
            Matcher m = p.matcher(s);
            if (m.lookingAt()) {
                try {
                    //System.out.println(s.substring(m.start(), m.end()));
                    int id = Integer.parseInt(s.substring(m.start(), m.end()));
                    if (id > maxID)
                        maxID = id;
                } catch (NumberFormatException e) {
                    continue;
                }
            }
        }

        if (maxID++ == 99999999)
            return;

        //and FINALLY, here is writing new line to file
        BufferedWriter bw = null;
        String toFile = String.format(Locale.ROOT, "%-8d%-30s%-8s%-4s",maxID,productName,price,quantity );
        try {
            bw = new BufferedWriter(new FileWriter(fileName, true));
            bw.newLine();
            bw.write(toFile);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //sb.append();

        }

}
