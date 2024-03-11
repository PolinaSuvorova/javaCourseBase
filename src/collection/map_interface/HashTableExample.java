package collection.map_interface;
import java.util.Hashtable;
//Устаревший класс использовался в многопоточности
// Ни ключ, ни значение не могут быть null
// Вместо него лучше использовать конкарент хешмеп
public class HashTableExample {
    public static void main(String[] args) {
        Hashtable<Double, Cat> hashTable = new Hashtable<>();
        Cat cat1 = new Cat("Tom", 2, "red");
        Cat cat2 = new Cat("Jerry", 3, "black");
        Cat cat3 = new Cat("Murzik", 14, "grey");
        Cat cat4 = new Cat("Garry", 3, "white");
        Cat cat5 = new Cat("Basia", 7, "white-grey");
        Cat cat6 = new Cat("Silvestr", 4, "black-white");

        hashTable.put(5.8, cat1);
        hashTable.put(7.8, cat2);
        hashTable.put(9.8, cat3);
        hashTable.put(9.4, cat4);
        hashTable.put(5.0, cat5);
        hashTable.put(5.2, cat6);

        //Выводится по возрастанию
        System.out.println(hashTable);
    }
    }

