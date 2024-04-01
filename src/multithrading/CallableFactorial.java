package multithrading;

import java.util.concurrent.*;
// Callable как и Runnable представляет собой задание которое выполяется потоком
// Callable в отличие от Runnable может выбрасывать эксепшен
// и возвращать значение из потока
public class CallableFactorial {
    private static int factorial;
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> resultCallable = executorService.submit( new FactorialCallable(5));
        try {
            System.out.println("Хотим получить результат");
            System.out.println("Закончился? " + resultCallable.isDone());
            resultCallable.get(); // вернёт значение, только когда завершится задание в потоке
            System.out.println("Получили результат");
            System.out.println("Закончился? " + resultCallable.isDone());
        } catch (ExecutionException e) {
            System.out.println(e.getCause());
        }
        finally {
            executorService.shutdown();
        }
        System.out.println(factorial);
    }
}

class FactorialCallable implements Callable<Integer> {
    int f;
    public FactorialCallable(int f){
        this.f = f;
    }

    @Override
    public Integer call() throws Exception {
        if (f <=0){
            throw new Exception("Вы ввели неверное число");
        }
        int result = 1;
        for (int i = 1; i <= f ; i++) {
            result *= i;
            Thread.sleep(1000);
        }
        return result;
    }
}

