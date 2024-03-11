package collection.map_interface;

//Наследник хешмеп.Хранит инфо о порядке добавления элементов. Производительность хуже чем у хешмеп

import java.util.LinkedHashMap;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        LinkedHashMap<Double, Cat> linkedMap = new LinkedHashMap<>(
                16,
                0.75f,
                true); // перемещает элементы в порядке их использования
        Cat cat1 = new Cat("Tom", 2, "red");
        Cat cat2 = new Cat("Jerry", 3, "black");
        Cat cat3 = new Cat("Murzik", 14, "grey");
        Cat cat4 = new Cat("Garry", 3, "white");
        Cat cat5 = new Cat("Basia", 7, "white-grey");
        Cat cat6 = new Cat("Silvestr", 4, "black-white");

        linkedMap.put(5.8, cat1);
        linkedMap.put(7.8, cat2);
        linkedMap.put(9.8, cat3);
        linkedMap.put(9.4, cat4);
        linkedMap.put(5.0, cat5);
        linkedMap.put(5.2, cat6);
        System.out.println(linkedMap);
        System.out.println(linkedMap.get(5.8));
        System.out.println(linkedMap.get(7.8));
        System.out.println(linkedMap);
    }
}
