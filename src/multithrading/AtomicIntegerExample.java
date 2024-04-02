package multithrading;

import java.util.concurrent.atomic.AtomicInteger;

// Операции класса AtomicInteger атомарны и не надо писать синхронайзд
// чтобы потоки не пересекались
public class AtomicIntegerExample {
    static int counter = 0;
    static AtomicInteger counterAtomic = new AtomicInteger(0);
    public synchronized static void increment(){
        counter++;
    }

    public synchronized static void incrementAtomic(){
        AtomicIntegerExample.counterAtomic.incrementAndGet(); // +1
        AtomicIntegerExample.counterAtomic.addAndGet(5); // +5
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyRunnable18());
        Thread thread2 = new Thread(new MyRunnable18());
        thread2.start();
        thread1.start();
        thread1.join();
        thread2.join();
        System.out.println(counterAtomic);
    }
}

class MyRunnable18 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            AtomicIntegerExample.incrementAtomic();
         //   AtomicIntegerExample.increment();
        }
    }
}