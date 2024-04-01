package multithrading;

import java.util.concurrent.Semaphore;

// Semaphore - устанавливает количество разрешений
// для одновременного пользования ресурсом
// Если разрешений 1, то работает как Lock
public class SemaforExample {
    public static void main(String[] args) {
        // Два потока могут пользоваться ресурсом одновременно
        Semaphore callBox = new Semaphore(2);
        new Person("Test1", callBox);
        new Person("Test2", callBox);
        new Person("Test3", callBox);
        new Person("Test4", callBox);
        new Person("Test5", callBox);
    }
}
class Person extends Thread{
    String name;
    private Semaphore callBox;

    public Person(String name, Semaphore callBox) {
        this.name = name;
        this.callBox = callBox;
        this.start();
    }

    @Override
    public void run() {
        try {
        System.out.println(name + "ждёт");
            // Попытка получения разрешения от семаформа на общий ресурс
            // Блокируем одним из потоков после получения ресурса
            callBox.acquire();
            System.out.println(name + " пользуется ресурсом(телефоном)");
            Thread.sleep(2000);
            System.out.println(name + " завершил пользованием телевона");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            // освобождаем разрешение у симаформа (счётчик разрешений увеличивается)
            callBox.release();
        }
    }
}
