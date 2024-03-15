package multithrading;

public class SleepExample extends Thread {

    @Override
    public void run() {
        for (int i = 5; i > 0; i--) {
            try {
                Thread.sleep(1000); // 1 second = 1000 millis
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        System.out.println("State in method run of " + getName() + " is " + getState());
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 5; i > 0; i--) {
            System.out.println(i);
            Thread.sleep(1000); // 1 second = 1000 millis
        }
        System.out.println("Start");

        Thread thread1 = new Thread(new MyRannable());
        SleepExample thread2 = new SleepExample();

        System.out.println("State in method main before start of " + thread1.getName() + " is " + thread1.getState());
        System.out.println("State in method main before start of " + thread2.getName() + " is " + thread2.getState());

        thread1.start();
        thread2.start();

        System.out.println("State after start of " + thread1.getName() + " is " + thread1.getState());
        System.out.println("State after start of " + thread2.getName() + " is " + thread2.getState());

        // Ожидание завершения работы потоков
        thread1.join();
        thread2.join();

        System.out.println("State after join of " + thread1.getName() + " is " + thread1.getState());
        System.out.println("State after join of " + thread2.getName() + " is " + thread2.getState());

        System.out.println("End Main Thread");
    }
}

class MyRannable implements Runnable {
    @Override
    public void run() {
        for (int i = 5; i > 0; i--) {
            try {
                Thread.sleep(1000); // 1 second = 1000 millis
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
