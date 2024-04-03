package work_with_files;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

// Буфер это блок памяти, который имеет определенный размер (capacity)
public class ChannelBufferExample1 {
    public static void main(String[] args) throws IOException {
        try (
                RandomAccessFile file = new RandomAccessFile("test10.txt", "rw");
                FileChannel channel = file.getChannel();) {
            // Буфер может быть заполнен на 10 байт
            ByteBuffer buffer = ByteBuffer.allocate(10);
            StringBuilder string = new StringBuilder();
            int byteRead;
            // Читаем из файла и записываем в буффер
            while ((byteRead = channel.read(buffer)) > 0) {
                System.out.println("Read " + byteRead);

                // меняет режим буфера из режима записи в режим чтения
                // позиция из режима записи меняется на режим чтения
                // и ставит позицию для чтения на 0 значения
                buffer.flip();

                // Чиатем по 1 байту за раз
                while (buffer.hasRemaining()) {
                    string.append((char) buffer.get());
                }

                //меняет позицию с какой либо на 0 (ничего не очищаем),
                // далее при записи новой инфы старая просто затирается
                // если вдруг есть элементы которые мы не прочитали, то мы их никогда уже не прочтём
                // к текущему циклу это не относится
                buffer.clear();
            }
            System.out.println(string);
            String text = "\n newString jjn";

            // 1 способ записи в файл
            // Создаём буфер сразу размером под текстовую сроку
            ByteBuffer buffer2 = ByteBuffer.allocate(text.getBytes().length);
            // Заполнили буфер, позиция указывает на конец
            buffer2.put(text.getBytes());
            // Перескокунли вначло буфера
            buffer2.flip();
            channel.write(buffer2);

            // 2 способ записи в файл (wrap делает allocate put flip)
            ByteBuffer buffer3 = ByteBuffer.wrap(text.getBytes());
            // записываем в открытый канал, а из него в файл
            channel.write(buffer3);
        }
    }
}
