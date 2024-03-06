package comparation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestComparator {
    public static void main(String[] args) {
        List<EmployeeTest> emps = new ArrayList<>();
        EmployeeTest emp1 = new EmployeeTest(10, "Polina", "XYZ", 1000);
        EmployeeTest emp2 = new EmployeeTest(9, "ina", "Z", 1500);
        EmployeeTest emp3 = new EmployeeTest(1, "Sasha", "Ivanov", 2500);
        emps.add(emp1);
        emps.add(emp2);
        emps.add(emp3);
        System.out.println("----List Employee BEFORE sorting");
        System.out.println(emps);
        emps.sort(new NameComparator());
        System.out.println("----List Employee AFTER sorting");
        System.out.println(emps);
        System.out.println("---------------------------------------------");
    }
}

class EmployeeTest implements Comparable<Employee> {
    private Integer id;
    private String name;
    private String surname;
    private int salary;

    public EmployeeTest(int id, String name, String surname, int salary) {
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

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public int compareTo(Employee o) {
        return this.id.compareTo(o.getId());
    }
}

class IdComparator implements Comparator<EmployeeTest> {

    @Override
    public int compare(EmployeeTest o1, EmployeeTest o2) {
        if (o1.getId().equals( o2.getId())) {
            return 0;
        } else if (o1.getId() <= o2.getId()) {
            return -1;
        }
        return 1;
    }
}

class NameComparator implements Comparator<EmployeeTest> {

    @Override
    public int compare(EmployeeTest o1, EmployeeTest o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class SalaryComparator implements Comparator<EmployeeTest> {

    @Override
    public int compare(EmployeeTest o1, EmployeeTest o2) {
        return o1.getSalary() - o2.getSalary();
    }
}
