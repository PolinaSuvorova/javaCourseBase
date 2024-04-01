package multithrading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Для ограничения количества потоков вводят пул потоков
// Пул потоков нацелен на выполнение той или иной задач
public class ThreadPoolExample1 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable100() );
        }
        executorService.shutdown(); // закрытие пула потоков чтобы не было ожидания
        executorService.awaitTermination(5, TimeUnit.SECONDS);// принуждает поток подождать либо 5
                                                                     // сек либо конца выполнения заданий
        System.out.println("Main ends");
    }


}
class Runnable100 implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}