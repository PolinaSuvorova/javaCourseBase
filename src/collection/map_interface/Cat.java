package collection.map_interface;

import java.util.Objects;

public class Cat implements Comparable<Cat>{
    final String name;
    final Integer age;
    final String color;

    public Cat(String name, Integer age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cat cat = (Cat) o;
        return Objects.equals(name, cat.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public int compareTo(Cat o) {
        return this.name.compareTo(o.name);
    }
}
