package multithrading;

public class SleapExample {
    public static void main(String[] args) {

    }
}

class MyThread6 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000 ; i++) {
            System.out.println("ThreadRun " + i + " " + getName() + "  " + getPriority());
            System.out.println("Thread.currentThread() " + Thread.currentThread().getName());
        }
    }
}
