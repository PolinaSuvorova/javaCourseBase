package thread_safe;

import java.util.concurrent.ArrayBlockingQueue;

// Потоко безопасная очередь с ограниченным размером
// Добавляет в конец берёт из начала
// put и take ожидают доступные ресурсы
public class ArrayBlockingQueueExample {
    public static void main(String[] args) {
        // Оередь содержит только 4 элемента
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(4);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println(queue);
        queue.offer(5); // 5 не добавитс и не будет ошибки если бы сделали через add

        // Producer
        new Thread(() -> {
            int i = 0;
            while (true) {
                i++;
                try {
                    queue.put(i);
                    System.out.println("Producer added " + i);
                    System.out.println(queue);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        // Consumer
        new Thread(() -> {

            while (true) {
                try {
                    Integer j = queue.take();
                    System.out.println("Consumer take " + j);
                    System.out.println(queue);
                    Thread.sleep(9000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

    }
}
