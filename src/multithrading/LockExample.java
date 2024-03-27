package multithrading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    public static void main(String[] args) {
        Call call = new Call();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                call.mobileCall();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                call.skypeCall();
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                call.watsappCall();
            }
        });

        thread.start();
        thread2.start();
        thread3.start();
    }
}

class Call {
    private Lock lock = new ReentrantLock();

    public void mobileCall() {
        lock.lock();
        try {
            System.out.println("Mobile call starts");
            Thread.sleep(3000);
            System.out.println("Mobile call ends");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void skypeCall() {
        lock.lock();
        try {
            System.out.println("Skype call starts");
            Thread.sleep(5000);
            System.out.println("Skype call ends");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void watsappCall() {
        lock.lock();
        try {
            System.out.println("watsapp call starts");
            Thread.sleep(7000);
            System.out.println("watsapp call ends");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
