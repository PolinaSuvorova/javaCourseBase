package collection.queue_interface;

import java.util.LinkedList;
import java.util.Queue;

// Queue последовательность элементов добавляющихся в конец очереди, используется
// из наала очереди (правило FIFO)
public class LinkedListExample {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("Test1");
        queue.add("Test2");
        queue.add("Test3");
        queue.add("Test4");
        queue.offer("Test4"); // не выбрасывает исключение как add при добавлении
        System.out.println(queue);
        System.out.println("First element " + queue.element());
        System.out.println(queue.remove()); // удаляется элемент который был добавлен первым
        System.out.println("First element " + queue.element()); // показывает первый элемент в коллекции
        System.out.println(queue.poll()); // удаляется элемент, но не выбрасывает эксепшен при отсутсвии элемнтов в очереди
        System.out.println("First element " + queue.element());
        System.out.println("First element " + queue.peek());// выводит 1 элемнт но без эксепшена если его нет

    }
}
