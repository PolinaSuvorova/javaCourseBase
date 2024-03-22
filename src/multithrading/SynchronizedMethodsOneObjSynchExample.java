package multithrading;

// Вывод последовательных звонков
public class SynchronizedMethodsOneObjSynchExample {

    // Синхронизация вещается на объект целиком или Класс
    // Если указать в методе синхронизацию,
    // то у каждого будет свой монитор и будет синхронизация по разным объектам
    // чтобы не было этого синхронизируем по одному объекту
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
        new SynchronizedMethodsOneObjSynchExample().mobileCall();
    }
}

class RunnableImpSkype implements Runnable {
    @Override
    public void run() {
        new SynchronizedMethodsOneObjSynchExample().skypeCall();
    }
}

class RunnableImpWatsapp implements Runnable {
    @Override
    public void run() {
        new SynchronizedMethodsOneObjSynchExample().watsappCall();
    }
}

class SynchObjImpl {

}