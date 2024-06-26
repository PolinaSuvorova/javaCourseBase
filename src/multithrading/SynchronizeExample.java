package multithrading;

public class SynchronizeExample {
    public static void main(String[] args) throws InterruptedException {
        MyThread7 r1 = new MyThread7();
        Thread t1  = new Thread(r1);
        Thread t2  = new Thread(r1);
        Thread t3  = new Thread(r1);

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("End " + Counter.count);
    }
}

class Counter{
  volatile static int count = 0; // volatile - отправляем в общую память

    // чтобы не было рассинхронизации вставляем слово synchronized
   // операция ++ читает добавлет и заисывает значение потом выводит эту переменную,
   // т.е. не атомарная операция
    // т.к. на выполнение работы тратится разное время в потоках независимо друг от дурга
    // то может произойти непредсказуемое изменение значения между операциями
    public synchronized static void increment() {
        Counter.count++;
        System.out.print(Counter.count + " ");
        System.out.println(Thread.currentThread().getName());
    }
}
class MyThread7 implements Runnable {
        @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            Counter.increment();
        }
    }
}