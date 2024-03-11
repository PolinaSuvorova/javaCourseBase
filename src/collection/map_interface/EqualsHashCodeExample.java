package collection.map_interface;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// дефолтный вид equals сравнение через == двух объектов
// При переопределении equals переопредели и hashCode при работе с коллекцией HashMap
// ХешКод Преобразует любой объект в int. При поиске вроде бы одинаковых значений без него будет false
// Если определим хешкод но не определим equals, то также при поиске будет false по причине что сначала сравнение идёт
// по хешкоду а потом по иквелс
public class EqualsHashCodeExample {
    public static void main(String[] args) {
        Map<Cat, Double> map = new HashMap<>();
        Cat cat1 = new Cat("Tom", 2, "red");
        Cat cat2 = new Cat("Jerry", 3, "black");
        Cat cat3 = new Cat("Murzik", 14, "grey");

        map.put(cat1, 7.5);
        map.put(cat2, 6.5);
        map.put(cat3, 4.0);

        System.out.println(map);
        Cat catCopy3 = new Cat("Murzik", 14, "grey");
        boolean result = map.containsKey(catCopy3);
        System.out.println(result);// без переопределения хешкода result будет false
        // Некоторые коллекции при поиске используют hasрCode и HasSet.
        System.out.println("CatCopy3 " + catCopy3.hashCode());
        System.out.println("Cat3 " + cat3.hashCode());

        for (Map.Entry<Cat, Double> mapEntry : map.entrySet()) {
            System.out.println(mapEntry.getKey() + " " + mapEntry.getValue());
        }

    }
}

