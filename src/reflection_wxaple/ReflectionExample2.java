package reflection_wxaple;

import work_with_files.serialized_example.programmer1.Car;
import work_with_files.serialized_example.programmer1.Employee;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionExample2 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class employeeClass = Class.forName("work_with_files.serialized_example.programmer1.Employee");

        Constructor<Employee> constructor2 = employeeClass.getConstructor(
                String.class,String.class,Integer.class,String.class, Car.class );
        Employee o2 = constructor2.newInstance("Оля", "RT", 20, "IT", new Car("RangeRover"));

        System.out.println(o2);
        Method method = employeeClass.getMethod("setAge", Integer.class);
        method.invoke(o2,99);
        System.out.println(o2);
    }
}
