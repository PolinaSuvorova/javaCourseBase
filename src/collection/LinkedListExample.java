package collection;

import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        Student2 st1 = new Student2("Ivan", 10);
        Student2 st2 = new Student2("Sofia", 10);
        Student2 st3 = new Student2("Daniel", 11);
        Student2 st4 = new Student2("Migel", 11);

        // В основе лежит не массив, а цепочка со ссылками друг на друга
        // Последний и первый элемент ссылается на null
        // Чтобы добраться например до 3 элемента, linkedlist пройдёт все элементы от 1 по связям до 3
        // Порядок добавления сохраняется
        LinkedList<Student2> list = new LinkedList<>();
        list.add(st1);
        list.add(st2);
        list.add(st3);
        list.add(st4);
        System.out.println(list);
        System.out.println(list.get(2));

        // При добавлении новых элементов или удалении изменяюся ттолько ссылки на элемнты у связных
        // Переформатирования всего списка не происхдит как в ArrayList
        Student2 st5 = new Student2("Den", 11);
        Student2 st6 = new Student2("Sam", 11);
        list.add(st5);
        list.add(1, st6);
        System.out.println(list);

        //В LinkedList доступ удаление и вставка к элементам осуществляется со скоростью O(n)
        // т.к. чтобы дойти до места вставки удаления или чтения, необходимо пройти все элементы от начала
        //В LinkedList преимуществом использования является если есть чёткая задача вставки и удаления элементов в первой позиции
        // тогда скорость доступа будет O(1).
    }
}

class Student2 {
    String name;
    int age;

    public Student2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
