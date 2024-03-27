package multithrading;

public class InterruptionExample {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main start");
        InterruptedThread thread = new InterruptedThread();
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
        thread.join();
        System.out.println("main end");

    }
}

class InterruptedThread extends Thread{
    double sqrtSum = 0;
    public void run(){

        for (int i = 0; i < 100000000; i++) {
            if (interrupted()){
                System.out.println("Поток хотят прервать");
                break;
            }
            sqrtSum+=Math.sqrt(i);

            try {
                sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Поток хотят прервать во время сна. Завершаем его работу");
                break;
            }
        }
        System.out.println(sqrtSum);
    }
}
