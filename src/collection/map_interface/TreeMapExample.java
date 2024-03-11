package collection.map_interface;

import java.util.TreeMap;

// Элменты хрянтся парами ключ значение. Ключи должны быть уникальны
// Элменты отсортированы по ключу в порядке возвраставния
// В основе лежит красно-чёрное дерево. Не быстрее чем хешмеп. (самобалансирующееся дерево, двоичное дерево)
// Обрабатывается за O(log(n)) итераций
// Если в качестве ключа используется объект, у него обязательно должен быть интерфейс Comparable
// либо при создании переменной необходимо переопределить метод compare
// При работе с треемап нет необходимости переопределять хешкод и иквелс для объекта ключа,
// т.к. все поиски идут по методу compare
// но это правило не работает со значением TreeMap (метод containsValue)
public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<Double, Cat> treeMao = new TreeMap<>();
        Cat cat1 = new Cat("Tom", 2, "red");
        Cat cat2 = new Cat("Jerry", 3, "black");
        Cat cat3 = new Cat("Murzik", 14, "grey");
        Cat cat4 = new Cat("Garry", 3, "white");
        Cat cat5 = new Cat("Basia", 7, "white-grey");
        Cat cat6 = new Cat("Silvestr", 4, "black-white");

        treeMao.put(5.8, cat1);
        treeMao.put(7.8, cat2);
        treeMao.put(9.8, cat3);
        treeMao.put(9.4, cat4);
        treeMao.put(5.0, cat5);
        treeMao.put(5.2, cat6);

        //Выводится по возрастанию
        System.out.println(treeMao);
        System.out.println(treeMao.get(5.0));
        treeMao.remove(5.0);

        // Сортировка по убыванию
        System.out.println(treeMao.descendingMap());

        // Значение больше чем значение в методе
        System.out.println(treeMao.tailMap(5.8));
        // Значение меньше чем значение в методе
        System.out.println(treeMao.headMap(5.8));

        System.out.println(treeMao.lastEntry());
        System.out.println(treeMao.firstEntry());
        TreeMap<Cat, Double> treeMao2 = new TreeMap<>();
        treeMao2.put(cat1, 5.8);
        treeMao2.put(cat2, 7.8);
        treeMao2.put(cat3, 1.9);
        treeMao2.put(cat4, 9.1);
        treeMao2.put(cat5, 8.9);
        treeMao2.put(cat6, 9.0);
        System.out.println(treeMao2);
    }

}
