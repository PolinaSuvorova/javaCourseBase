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

        if (!Objects.equals(name, cat.name)) return false;
        if (!Objects.equals(age, cat.age)) return false;
        return Objects.equals(color, cat.color);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 32 * result + (color != null ? color.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Cat o) {
        return this.name.compareTo(o.name);
    }
}
