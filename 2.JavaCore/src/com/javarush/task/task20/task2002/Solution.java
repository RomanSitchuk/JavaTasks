package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss:SSS");
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("file", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);


            JavaRush javaRush = new JavaRush();
            User user = new User();
            user.setFirstName("Roman");
            user.setLastName("Sitchuk");
            user.setMale(true);
            user.setBirthDate(dateFormat.parse("07-11-1991 12:42:30:999"));
            user.setCountry(User.Country.UKRAINE);
            javaRush.users.add(user);//initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            System.out.println(javaRush.equals(loadedObject));//check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

            if (users.size() > 0) {
                for(User user : users){
                    writer.write(user.getFirstName()+"\n");
                    writer.write(user.getLastName()+"\n");
                    writer.write(dateFormat.format(user.getBirthDate()).toString()+"\n");
                    writer.write(String.valueOf(user.isMale())+"\n");
                    writer.write(user.getCountry().toString()+"\n");
                    writer.flush();//implement this method - реализуйте этот метод
                }
                //writer.close();
            }
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            while (reader.ready()){
                User user = new User();
                user.setFirstName(reader.readLine());
                user.setLastName(reader.readLine());
                user.setBirthDate(dateFormat.parse(reader.readLine()));
                user.setMale(Boolean.valueOf(reader.readLine()));
                user.setCountry(User.Country.valueOf(reader.readLine()));
                users.add(user);//implement this method - реализуйте этот метод
            }
           // reader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
