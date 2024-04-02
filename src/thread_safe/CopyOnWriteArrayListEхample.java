package thread_safe;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

// На момент создания итератора создаётся копия листа если указано CopyOnWriteArrayList
// При добавлении или удалении также создаётся копия листа
public class CopyOnWriteArrayListEхample {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("test1");
        list.add("test2");
        list.add("test3");
        list.add("test4");
        list.add("test5");
        System.out.println(list);

        Runnable runnable = () -> {
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(iterator.next());
            }
        };
        Runnable runnable2 = () -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list.remove(4);
            list.add("testNewElement");
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable2);
        thread2.start();
        thread1.start();
        thread2.join();
        thread1.join();

        System.out.println(list);
    }
}
