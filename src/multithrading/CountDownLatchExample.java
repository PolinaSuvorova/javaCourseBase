package multithrading;

import java.util.concurrent.CountDownLatch;

// Синхронизатор, позволяющий ждать любому количеству
// потоков пока не завершатся определенное количество операций
// Внутрь класса передаётся кол-во операций, которые должны завершится,
// чтобы потоки продолжили свою работу
// Обратный отсёт
public class CountDownLatchExample {
    static CountDownLatch countDownLatch = new CountDownLatch(3);
    public static void main(String[] args) throws InterruptedException {
        Friend f1 = new Friend("Test1", countDownLatch);
        Friend f2 = new Friend("Test2", countDownLatch);
        Friend f3 = new Friend("Test3", countDownLatch);
        Friend f4 = new Friend("Test4", countDownLatch);

        // Запускаем действия в отдельных потоках, которые по завершению уменьшат счётчик
        marketStaffIsOnPlce();
        everythingIsReady();
        openMarket();
    }
    private static void marketStaffIsOnPlce() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Market staff came to work");
        countDownLatch.countDown();
        System.out.println(" countDownLatch = " + countDownLatch.getCount());
    }

    private static void everythingIsReady() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Everything is ready to open market");
        countDownLatch.countDown();
        System.out.println(" countDownLatch = " + countDownLatch.getCount());
    }
    private static void openMarket() throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("Market is Opened");
        countDownLatch.countDown();
        System.out.println(" countDownLatch = " + countDownLatch.getCount());
    }
}

class Friend extends Thread{
    String name;
    private CountDownLatch countDownLatch;

    public Friend(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
        this.start();
    }

    @Override
    public void run() {
        // Заблокируем до тех пор пока счётчик не равен 0
        try {
            countDownLatch.await();
            System.out.println(name + " приступил к покупкам");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
