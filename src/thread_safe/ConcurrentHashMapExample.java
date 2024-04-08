package thread_safe;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// ConcurrentHashMap имплементирует интерфейс ConcurrentMap
// Данный класс позволят одновременно в нескольких сегментах
// (по умолчанию создаются 16 сегментов, т.е. 16 потоков могут изменять читать одновременно
// данные ) изменять элементы. Блокируя его при изменении, не блокируя его при чтении
// Ни key, ни value не могут быть NULL
public class ConcurrentHashMapExample {
    public static void main(String[] args) throws InterruptedException {
        Map<Integer,String> map = new ConcurrentHashMap<>();
        map.put(1,"test1");
        map.put(2,"test2");
        map.put(3,"test3");
        map.put(4,"test4");
        map.put(5,"test5");
        map.put(6,"test6");

        Runnable runnable1 = () -> {
            Iterator<Integer> iterator = map.keySet().iterator();
            while (iterator.hasNext()){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Integer i = iterator.next();
                System.out.println(i + " + " + map.get(i));
            }
        };
        Runnable runnable2 = () -> {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                map.put(6,"NewElement");
                System.out.println("NewElement was added");
        };
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread2.start();
        thread1.start();
        thread2.join();
        thread1.join();

        System.out.println(map);
    }
}
