package multithrading;

public class SynchronizedMethodsExample {

    // Синхронизация вещается на объект целиком или Класс
    static final Object lock = new Object();


    public static void main(String[] args) {
        Thread t1 = new Thread(new RunnableImpMobile());
        Thread t3 = new Thread(new RunnableImpSkype());
        Thread t2 = new Thread(new RunnableImpWatsapp());

        t1.start();
        t2.start();
        t3.start();
    }

    void mobileCall() {
        synchronized (lock) {
            System.out.println("Mobile call starts");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Mobile call ends");
        }
    }

    void watsappCall() {
        synchronized (lock) {
            System.out.println("watsapp call starts");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("watsapp call ends");
        }
    }

    void skypeCall() {
        synchronized (lock) {
            System.out.println("skype call starts");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("skype call ends");
        }
    }
}

class RunnableImpMobile implements Runnable {
    @Override
    public void run() {
        new SynchronizedMethodsExample().mobileCall();
    }
}

class RunnableImpSkype implements Runnable {
    @Override
    public void run() {
        new SynchronizedMethodsExample().skypeCall();
    }
}

class RunnableImpWatsapp implements Runnable {
    @Override
    public void run() {
        new SynchronizedMethodsExample().watsappCall();
    }
}

class SynchObjImpl {

}