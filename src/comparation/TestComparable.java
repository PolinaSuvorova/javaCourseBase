package comparation;

import java.util.*;

public class TestComparable {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Str1");
        list.add("Str0");
        list.add("AText");
        System.out.println("----List BEFORE sorting");
        System.out.println(list);
        Collections.sort(list);
        System.out.println("----List AFTER sorting");
        System.out.println(list);
        System.out.println("---------------------------------------------");

        List<Employee> emps = new ArrayList<>();
        Employee emp1 = new Employee(10, "Polina", "XYZ", 1000);
        Employee emp2 = new Employee(9, "ina", "Z", 1500);
        Employee emp3 = new Employee(1, "Sasha", "Ivanov", 2500);
        emps.add(emp1); emps.add(emp2); emps.add(emp3);
        System.out.println("----List Employee BEFORE sorting");
        System.out.println(emps);
        Collections.sort(emps);
        System.out.println("----List Employee AFTER sorting");
        System.out.println(emps);
        System.out.println("---------------------------------------------");
    }
}

class Employee implements Comparable<Employee>{
    private Integer id;
    private String name;
    private String surname;
    private int salary;

    public Employee(int id, String name, String surname, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
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
    public int compareTo(Employee o) {
//        if (o.getId() == this.id){
//            return 0;
//        } else if (this.id <= o.getId() ) {
//            return -1;
//        }
//        return 1;
//        return this.id -  o.getId();
//        return this.id.compareTo(o.getId());
        int res  = this.name.compareTo(o.getName());
        if ( res == 0){
            res = this.surname.compareTo(o.getSurname());
        }
        return res;
    }
}
