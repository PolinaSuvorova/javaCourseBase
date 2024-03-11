package collection.map_interface;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        // Не хранит порядок добавления,
        // могут быть null элементы в ключе и в значении
        // Поиск выполняется за O(1)
        // ключ должен быть уникален
        // Ключи должны быть не изменяемыми!!, достигается установкой в объекте в полях и классе final
        // Иначе по хешкоду никогда не найдётся нужный элмент
        // тип String неизменяяемый объект, наилучшим образом подходит под ключ
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1000, "Polina");
        map1.put(2000, "Daniel");
        map1.put(3000, "Irina");
        map1.put(1000, "Ali"); // дубликат перезаишется с Polina на Ali
        map1.put(5000, "Olga");
        map1.put(6000, "Olga");
        map1.putIfAbsent(6000, "NnnOlga"); // Довляет элемент по ключу если его нет
        map1.put(null, null);
        map1.put(11111, null);
        System.out.println(map1);
        System.out.println(map1.get(2000));
        System.out.println(map1.get(7000));
        map1.remove(1000);
        System.out.println(map1);
        System.out.println(map1.containsValue("Ali"));
        System.out.println(map1.containsKey(5000));
        System.out.println(map1.keySet()); // множество ключей
        System.out.println(map1.values()); // множество значений
// loadFactor это процент добавления элементов, после которого будет увеличен массив на initialCapacity
        // в примере 16 элементов массива, если будет добавлен 16*0.75 = 12 элемент,
        // то размер массива увеличится на ещё 16 и все элементы массива будут рехешированы
        // будут переопределены все индексы по которым распределены элменты LinkedList
        // чем меньше loadFactor и больше initialCapacity, тем больше памяти будет выделяться на массив, но тем меньше будут linkedList
        Map<Integer, String> map2 = new HashMap<>(16, 0.75f);
    }

}
