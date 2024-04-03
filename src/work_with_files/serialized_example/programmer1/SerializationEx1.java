package work_with_files.serialized_example.programmer1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializationEx1 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Поля", "RT",
                20, "IT",new Car("Opel")));
        employees.add(new Employee("Оля" , "RT", 20, "IT",new Car("RangeRover")));
        employees.add(new Employee("Коля", "RT", 25, "IT",new Car("BMW")));
        employees.add(new Employee("Толя", "RT", 30, "HR",new Car("Mercedes")));

        try(ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream("employee1.bin")
        )){
            outputStream.writeObject(employees);
            System.out.println("Done");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
