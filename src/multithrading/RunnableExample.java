package multithrading;

public class RunnableExample {
    public static void main(String[] args) {

        // Параллельный запуск не синхронизированых потоков
        Thread t1 = new Thread(new MyThread3());
        Thread t2 = new Thread(new MyThread4());

        //Запуск, который запускает run
        t1.start();
        t2.start();
    }
}

class MyThread3 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Thread3 " + i);
        }
    }
}

class MyThread4 implements Runnable {
    @Override
    public void run() {
        for (int i = 1000; i > 0; i--) {
            System.out.println("Thread4 " + i);
        }
    }
}
