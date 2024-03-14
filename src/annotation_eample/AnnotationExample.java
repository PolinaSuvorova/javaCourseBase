package annotation_eample;

import java.lang.annotation.Annotation;

public class AnnotationExample {
    public static void main(String[] args) throws ClassNotFoundException {
        Parent c = new Child("Test");

        Class xiamyClass = Class.forName("annotation_eample.Xiomi");
        Annotation a1 = xiamyClass.getAnnotation(MyAnnotation.class);
        MyAnnotation sm1 = (MyAnnotation) a1;
        System.out.println(sm1.os() + " " + sm1.yearOfCompanyCreation());
    }
}

class Parent {
    String name;

    public Parent(String name) {
        this.name = name;
    }

    void showInfo() {
        System.out.println("It is Parent class name=" + name);
    }

    //Устаревший метод
    @Deprecated
    void showInfo2() {
        System.out.println("It is Child class name=" + name);
    }
}

class Child extends Parent {

    public Child(String name) {
        super(name);
    }

    // Переопределение метода
    @Override
    void showInfo() {
        System.out.println("It is Child class name=" + name);
    }
}
