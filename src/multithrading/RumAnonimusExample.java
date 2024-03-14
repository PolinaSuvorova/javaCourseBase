package multithrading;

public class RumAnonimusExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1000; i > 0; i--) {
                    System.out.println("Thread1 " + i);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1000; i > 0; i--) {
                    System.out.println("Thread2 " + i);
                }
            }
        });
        t1.start();
        t2.start();

    }
}
