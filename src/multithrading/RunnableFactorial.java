package multithrading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class RunnableFactorial {
    static int factorial;
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute( new Factorial(5));
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(factorial);

        // Запуск раннабл через submit
        executorService = Executors.newSingleThreadExecutor();
        Future future = executorService.submit(new Factorial(5) );
        System.out.println(future.isDone());
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(future.isDone());
    }
}

class Factorial implements Runnable{
int f;
public Factorial(int f){
    this.f = f;
}
    @Override
    public void run() {
        if (f <=0){
            System.out.println("Вы ввели неверное число");
            return;
        }
        int result = 1;
        for (int i = 1; i <= f ; i++) {
            result *= i;
        }
        RunnableFactorial.factorial = result;
    }
}
