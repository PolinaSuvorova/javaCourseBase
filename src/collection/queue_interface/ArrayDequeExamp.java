package collection.queue_interface;

import java.util.ArrayDeque;
import java.util.Deque;

//Двунправленная очередь, можем либо добавлять в конец либо вначало
// и работать также можем и с конца и с начала (FIFO  и LIFO)
// реализуется LinkedList и ArrayDeque
public class ArrayDequeExamp {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(3);
        deque.addFirst(2);
        deque.offerFirst(5);
        deque.addLast(9);
        deque.addLast(8);
        deque.offerLast(1);
        deque.offerLast(1);
        System.out.println(deque);
        deque.removeFirst();
        System.out.println(deque);
        deque.pollFirst();
        System.out.println(deque);
        deque.removeLast();
        deque.pollLast();
        System.out.println(deque);
        System.out.println(deque.getFirst());
        System.out.println(deque.peekFirst());
        System.out.println(deque.getLast());
        System.out.println(deque.peekLast());

    }
}
