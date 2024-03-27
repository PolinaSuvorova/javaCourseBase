package multithrading;

// Для решения данной проблемы в примере необходимо
// чтобы последовательность блокировки для объекта 1 и 2 были одинаковы
public class DeadLockExample {
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread10 thread10 = new Thread10();
        Thread20 thread20 = new Thread20();
        thread10.start();
        thread20.start();
    }
}

class Thread10 extends Thread{
    public void run(){
        System.out.println("Thread10: Попытка захватить монитор объекта Lock1");
        synchronized (DeadLockExample.lock1){
            System.out.println("Thread10: Захват монитора объекта Lock1");
            System.out.println("Thread10: Попытка захватить монитор объекта Lock2");
            synchronized (DeadLockExample.lock2){
                System.out.println("Thread10: Захват монитора объекта Lock2 в мониторе Lock1");
            }
        }
    }
}

class Thread20 extends Thread{
    public void run(){
        System.out.println("Thread20: Попытка захватить монитор объекта Lock2");
        synchronized (DeadLockExample.lock2){
            System.out.println("Thread20: Захват монитора объекта Lock2");
            System.out.println("Thread20: Попытка захватить монитор объекта Lock1");
            synchronized (DeadLockExample.lock1){
                System.out.println("Thread20: Захват монитора объекта Lock1 в мониторе Lock2");
            }
        }
    }
}
