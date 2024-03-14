package collection.set_interface;

import collection.map_interface.Cat;

import java.util.Set;
import java.util.TreeSet;

//В основе лежит трии меп, вместо знаения в этой меп подставляется константа
//Триисет это урезанная копия триимеп. Отсортированы по возрастанию
//Не может быть нулевых элментов
//Хранит элменеты в отсортированном порядке элементы
//Должен быть интерфейс Cjmparable или переопределён метод comparator при объявлении триисет
//хешкод и иквелс необязательны
public class TreeSetExample {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        set.add(3);
        set.add(5);
        set.add(1);
        set.add(2);
        set.add(8);
        System.out.println(set);
        set.remove(1);

        Set<Cat> setCat = new TreeSet<>();

        Cat cat1 = new Cat("Tom", 2, "red");
        Cat cat2 = new Cat("Jerry", 3, "black");
        Cat cat3 = new Cat("Murzik", 14, "grey");
        setCat.add(cat1);
        setCat.add(cat2);
        setCat.add(cat3);
        System.out.println(setCat.contains(cat2));
    }
}
