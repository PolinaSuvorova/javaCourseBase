package collection.queue_interface;

import collection.map_interface.Cat;

import java.util.PriorityQueue;
import java.util.Queue;

// Очередь с сортировкой коллекции через компаратор или интерфейс компарабле в объекте
// Ипользует чтение элементов по приоритету, независимо от порядка их добавления
public class PriorityQueueExamp1 {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(10);
        queue.add(8);
        queue.add(9);
        queue.add(4);

        System.out.println(queue);// выведет необязательно в порядке возврастания, но читает удаляет по приоритету
        System.out.println(queue.peek()); // 1 4 8 9 10  - наивысший приоритет у 1
        queue.poll();
        System.out.println(queue.peek());
// обязательно должен быть сомпаратор или интерфейс компарабле
        Queue<Cat> queueCat = new PriorityQueue<>();
        Cat cat1 = new Cat("Tom", 2, "red");
        Cat cat2 = new Cat("Jerry", 3, "black");
        Cat cat3 = new Cat("Murzik", 14, "grey");
        queueCat.add(cat1);
        queueCat.add(cat2);
        queueCat.add(cat3);
        System.out.println(queueCat);
    }
}
