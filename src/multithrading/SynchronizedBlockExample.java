package multithrading;

public class SynchronizedBlockExample {
    public static void main(String[] args) throws InterruptedException {
        MyThread7 r1 = new MyThread7();

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);
        Thread t3 = new Thread(r1);

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();

        System.out.println("End " + Counter.count);
    }
}

class Counter2 {
    static int count = 0;
    public static void increment() {
        synchronized (Counter2.class) {
            Counter2.count++;
            System.out.print(Counter2.count + " ");
            System.out.println(Thread.currentThread().getName());
        }
    }
}

class MyThread8 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            Counter2.increment();
        }
    }
}
