package work_with_files;

import java.io.*;

public class DataStreamsExample {
    public static void main(String[] args) {
        try(
                DataInputStream inputStream = new DataInputStream(
                        new FileInputStream("myTest.bin"));
                DataOutputStream outputStream = new DataOutputStream(
                        new FileOutputStream("myTest.bin"))){
            outputStream.writeBoolean(true);
            outputStream.write(5);
            outputStream.writeChar('Y');
            outputStream.writeShort(120);
            outputStream.writeByte(5);
            outputStream.writeLong(1_000_000_000L);

            System.out.println(inputStream.readBoolean());
            System.out.println(inputStream.read());
            System.out.println(inputStream.readChar());
            System.out.println(inputStream.readLong());

            System.out.println("Done");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
