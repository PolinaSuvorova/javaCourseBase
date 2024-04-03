package work_with_files;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelBufferExample2 {
    public static void main(String[] args) throws IOException {
        try (
                RandomAccessFile file = new RandomAccessFile("text5.txt", "r");
                FileChannel channel = file.getChannel();) {
            // Буфер может быть заполнен на 10 байт
            ByteBuffer buffer = ByteBuffer.allocate(5);
            // читаем данные из канала в буфер
            channel.read(buffer); // читаем a b c
            buffer.flip();
            System.out.println("buffer.get() " + (char) buffer.get()); //a
            System.out.println("buffer.get() " + (char) buffer.get());//b
            System.out.println("buffer.get() " + (char) buffer.get());//c

            // переместим позицию для чтения на 0 ячейку
            System.out.println("rewind " );
            buffer.rewind();
            System.out.println("buffer.get() " + (char) buffer.get());//a
            System.out.println("---------------------");

            System.out.println("compact " );
            // compact - копирует непрочитаные элменты копируются вначало буфера
            // позиция будет указывать на следующий байт после непроитаных
            buffer.compact();// перемещаем непрочитанные данные вначало спискаси устанавливаем позицию за ним
            channel.read(buffer);// читаем d e f
            buffer.flip();// переходим опять вначало буфера
            while (buffer.hasRemaining()){
                System.out.println((char) buffer.get());//a
            }

            System.out.println("---------------------");
            // переходим вначало буфера и забываем о наличии других элментов
            buffer.clear();
            channel.read(buffer); // читаем g h i
            buffer.flip(); // переходим вначало буфера
            System.out.println((char) buffer.get());//g
            buffer.mark(); // ставим метку на h чтобы потом вернуться
            System.out.println("mark()");
            System.out.println((char) buffer.get());//h
            System.out.println((char) buffer.get());//i
            buffer.reset(); // возравщаемся с позиции j на позицию метку h
            System.out.println("reset()");
            System.out.println((char) buffer.get());//h
            System.out.println((char) buffer.get());//i
            System.out.println((char) buffer.get());//j
        }
    }
}
