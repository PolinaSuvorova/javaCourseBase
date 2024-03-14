package multithrading;

public class MainRunnableExample implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("run " + i);
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new MainRunnableExample());
        t1.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main " + i);
        }
    }
}
