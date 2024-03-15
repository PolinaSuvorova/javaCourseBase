package multithrading;

public class VolatileExample extends Thread {

    // переменная b хранится сейчас в общей памяти
    volatile boolean b = true;
    // без volatile доплнения значение копируется из общей памяти в память кеша потока,
    // чтобы каждый раз не обращаться к общей памяти.
    // т.е. меняя значение в потоке во втором в копии не меняется значение

    @Override
    public void run() {
        long counter = 0;
        while (b) {
            counter++;
        }
        System.out.println("Loop is finished after " + counter + " iterations");
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileExample thread = new VolatileExample();

        thread.start();
        Thread.sleep(1000);
        thread.b = false;
        thread.join();
        System.out.println("End main process");
    }
}
