package multithrading;

//Для извещения потоком других потоков о своих действиях используются методы
// notify - не освобождает монитор и будит поток, у которого был ранее вызван метод wait
// wait - освобождает монитор и переводит вызывающий поток в состояние
// ожидание до тех пор пока другой поток не вызовет метод notify
// notifyAll
// Задача: максимум в магазине может быть 5 шт товара.
// Поставщик добавляет, когда товара не хватает (всего 10 шт товара)
// Потребитель покупает когда товар доступен (всего может купить 10 штук товара)
public class WaitNotifySynch {
    public static void main(String[] args) {
        Market market = new Market();
        Producer producer = new Producer(market);
        Consumer consumer = new Consumer(market);
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);
        t1.start();
        t2.start();
    }
}

class Market {
    private int breadCount = 0;

    public synchronized void getBread() {
        while (breadCount < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        breadCount--;
        System.out.println("Потребитель купил 1 хлеб и осталось " + breadCount);
        notify();
    }

    public   void putBread() {
        while (breadCount >= 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        breadCount++;
        System.out.println("Хлеб добавлен и готов к покумке " + breadCount);
        notify();
    }
}

class Producer implements Runnable {
    Market market;

    Producer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.putBread();
        }
    }
}

class Consumer implements Runnable {
    Market market;

    Consumer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.getBread();
        }
    }
}
