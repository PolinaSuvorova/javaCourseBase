package multithrading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockExample {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        new Employee("Polina"  , lock);
        new Employee("Olya"    , lock);
        new Employee("Natasha" , lock);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        new Employee("Daniel"  , lock);
    }

}

class Employee extends Thread{
    private String name;
    private Lock lock;
    public Employee(String name, Lock lock){
        this.name = name;
        this.lock = lock;
        this.start();
    }
    @Override
    public void run(){
        if (lock.tryLock()) {
//        System.out.println(name + " ждёт ...." );
//        lock.lock();
            System.out.println(name + " пользуется банкоматом ");
            try {
                Thread.sleep(2000);
                System.out.println(name + " завершил операцию ");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }else {
            System.out.println(name + " не хочет ждать и уходит");
        }


    }
}
