package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        // Создание ArrayList
        ArrayList<String> arrayList = new ArrayList<>(3);//массив размером 3
        arrayList.add("Test1");
        arrayList.add("Test2");
        arrayList.add("Test3");
        System.out.println(arrayList);

        List<String> arrayList2 = new ArrayList<>();
        ArrayList<String> arrayList3 = new ArrayList<>(arrayList);

        System.out.println(arrayList3);
        System.out.println(arrayList3 == arrayList);

        //Методы
        arrayList.add(0, "Test31");//добавление элемента
        String name = arrayList.get(0); // выбор элемента по индексу
        System.out.println(name);
        System.out.println(arrayList);
        arrayList.set(1, "Masha"); // замена элемента по индексу
        System.out.println(arrayList);
        arrayList.remove(0);//Удаление по индексу
        arrayList.remove("Test2");
        System.out.println(arrayList);

        // удаление по объекту
        Dog dog1 = new Dog("Sharik", 3);
        Dog dog2 = new Dog("Tuzik", 4);
        Dog dog3 = new Dog("Garry", 3);
        Dog dog4 = new Dog("Joni", 14);
        List<Dog> dogs = new ArrayList<>();
        dogs.add(dog1);
        dogs.add(dog2);
        dogs.add(dog3);
        dogs.add(dog4);
        System.out.println(dogs);
        Dog dog5 = new Dog("Joni", 14);
        dogs.remove(dog5); // удаление происходит по методу equals. Без него проверялись бы ссылки
        System.out.println(dogs);

        //Добавление массива элементов во второй массив
        ArrayList<String> arrayList4 = new ArrayList<>();
        arrayList4.add("Test4");
        arrayList4.addAll(0, arrayList);
        // Очистка
        arrayList4.clear();
        // Поиск индекса по элементу
        int ind = dogs.indexOf(dog3);
        System.out.println(ind);

        StringBuilder sb1 = new StringBuilder("Aa");
        StringBuilder sb2 = new StringBuilder("Dd");
        StringBuilder sb3 = new StringBuilder("Cc");
        StringBuilder[] array = { sb1,sb2,sb3 };
        List<StringBuilder> list = Arrays.asList(array); // Длинна листа всегда такая же как и у массива
        array[0].append("!!!");
        System.out.println(list);
        array[0] = new StringBuilder("fF");
        // Доступ к элементам по индексу в ArrayList осуществляется за време O(1), т.к. в массиве все элементы хранятся подряд,
        // то адрес искомого элемента может быть расчитан по формуле. Начало_массива + индекс * байт_от_элемента_массива
        // При использовании массива объектов, в самом элементе хранится адрес объекта в памяти. Адрес занимает 8 байт,
        // поэтому для него также можно рассчитать адрес индекса в массиве
        // Удаление и вставка происходит за время o(n), т.к. массив не может менять свой размер после инициализации, то при вставке нового элемента
        // все элементы включая новый копируются в новый массив. Тоже самое с удалением - при удалении первого элемента,
        // весь массив сдвигается на один элемент при перерисовки
    }
}

class Dog {
    private String name;
    private Integer age;

    public Dog(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dog dog = (Dog) o;

        if (getName() != null ? !getName().equals(dog.getName()) : dog.getName() != null) return false;
        return getAge() != null ? getAge().equals(dog.getAge()) : dog.getAge() == null;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
//    @Override
//    public int hashCode() {
//        int result = getName() != null ? getName().hashCode() : 0;
//        result = 31 * result + (getAge() != null ? getAge().hashCode() : 0);
//        return result;
//    }
}
