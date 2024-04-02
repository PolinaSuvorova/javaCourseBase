package thread_safe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


// Синхронизация позволяет не пересекать два потока по удалению и чтению данных
// Исключает ошибки при прохождении по коллекции удаление элемента в этот момент

public class SynchronizedCollectionExample2 {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> source = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            source.add(i);
        }
        List<Integer> sincList = Collections.synchronizedList(source);

        Runnable runnable1 = () -> {
            synchronized (sincList) {
                Iterator<Integer> iterator = sincList.iterator();
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }
            }
        };
        Runnable runnable2 = () -> {
            sincList.remove(10);
            System.out.println("Удаление элемента");
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(source);
    }
}
