package multithrading;

public class PriorityExample {
    public static void main(String[] args) {
        MyThread5 t5 = new MyThread5();
        t5.setName("MyThread5");
        t5.setPriority(Thread.MIN_PRIORITY);
        System.out.println("name + " + t5.getName() + " Priority " + t5.getPriority());
        System.out.println("Thread.currentThread() " + Thread.currentThread().getName());
        MyThread5 t6 = new MyThread5();
        System.out.println("name + " + t6.getName() + " Priority " + t6.getPriority());
        t6.run();   // Запускает как часть потока main
        t6.start(); // Запускается как отдельный поток
        t5.start();

    }
}

class MyThread5 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000 ; i++) {
            System.out.println("ThreadRun " + i + " " + getName() + "  " + getPriority());
            System.out.println("Thread.currentThread() " + Thread.currentThread().getName());
        }
    }
}
