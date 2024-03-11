package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearchExample {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-3);
        list.add(-9);
        list.add(10);
        list.add(5);
        list.add(15);
        list.add(25);
        list.add(-8);
        int index1 = Collections.binarySearch(list, -8);
        System.out.println(index1);
        Collections.sort(list);
        index1 = Collections.binarySearch(list, -8);
        System.out.println(index1);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);

        List<Employee11> emps = new ArrayList<>();
        Employee11 emp1 = new Employee11(10, "Polina", "XYZ", 1000);
        Employee11 emp2 = new Employee11(9, "ina", "Z", 1500);
        Employee11 emp3 = new Employee11(1, "Sasha", "Ivanov", 2500);
        emps.add(emp1);
        emps.add(emp2);
        emps.add(emp3);
        System.out.println("----List Employee BEFORE sorting");
        System.out.println(emps);
        Collections.sort(emps);

        int ind2 = Collections.binarySearch(emps, new Employee11(9, "ina", "Z", 1500));
        System.out.println(ind2);

        int[] array = {1, 20, -3, 4, -5, 2};
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        ind2 = Arrays.binarySearch(array, 20);
        System.out.println(ind2);
    }
}


class Employee11 implements Comparable<Employee11> {
    private Integer id;
    private String name;
    private String surname;
    private int salary;

    public Employee11(int id, String name, String surname, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee11{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public int compareTo(Employee11 o) {
        int res = this.name.compareTo(o.getName());
        if (res == 0) {
            res = this.surname.compareTo(o.getSurname());
        }
        return res;
    }
}
