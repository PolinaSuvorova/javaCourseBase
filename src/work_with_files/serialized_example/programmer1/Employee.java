package work_with_files.serialized_example.programmer1;

import java.io.Serializable;

// Чтобы Объект мог быть сериализирован и десереализирован нужно указать интерфейс Serializable
public class Employee implements Serializable {
    static final long serialVersionUID = 2; // обозначает версия класса
    private  String name;
    private  String surname;
    private  Integer age;

    // помечаем что поле не передаётся в файл при сериализации
    transient private String  department;

    private Car car;

    public Employee(String name,
                    String surname,
                    Integer age,
                    String department,
                    Car car) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.car = car;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                '}';
    }
}

