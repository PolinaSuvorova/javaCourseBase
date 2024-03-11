package collection.set_interface;

import java.util.HashSet;
import java.util.Set;

//В основе лежит хеш меп, вместо знаения в этой меп подставляется константа
//Хешсет это урезанная копия хешмеп
//В хешсет знаения должны быь уникальными. Хеш меп уэто не упорядоченое множество
//Если в качестве значения будет храниться объект, важно чтобы был переопределён метод иквелс и хешкод
public class HashSetExample {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Test1");
        hashSet.add("ATest1");
        hashSet.add("ATest5");
        for (String s : hashSet) {
            System.out.println(s);
        }
        hashSet.remove("Test1");
        System.out.println(hashSet.isEmpty());
        System.out.println(hashSet.contains("Test1"));

        Set<Integer> hashSetInt1 = new HashSet<>();
        hashSetInt1.add(3);
        hashSetInt1.add(5);
        hashSetInt1.add(1);
        hashSetInt1.add(2);
        hashSetInt1.add(8);

        Set<Integer> hashSetInt2 = new HashSet<>();
        hashSetInt2.add(7);
        hashSetInt2.add(4);
        hashSetInt2.add(5);
        hashSetInt2.add(3);
        hashSetInt2.add(8);

//Объединение множест Union
        Set<Integer> hashSetUnion = new HashSet<>(hashSetInt1);
        hashSetUnion.addAll(hashSetInt2);
        System.out.println(hashSetUnion);
//Пересечение множеств Retain
        Set<Integer> hashSetRetain = new HashSet<>(hashSetInt1);
        hashSetRetain.retainAll(hashSetInt2);
        System.out.println(hashSetRetain);
//Разность множеств
        Set<Integer> hashSetRemove = new HashSet<>(hashSetInt1);
        hashSetRetain.removeAll(hashSetInt2);
        System.out.println(hashSetRemove);


    }
}
