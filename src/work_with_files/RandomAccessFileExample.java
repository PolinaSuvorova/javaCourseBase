package work_with_files;

import java.io.*;

public class RandomAccessFileExample {
    public static void main(String[] args) {
        try(
                RandomAccessFile file = new RandomAccessFile( "test10.txt","rw")){
            // Чиатет по 1 байту и двигается курсор
            int a = file.read();
            System.out.println((char) a);
            // Чиатет строку со смещение
            String s1 = file.readLine();
            System.out.println(s1);
            // Устанавливаем поинтер на 10 байте
            file.seek(10);
            s1 = file.readLine();
            System.out.println(s1);
            long pos = file.getFilePointer();
            System.out.println(pos);

            file.seek(0);
            file.writeBytes("NewStr"); // перепишет первые символы

            file.seek(file.length() - 1);
            file.writeBytes("NewStr2");

            System.out.println("Done");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
