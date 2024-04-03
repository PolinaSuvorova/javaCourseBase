package work_with_files.serialized_example.programmer2;

import work_with_files.serialized_example.programmer1.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializationEx2{
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        try(ObjectInputStream intputStream = new ObjectInputStream(
                new FileInputStream("employee1.bin")
        )){
            employees = (ArrayList) intputStream.readObject();
            System.out.println(employees);
            System.out.println("Done");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

