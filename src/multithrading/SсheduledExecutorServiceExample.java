package multithrading;

import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// Используется для установки распиасания на запуск потоков из пула
public class SсheduledExecutorServiceExample {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable200() );
        }
        // Выполнится задание ерез три секунды
        executorService.schedule(new Runnable200(),3,TimeUnit.SECONDS);
        executorService.shutdown(); // задания больше не будут передаваться

        //Планиирует задачу для периодического выполнения
        // Впервые выполнится ерез 3 секунды, далее будет запускаться с периодичностью в 1 секунду
        // Если задание будет долше 1 секунды, то будут выполняться поледовательно
        executorService.scheduleAtFixedRate(new Runnable200(),3,1, TimeUnit.SECONDS);
        Thread.sleep(10000);// планирование будет запускаться 10 секунд
        executorService.shutdown(); // задания больше не будут передаваться

        //Планиирует задачу для периодического выполнения
        //Впервые выполнится ерез 3 секунды, далее будет запускаться и между заданиями
        //будет перерыв в 1 секунду
        executorService.scheduleWithFixedDelay(new Runnable200(),3,1, TimeUnit.SECONDS);
        System.out.println("Main ends");

        // Создаёт потоки по необходимости если потоков не хватает
        // по истечению времени если поток не нужен удалит его из пула
        ExecutorService casheExecutorService = Executors.newCachedThreadPool();
    }
}

class Runnable200 implements Runnable {

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