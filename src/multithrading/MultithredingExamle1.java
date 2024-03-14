package multithrading;

public class MultithredingExamle1 {
    public static void main(String[] args) {

        // Последовательное выполнение
        System.out.println("Start");
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        System.out.println("End");

        //
    }
}

class MyThread1 extends  Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000 ; i++) {
            System.out.println(i);
        }
    }
}

class MyThread2 extends  Thread{
    @Override
    public void run() {
        for (int i = 1000; i > 0 ; i--) {
            System.out.println(i);
        }
    }
}
