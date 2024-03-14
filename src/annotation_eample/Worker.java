package annotation_eample;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


public class Worker {
    String name;
    Integer salary;

    public Worker(String name, Integer salary) {
        this.name = name;
        this.salary = salary;
    }

    public void increaseSalary() {
        this.salary *= 2;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)// описывает жизненый цикл аннотации
@interface MyAnnotation {
 String os() default "Android";
 int yearOfCompanyCreation() default 2010;
}

@MyAnnotation(os = "Android", yearOfCompanyCreation = 2024)
class Xiaomi{
    String model;
    Integer price;
}

@MyAnnotation(os = "Android")
class Iphone{
    String model;
    Integer price;
}


