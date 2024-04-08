package thread_safe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


// + Любая реализация коллекции в обёртке
// + Нет коллизий в данных
// - Медленный
// - Обход коллекции не синхронизирован
// - Нет атомарных операций
public class SynchronizedCollectionExample {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> source = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            source.add(i);
        }
      //   ArrayList<Integer> target = new ArrayList<>();
        List<Integer> syncTarget =
                Collections.synchronizedList(new ArrayList<>());
        Runnable runnable = () -> {syncTarget.addAll(source);};
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread2.start();
        thread1.start();
        thread2.join();
        thread1.join();

        System.out.println(syncTarget);
    }
}
