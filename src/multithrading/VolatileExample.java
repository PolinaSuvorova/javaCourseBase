package multithrading;

public class VolatileExample extends Thread {

    // c volatile переменная b хранится сейчас в общей памяти
    // при синхронизаци потоков volotail испольуется только
    // если только один из потоков её меняет, а остальные только читают
    // Основной механизм волатайл это ограничение оптимизации доступа к памяти в JVM
    // Реализация зависит JVM и от ОС
    volatile boolean b = true;
    // без volatile значение копируется из общей памяти в память кеша потока,
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
        Thread.sleep(1000);//для потока Main
        thread.b = false; // без volotaile значение не поменяется в потоке thread
                         // и изменяя в Main метод не казончит свою работу
        thread.join();
        System.out.println("End main process");
    }
}
