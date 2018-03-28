package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.*;

/*
UnsupportedFileName
*/

public class TxtInputStream {



        public static void main(String[] args)
                throws IOException {
            DataInputStream in = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream("TxtInputStream")));
            while(in.available() != 0)
                System.out.print((char)in.readByte());
        }

}

