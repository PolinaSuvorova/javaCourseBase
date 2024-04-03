package work_with_files.serialized_example.programmer1;

import java.io.Serializable;

public class Car implements Serializable {
    String name;

    public Car(String name) {
        this.name = name;
    }
}
