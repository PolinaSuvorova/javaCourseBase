package multithrading;

import java.util.concurrent.CountDownLatch;

// Примерчик для создания локального нагрузочного тестирования
// Создаём 50 потоков и оставляем ждать, пока не уменьшим счётчик
// При вызове countDown все 50 потоков начнут свою работу
// Одноразовое использование в коде
public class CountDownLatchForTestExample {
    public static void main(String[] args) {
        CountDownLatch cd1 = new CountDownLatch(1);
        for (int i = 0; i < 50; i++) {
            new ServiceLoadThread(cd1).start();
        }
        cd1.countDown();
        // assertions
    }
}

class ServiceLoadThread extends Thread {
    CountDownLatch cd1;

    public ServiceLoadThread(CountDownLatch cd1) {
        this.cd1 = cd1;
    }

    @Override
    public void run() {
        // Поток засыпает, когда он проснётся после вызова метода cd1.countDown()
        // вызовется метод service.process() который мы пытаемся протестировать
        // в нагрузочном тестировании
        try {
            cd1.await();

            // service.process()
            // assertion
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}