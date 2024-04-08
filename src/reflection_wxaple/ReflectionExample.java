package reflection_wxaple;

import work_with_files.serialized_example.programmer1.Car;
import work_with_files.serialized_example.programmer1.Employee;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ReflectionExample {
    public static void main(String[] args) throws ClassNotFoundException {
        Class employeeClass = Class.forName("work_with_files.serialized_example.programmer1.Employee");
        Class employeeClass2 = Employee.class;
        Employee emp = new Employee("Оля", "RT", 20, "IT", new Car("RangeRover"));
        Class employeeClass3 = emp.getClass();

        try {

            Field field = employeeClass.getDeclaredField("name"); // employeeClass.getField("name");// Public поля
            System.out.println("Type of field " + field.getName() + " = " + field.getType());

            Field[] fields = employeeClass.getDeclaredFields();//  employeeClass.getFields();
            for (Field field2 : fields) {
                System.out.println("Type of field " + field2.getName() + " = " + field2.getType());
            }
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }


        Method[] methods = employeeClass.getDeclaredMethods();//employeeClass.getMethods();
        for (Method method : methods) {
            System.out.println("method.getName() " + method.getName() + " Params " + method.getReturnType() + " " + Arrays.toString(method.getParameterTypes()));
        }
        System.out.println("***************");
        for (Method method : methods) {
            if (Modifier.isPublic(method.getModifiers())) {
                System.out.println("method.getName() " + method.getName() + " Params " + method.getReturnType() + " " + Arrays.toString(method.getParameterTypes()));
            }
        }

        Constructor[] constructors = employeeClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("Constructor has " + constructor.getParameterCount());
        }
    }
}
